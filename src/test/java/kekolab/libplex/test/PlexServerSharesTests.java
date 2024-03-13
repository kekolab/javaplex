package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.SharingSettings;
import kekolab.javaplex.model.PlexServer;
import kekolab.javaplex.model.PlexServer.Section;
import kekolab.javaplex.model.PlexServerShare;
import kekolab.javaplex.model.PlexServerShares;

public class PlexServerSharesTests extends PlexTests {

    private static final String DUMMY_EMAIL = "dummy@example.com";

    @BeforeEach
    @AfterEach
    @Test
    public void deleteDummyShare() {
        List<PlexServer> servers = getApi().getServers().list();
        assertNotEquals(0, servers.size());
        PlexServer server = servers.get(0);

        PlexServerShares serverShares = server.serverShares();
        List<PlexServerShare> shares = serverShares.list();
        assertNotNull(shares);

        shares.stream().filter(s -> s.getEmail().equals(DUMMY_EMAIL)).forEach(serverShares::deleteServerShare);
    }

    @Test
    public void inviteFriendWithDefaultSharingSettings() throws URISyntaxException {
        PlexServer server = getApi().getServers().list().get(0);
        PlexServerShares serverShares = server.serverShares();
        List<Section> sectionsToShare = server.getSections();
        PlexServerShare share = serverShares.inviteFriend(DUMMY_EMAIL, sectionsToShare);
        assertNotNull(share);
        assertEquals(DUMMY_EMAIL, share.getEmail());
        assertNotNull(share.getId());
        assertTrue(share.getSections().stream().map(PlexServer.Section::getId).allMatch(sharedSectionId -> {
            for (PlexServer.Section sectionToShare : sectionsToShare)
                if (sectionToShare.getId().equals(sharedSectionId))
                    return true;
            return false;
        }));
        assertFalse(share.getAllowCameraUpload());
        assertFalse(share.getAllowChannels());
        assertFalse(share.getAllowSubtitleAdmin());
        assertFalse(share.getAllowSync());
        assertFalse(share.getAllowTuners());
        assertTrue(share.getFilterAll() == null || share.getFilterAll().isBlank());
        assertTrue(share.getFilterMovies() == null || share.getFilterMovies().isBlank());
        assertTrue(share.getFilterMusic() == null || share.getFilterMusic().isBlank());
        assertTrue(share.getFilterPhotos() == null || share.getFilterPhotos().isBlank());
        assertTrue(share.getFilterTelevision() == null || share.getFilterTelevision().isBlank());
    }

    @Test
    public void inviteFriendWithCustomSettings() throws URISyntaxException {
        PlexServer server = getApi().getServers().list().get(0);
        PlexServerShares serverShares = server.serverShares();
        List<Section> sectionsToShare = server.getSections();

        SharingSettings sharingSettings = new SharingSettings();
        sharingSettings.setAllowCameraUpload(true);
        sharingSettings.setAllowChannels(false);
        sharingSettings.setAllowSync(true);
        sharingSettings.setFilterMovies(new HashMap<String, List<String>>()); // TODO
        sharingSettings.setFilterMusic(new HashMap<String, List<String>>()); // TODO
        sharingSettings.setFilterTelevision(new HashMap<String, List<String>>()); // TODO

        PlexServerShare share = serverShares.inviteFriend(DUMMY_EMAIL, sectionsToShare, sharingSettings);

        assertNotNull(share);
        assertEquals(DUMMY_EMAIL, share.getEmail());
        assertEquals(sharingSettings.getAllowCameraUpload(), share.getAllowCameraUpload());
        assertEquals(sharingSettings.getAllowChannels(), share.getAllowChannels());
        assertEquals(sharingSettings.getAllowSync(), share.getAllowSync());
    }
}
