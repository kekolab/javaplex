package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexEpisode;
import kekolab.javaplex.PlexMediatag;
import kekolab.javaplex.PlexMusicSection;
import kekolab.javaplex.PlexShowSection;
import kekolab.javaplex.PlexTrack;

public class Issue6Tests extends PlexMediaServerTests {

    @Test
    public void episodeGrandparentTest() {
        List<PlexMediatag<?>> mediaTags = getServer().status().sessions();
        for (PlexMediatag<?> item : mediaTags) {
            if (item instanceof PlexEpisode episode) {
                assertDoesNotThrow(() -> episode.grandparent()); 
            }
        }

        PlexShowSection showSection = getServer().library().sections().showSections().get(0);
        PlexEpisode anEpisode = showSection.all().execute().get(0).grandchildren().get(0);
        assertDoesNotThrow(() -> anEpisode.grandparent()); 
    }

    @Test
    public void trackGrandparentTest() {
        List<PlexMediatag<?>> mediaTags = getServer().status().sessions();
        for (PlexMediatag<?> item : mediaTags) {
            if (item instanceof PlexTrack track) {
                assertDoesNotThrow(() -> track.grandparent()); 
            }
        }

        PlexMusicSection showSection = getServer().library().sections().musicSections().get(0);
        PlexTrack aTrack = showSection.all().execute().get(0).grandchildren().get(0);
        assertDoesNotThrow(() -> aTrack.grandparent()); 
    }
    
}
