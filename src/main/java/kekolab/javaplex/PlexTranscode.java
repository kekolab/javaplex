package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

public class PlexTranscode extends ServerMediaContainer {
	public PlexTranscode(PlexMediaServer server, PlexHTTPClient client, String token) throws URISyntaxException {
		super(new URIBuilder(server.uri()).appendPath("transcode").build(), client, token, server);
	}

	public List<PlexTranscodeSession> sessions() {
		URI uri;
		try {
			uri = new URIBuilder(uri()).appendPath("sessions").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexMetadata, PlexDirectory>(uri, client(), token(), server()).getTranscodeSessions();
	}

	public void killSession(PlexTranscodeSession session) {
		client().execute(ClassicRequestBuilder.delete(session.key()).build(), token());
	}
}
