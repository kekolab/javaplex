package kekolab.libplex.test;

import java.io.IOException;
import java.util.Properties;

import org.apache.hc.client5.http.auth.CredentialsProvider;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.CredentialsProviderBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpHost;
import org.junit.jupiter.api.BeforeAll;

import kekolab.javaplex.PlexApi;

public class PlexTests {
	private static PlexApi api;

	static PlexApi getApi() {
		return api;
	}

	@BeforeAll
	public static void initApi() throws IOException {
		Properties props = loadProperties();
		api = initBuilderAndConfigureProxy(props).withPlexProduct(props.getProperty("plexProduct"))
				.withPlexProductVersion(props.getProperty("plexProductVersion"))
				.withPlexClientIdentifier(props.getProperty("plexClientIdentifier"))
				.build();
		String token = props.getProperty("authToken");
		if (token != null)
			api.withToken(token);
	}

	private static PlexApi.Builder initBuilderAndConfigureProxy(Properties props) {
		String proxyHost = props.getProperty("proxyHost");
		if (proxyHost == null || proxyHost.isBlank())
			return PlexApi.Builder.withDefaultHttpClient();

		int proxyPort = Integer.parseInt(props.getProperty("proxyPort"));
		String proxyUsername = props.getProperty("proxyUser");
		String proxyPassword = props.getProperty("proxyPass");
		HttpHost proxy = new HttpHost(proxyHost, proxyPort);
		CredentialsProvider cp = CredentialsProviderBuilder.create()
				.add(proxy, new UsernamePasswordCredentials(proxyUsername, proxyPassword.toCharArray())).build();
		HttpClientBuilder clientBuilder = HttpClientBuilder.create().setProxy(proxy)
				.setDefaultCredentialsProvider(cp);
		return PlexApi.Builder.withCustomHttpClient(clientBuilder);
	}

	private static Properties loadProperties() throws IOException {
		Properties props = new Properties();
		props.load(PlexTests.class.getResourceAsStream("/testVariables.properties"));
		return props;
	}
}
