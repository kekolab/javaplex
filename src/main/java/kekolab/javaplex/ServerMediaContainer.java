package kekolab.javaplex;

import java.net.URI;

public class ServerMediaContainer extends MediaContainer {
	private MediaServer server;

	public ServerMediaContainer(URI uri, MediaServer server) {
		super(uri, server.getClient(), server.getToken());
		this.server = server;
	}

	MediaServer server() {
		return server;
	}
}
