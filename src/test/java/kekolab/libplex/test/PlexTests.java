package kekolab.libplex.test;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.hc.client5.http.auth.CredentialsProvider;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.CredentialsProviderBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpHost;
import org.junit.jupiter.api.BeforeAll;

import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexHTTPClient;
import kekolab.javaplex.PlexHTTPClientBuilder;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexResources;

public abstract class PlexTests {
	private static PlexHTTPClient client;
	private static String token;
	private static PlexMediaServer server;

	protected static PlexHTTPClient getClient() {
		return client;
	}

	protected static String getToken() {
		return token;
	}

	protected static PlexMediaServer getServer() {
		return server;
	}

	@BeforeAll
	public static void staticInit() throws IOException  {
		Properties props = new Properties();
		props.load(PlexTests.class.getResourceAsStream("/testVariables.properties"));
		String proxyHost = props.getProperty("proxyHost");
		PlexHTTPClientBuilder plexClientBuilder = null;
		if (proxyHost != null && !proxyHost.isBlank()) {
			int proxyPort = Integer.parseInt(props.getProperty("proxyPort"));
			String proxyUsername = props.getProperty("proxyUser");
			String proxyPassword = props.getProperty("proxyPass");
			HttpHost proxy = new HttpHost(proxyHost, proxyPort);
			CredentialsProvider cp = CredentialsProviderBuilder.create()
					.add(proxy, new UsernamePasswordCredentials(proxyUsername, proxyPassword.toCharArray())).build();
			HttpClientBuilder clientBuilder = HttpClientBuilder.create().setProxy(proxy)
					.setDefaultCredentialsProvider(cp);
			plexClientBuilder = new PlexHTTPClientBuilder(clientBuilder);
		} else {
			plexClientBuilder = new PlexHTTPClientBuilder();
		}
		plexClientBuilder.withPlexProduct(props.getProperty("plexProduct"))
				.withPlexProductVersion(props.getProperty("plexProductVersion"))
				.withPlexClientIdentifier(props.getProperty("plexClientIdentifier"));

		client = plexClientBuilder.build();
		token = props.getProperty("authToken");

		PlexDevice server = new PlexResources(client, token).getDevices().stream()
				.filter(PlexDevice::isServer).findAny().orElseThrow();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		PlexTests.server = server.toServer(connection);
	}

	protected String randomString() {
        String s = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String ret = new String();
        for (int i = 0; i < 10; i++)
            ret += s.charAt(random.nextInt(s.length()));
        return ret;
    }
}
