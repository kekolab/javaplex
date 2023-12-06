package kekolab.javaplex;

import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Logger;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.protocol.HttpContext;

public class PlexHTTPClientBuilder {		
	private String plexClientIdentifier;
	private String plexDevice;
	private String plexDeviceName;
	private String plexPlatform;
	private String plexPlatformVersion;
	private String plexProduct;
	private String plexProductVersion;
	private List<String> plexProvides;
	private HttpClientBuilder clientBuilder;
	
	private static final Logger LOGGER = Logger.getLogger("kekolab.javaplex");

	public PlexHTTPClientBuilder() {
		this(HttpClientBuilder.create());
	}

	public PlexHTTPClientBuilder(HttpClientBuilder builder) {
		this.clientBuilder = builder;
	}

	public PlexHTTPClientBuilder withPlexClientIdentifier(String plexClientIdentifier) {
		this.plexClientIdentifier = plexClientIdentifier;
		return this;
	}

	public PlexHTTPClientBuilder withPlexDevice(String plexDevice) {
		this.plexDevice = plexDevice;
		return this;
	}

	public PlexHTTPClientBuilder withPlexDeviceName(String plexDeviceName) {
		this.plexDeviceName = plexDeviceName;
		return this;
	}

	public PlexHTTPClientBuilder withPlexPlatform(String plexPlatform) {
		this.plexPlatform = plexPlatform;
		return this;
	}

	public PlexHTTPClientBuilder withPlexPlatformVersion(String plexPlatformVersion) {
		this.plexPlatformVersion = plexPlatformVersion;
		return this;
	}

	public PlexHTTPClientBuilder withPlexProduct(String plexProduct) {
		this.plexProduct = plexProduct;
		return this;
	}

	public PlexHTTPClientBuilder withPlexProductVersion(String plexProductVersion) {
		this.plexProductVersion = plexProductVersion;
		return this;
	}

	public PlexHTTPClientBuilder withPlexProvides(List<String> plexProvides) {
		this.plexProvides = plexProvides;
		return this;
	}		

	public PlexHTTPClient build() {
		return new PlexHTTPClient(buildHttpClient());
	}

	private CloseableHttpClient buildHttpClient() {					
		clientBuilder.addRequestInterceptorFirst((request, entity, context) -> { 
			request.setHeader("Accept", "application/json");
			if (plexProduct != null)
				request.setHeader(PlexHTTPClient.HEADER_X_PLEX_PRODUCT, plexProduct);
			if (plexProductVersion != null)
				request.setHeader(PlexHTTPClient.HEADER_X_PLEX_VERSION, plexProductVersion);
			if (plexClientIdentifier != null)
				request.setHeader(PlexHTTPClient.HEADER_X_PLEX_CLIENT_IDENTIFIER, plexClientIdentifier);
			if (plexPlatform != null)
				request.setHeader(PlexHTTPClient.HEADER_X_PLEX_PLATFORM, plexPlatform);
			if (plexPlatformVersion != null)
				request.setHeader(PlexHTTPClient.HEADER_X_PLEX_PLATFORM_VERSION, plexPlatformVersion);
			if (plexDevice != null)
				request.setHeader(PlexHTTPClient.HEADER_X_PLEX_DEVICE, plexDevice);
			if (plexDeviceName != null)
				request.setHeader(PlexHTTPClient.HEADER_X_PLEX_DEVICE_NAME, plexDeviceName);
			if (plexProvides != null && plexProvides.size() > 0) {
				request.setHeader(PlexHTTPClient.HEADER_X_PLEX_PROVIDES, String.join(",", plexProvides));
			}
		})
		.addRequestInterceptorLast(this::logRequest);
		return clientBuilder.build();
	}

	private void logRequest(HttpRequest request, EntityDetails entity, HttpContext context) {
		try {
			StringBuilder msg = new StringBuilder()
					.append(request.getMethod())
					.append(" ")
					.append(request.getUri().toString()
//							new URIBuilder(request.getUri()).removeParameter(PlexHTTPClient.PARAMETER_X_PLEX_TOKEN).build().toString()
							)
					.append(System.lineSeparator());
			for (Header header : request.getHeaders()) {
				msg.append(header.getName()).append(" : ").append(header.getValue())
				.append(System.lineSeparator());
			}
			LOGGER.info(msg.toString());
		} catch (URISyntaxException e) {
			LOGGER.warning(e.toString());
		}
	}	
}