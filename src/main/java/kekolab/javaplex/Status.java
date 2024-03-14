package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexStatus;

class Status extends ServerMediaContainer implements PlexStatus {
	public Status(MediaServer server) throws URISyntaxException {
		super(new URIBuilder(server.getUri()).appendPath("status").build(), server);
	}

	public List<PlexMediatag<?>> sessions() {
		URI uri;
		try {
			uri = new URIBuilder(getUri()).appendPath("sessions").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexMediatag<?>, Directory>(uri, server()).getMetadata();
	}
}
