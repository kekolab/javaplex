package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexTranscode;
import kekolab.javaplex.model.PlexTranscodeSession;

class Transcode extends ServerMediaContainer implements PlexTranscode {
	Transcode(MediaServer server) throws URISyntaxException {
		super(new URIBuilder(server.getUri()).appendPath("transcode").build(), server);
	}

	public List<PlexTranscodeSession> sessions() {
		URI uri;
		try {
			uri = new URIBuilder(getUri()).appendPath("sessions").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<Metadata, Directory>(uri, server()).getTranscodeSessions();
	}

	public void killSession(PlexTranscodeSession session) {
		getClient().delete(session.key(), getToken(), Optional.empty());
	}
}
