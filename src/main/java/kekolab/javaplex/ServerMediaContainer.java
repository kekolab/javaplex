package kekolab.javaplex;

import java.net.URI;

public class ServerMediaContainer extends PlexMediaContainer {
	private PlexMediaServer server;

	public ServerMediaContainer(URI uri, PlexHTTPClient client, String token, PlexMediaServer server) {
		super(uri, client, token);
		this.server = server;
	}

	public PlexMediaServer server() {
		return server;
	}
}
