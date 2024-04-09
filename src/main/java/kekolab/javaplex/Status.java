package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexStatus;

public class Status extends ServerMediaContainer implements PlexStatus {
	public Status(MediaServer server) throws URISyntaxException {
		super(new URIBuilder(server.getUri()).appendPath("status").build(), server);
	}

	@Override
	public List<Mediatag> sessions() {
		URI uri;
		try {
			uri = new URIBuilder(getUri()).appendPath("sessions").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<Mediatag, Directory>(uri, server()).getMetadata();
	}
}
