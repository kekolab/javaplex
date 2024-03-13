package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexStatus;

class Status extends ServerMediaContainer implements PlexStatus {
	public Status(MediaServer server, PlexHTTPClient client, Optional<String> token) throws URISyntaxException {
		super(new URIBuilder(server.getUri()).appendPath("status").build(), client, token, server);
	}

	public List<PlexMediatag<?>> sessions() {
		URI uri;
		try {
			uri = new URIBuilder(getUri()).appendPath("sessions").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexMediatag<?>, Directory>(uri, getClient(), getToken(), server()).getMetadata();
	}
}
