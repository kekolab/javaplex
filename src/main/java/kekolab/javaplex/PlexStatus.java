package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

public class PlexStatus extends ServerMediaContainer {
	public PlexStatus(PlexMediaServer server, PlexHTTPClient client, String token) throws URISyntaxException {
		super(new URIBuilder(server.uri()).appendPath("status").build(), client, token, server);
	}

	public List<PlexMediatag<?>> sessions() {
		URI uri;
		try {
			uri = new URIBuilder(uri()).appendPath("sessions").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexMediatag<?>, PlexDirectory>(uri, client(), token(), server()).getMetadata();
	}
}
