package kekolab.javaplex;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

public class PlexApi {
    private final PlexHTTPClient client;
    private final String token;

    public PlexApi(PlexHTTPClient client) {
        this(client, null);
    }

    public PlexApi(PlexHTTPClient client, String token) {
        this.client = Objects.requireNonNull(client);
        this.token = token;
    }

    public List<PlexDevice> devices() {
        return JunkMediaContainer.forPlexResources(client, token).getDevices();
    }

    public List<PlexServer> servers() throws URISyntaxException {
        return JunkMediaContainer.forPlexServers(client, token).getServers();
    }
}