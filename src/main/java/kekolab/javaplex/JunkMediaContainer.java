package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class JunkMediaContainer extends PlexMediaContainer {
    private static final URI PLEX_RESOURCES_URI;
    public static final URI PLEX_SERVERS_URI;
    public static final String PLEX_SERVER_URI_TEMPLATE;
    public static final String PLEX_SERVER_SHARES_URI_TEMPLATE;

    static {
        try {
            PLEX_RESOURCES_URI = new URIBuilder("https://plex.tv/api/resources.xml").addParameter("includeHttps", "1")
                    .addParameter("includeRelays", "1").build();
            PLEX_SERVERS_URI = new URIBuilder("https://plex.tv/api/servers").build();
            PLEX_SERVER_URI_TEMPLATE = "https://plex.tv/api/servers/{machineIdentifier}";
            PLEX_SERVER_SHARES_URI_TEMPLATE = "https://plex.tv/api/servers/{machineIdentifier}/shared_servers";
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
    }

    static JunkMediaContainer forPlexResources(PlexHTTPClient client, String token) {
        return new JunkMediaContainer(PLEX_RESOURCES_URI, client, token);
    }

    static JunkMediaContainer forPlexServers(PlexHTTPClient client, String token) {
        return new JunkMediaContainer(PLEX_SERVERS_URI, client, token);
    }

    static JunkMediaContainer forPlexServer(PlexHTTPClient client, String token, String machineIdentifier)
            throws URISyntaxException {
        Objects.requireNonNull(machineIdentifier);
        URI uri = new URIBuilder(PLEX_SERVER_URI_TEMPLATE.replace("{machineIdentifier}", machineIdentifier)).build();
        return new JunkMediaContainer(uri, client, token);
    }

    static JunkMediaContainer forPlexServerShares(PlexHTTPClient client, String token, String machineIdentifier)
            throws URISyntaxException {
        Objects.requireNonNull(machineIdentifier);
        URI uri = new URIBuilder(PLEX_SERVER_SHARES_URI_TEMPLATE.replace("{machineIdentifier}", machineIdentifier))
                .build();
        return new JunkMediaContainer(uri, client, token);
    }

    @JsonProperty("Server")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PlexServer> servers;

    @JsonProperty("Device")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PlexDevice> devices;

    @JsonProperty("SharedServer")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PlexServerShare> serverShares;

    /*
     * This constructor is here only to be used by Jackson during deserializatio. It
     * builds a PlexMediaContainer without client, token or uri and sets the value
     * fetched to true. Use it at you own risk and if you are sure that you'll never
     * call refresh
     */
    public JunkMediaContainer() {
        super(null, null, null);
        fetched(true);
    }

    public JunkMediaContainer(URI uri, PlexHTTPClient client, String token) {
        super(uri, client, token);
        servers = new ArrayList<>();
        devices = new ArrayList<>();
        serverShares = new ArrayList<>();
    }

    public List<PlexServer> getServers() {
        fetch();
        servers.forEach(s -> {
            s.setClient(client());
            s.setToken(token());
        });
        return servers;
    }

    public void setServers(List<PlexServer> servers) {
        this.servers = servers;
    }

    public List<PlexDevice> getDevices() {
        fetch();
        devices.forEach(d -> d.setClient(client()));
        return devices;
    }

    public void setDevices(List<PlexDevice> devices) {
        this.devices = devices;
    }

    public List<PlexServerShare> getServerShares() {
        fetch();
        return serverShares;
    }

    public void setServerShares(List<PlexServerShare> serverShares) {
        this.serverShares = serverShares;
    }
}
