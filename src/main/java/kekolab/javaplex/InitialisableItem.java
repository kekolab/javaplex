package kekolab.javaplex;

import java.net.URI;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

class InitialisableItem extends BaseItem {
    @JsonIgnore
    private PlexHTTPClient client;
    @JsonIgnore
    private Optional<String> token;
    @JsonIgnore
    private MediaServer server;
    @JsonIgnore
    private URI uri;

    void initialise(MediaServer server, URI uri, PlexHTTPClient client, Optional<String> token) {
		this.client = client;
		this.token = token;
		this.server = server;
		this.uri = uri;
    }

    PlexHTTPClient getClient() {
		return client;
	}

	@Deprecated
	String token() {
		return token.get();
	}

	Optional<String> getToken() {
		return token;
	}

    MediaServer getServer() {
		return server;
	}

	protected URI uri() {
		return uri;
	}
}