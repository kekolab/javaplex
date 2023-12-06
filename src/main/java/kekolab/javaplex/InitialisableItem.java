package kekolab.javaplex;

import java.net.URI;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InitialisableItem extends BaseItem {
    @JsonIgnore
    private PlexHTTPClient client;
    @JsonIgnore
    private String token;
    @JsonIgnore
    private PlexMediaServer server;
    @JsonIgnore
    private URI uri;

    protected void initialise(PlexMediaServer server, URI uri, PlexHTTPClient client, String token) {
        		Objects.requireNonNull(client, "client cannot be null");
		Objects.requireNonNull(server, "server cannot be null");
		Objects.requireNonNull(uri, "uri cannot be null");
		this.client = client;
		this.token = token;
		this.server = server;
		this.uri = uri;
    }

    protected PlexHTTPClient getClient() {
		return client;
	}

	protected String getToken() {
		return token;
	}

    public PlexMediaServer server() {
		return server;
	}

	protected URI uri() {
		return uri;
	}
}