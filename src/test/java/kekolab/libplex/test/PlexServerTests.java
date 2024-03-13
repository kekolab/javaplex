package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;

import kekolab.javaplex.model.PlexServer;

public class PlexServerTests extends PlexTests {
    
    @Test
    public void fetchAndUpdateServers() throws URISyntaxException {
        List<PlexServer> servers = getApi().getServers().list();
        assertNotNull(servers);
        assertNotEquals(0, servers.size());
        PlexServer server = servers.get(0);
        assertNotNull(server.getMachineIdentifier());
        assertNotNull(server.getSections()); // Should fire a request
        assertNotEquals(0, server.getSections().size());
    }
    
}
