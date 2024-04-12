package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexArtist;
import kekolab.javaplex.PlexMusicSection;
import kekolab.javaplex.PlexTag;

public class PlexAttributeEditingTests extends PlexMediaServerTests {
    private PlexArtist anArtist;

    @BeforeEach
    public void init() {
        anArtist = getServer().library().sections().list().stream().filter(PlexMusicSection.class::isInstance)
                .map(PlexMusicSection.class::cast).findFirst().get().all().execute().get(0);
    }

    @Test
    public void editCountry() {
        String originalTitle = anArtist.getTitle();
        String updatedTitle = "Unexisting Artist - Hopefully";
        anArtist.editTitle(updatedTitle, Optional.empty());
        assertEquals(updatedTitle, anArtist.getTitle());
        anArtist.editTitle(originalTitle, Optional.empty());
        assertEquals(originalTitle, anArtist.getTitle());

        Boolean isOriginalTitleLocked = anArtist.getTitleLocked();
        boolean updatedLock = isOriginalTitleLocked != null ? !isOriginalTitleLocked : true;
        anArtist.editTitle(anArtist.getTitle(), Optional.of(updatedLock));
        assertEquals(updatedLock, anArtist.getTitleLocked());
        anArtist.editTitle(anArtist.getTitle(), Optional.of(isOriginalTitleLocked != null ? isOriginalTitleLocked : false));
        assertEquals(isOriginalTitleLocked, anArtist.getTitleLocked());

        List<PlexTag> originalCountries = anArtist.getCountries(); 
        List<String> editedCountries = Arrays.asList("Country 1", "Country 2");
        anArtist.editCountries(editedCountries, Optional.empty());
        assertEquals(editedCountries.size(), anArtist.getCountries().size());
        assertTrue(anArtist.getCountries().stream().allMatch(c -> editedCountries.stream().anyMatch(e -> e.equals(c.getTag()))));
        anArtist.editCountries(originalCountries.stream().map(PlexTag::getTag).toList(), Optional.empty());
        assertTrue(anArtist.getCountries().stream().allMatch(c -> originalCountries.stream().anyMatch(e -> e.getTag().equals(c.getTag()))));
    }
}
