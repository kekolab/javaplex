package kekolab.javaplex;

import java.net.URI;
import java.util.Optional;

class ServerMediaContainer extends MediaContainer {
	private MediaServer server;

	public ServerMediaContainer(URI uri, PlexHTTPClient client, Optional<String> token, MediaServer server) {
		super(uri, client, token);
		this.server = server;
	}

	public MediaServer server() {
		return server;
	}
}
