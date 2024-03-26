package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistEditor;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTag;

public class PlexAttributeEditingTests extends PlexMediaServerTests {
    private PlexArtist artist;

    @BeforeEach
    public void init() {
        artist = getServer().library().sections().stream().filter(PlexMusicSection.class::isInstance)
                .map(PlexMusicSection.class::cast).findFirst().get().all().get(0);
    }

    @Test
    public void editCountry() {
        List<PlexTag> originalCountries = new ArrayList<>(artist.getCountries());
        PlexArtistEditor editor = artist.editor();
        editor.setCountries(Collections.emptyList(), Optional.empty());
        editor.commit();
        List<PlexTag> countries = artist.getCountries();
        assertTrue(countries.isEmpty());
/*
        List<PlexTag> newCountries = new ArrayList<>();
        PlexTag newCountry = new PlexTag();
        newCountry.setTag("Austria");
        newCountries.add(newCountry);
        artist.editCountries(newCountries);
        artist.commitEdits();
        countries = artist.getCountries();
        assertFalse(countries.isEmpty());
        assertTrue(countries.stream().allMatch(c -> newCountries.stream().map(PlexTag::getTag).anyMatch(oc -> oc.equals(c.getTag()))));

        artist.editCountries(originalCountries);
        artist.commitEdits();
        countries = artist.getCountries();
        assertFalse(countries.isEmpty());
        assertTrue(countries.stream().allMatch(c -> originalCountries.stream().map(PlexTag::getTag).anyMatch(oc -> oc.equals(c.getTag()))));
        */
    }

}
