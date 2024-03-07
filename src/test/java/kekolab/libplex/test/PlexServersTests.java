package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexApi;
import kekolab.javaplex.PlexServer;
import kekolab.javaplex.PlexServerShare;
import kekolab.javaplex.mappers.SharingSettings;

public class PlexServersTests extends PlexTests {

    @Test
    public void inviteFriend() throws URISyntaxException {
        PlexApi api = new PlexApi(getClient(), getToken());
        List<PlexServer> servers = api.servers();
        assertNotEquals(0, servers.size());

        PlexServer server = servers.get(0);
        List<PlexServerShare> serverShares = server.serverShares();
        assertNotNull(serverShares);

        String email = "dummy@example.com";

        
        SharingSettings sharingSettings = new SharingSettings();
        sharingSettings.setAllowCameraUpload(true);
        sharingSettings.setAllowChannels(false);
        sharingSettings.setAllowSync(true);
        sharingSettings.setFilterMovies(new HashMap<String, List<String>>()); // TODO
        sharingSettings.setFilterMusic(new HashMap<String, List<String>>()); // TODO
        sharingSettings.setFilterTelevision(new HashMap<String, List<String>>()); // TODO

        PlexServerShare newShare = server.inviteFriend(email, server.getSections(), sharingSettings);
        assertNotNull(newShare);
        assertEquals(email, newShare.getEmail());
        assertEquals(sharingSettings.getAllowCameraUpload(), newShare.getAllowCameraUpload());
        assertEquals(sharingSettings.getAllowChannels(), newShare.getAllowChannels());
        assertEquals(sharingSettings.getAllowSync(), newShare.getAllowSync());

        /*
        PlexServerShare shareWithDefaults = server.inviteFriend(email, server.getSections());
        assertNotNull(shareWithDefaults);
        assertEquals(email, shareWithDefaults.getEmail());
        assertFalse(shareWithDefaults.getAllowCameraUpload());
        assertFalse(shareWithDefaults.getAllowChannels());
        assertFalse(shareWithDefaults.getAllowSync());
        */
    }

    @Test
    public void fetchAndUpdateServers() throws URISyntaxException {
        PlexApi plex = new PlexApi(getClient(), getToken());
        List<PlexServer> servers = plex.servers(); // Should fire a request
        assertNotNull(servers);
        assertNotEquals(0, servers.size());
        PlexServer server = servers.get(0);
        assertNotNull(server.getMachineIdentifier());
        assertNotNull(server.getSections()); // Should fire a request
        assertNotEquals(0, server.getSections().size());
    }

}
