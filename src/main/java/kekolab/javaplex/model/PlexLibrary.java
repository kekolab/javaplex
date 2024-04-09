package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;

public interface PlexLibrary {

    Boolean getAllowSync();

    String getIdentifier();

    String getMediaTagPrefix();

    Long getMediaTagVersion();

    String getContent();

    String getTitle1();

    String getTitle2();

    String getArt();

    URI art();

    List<PlexMetadata> all();

    List<PlexMediatag> recentlyAdded();

    List<PlexVideo> onDeck();

    List<PlexSearchResult> search(String query);

    List<PlexSection> sections();

    List<PlexMusicSection> musicSections();

    List<PlexMovieSection> movieSections();

    List<PlexShowSection> showSections();

    List<PlexPhotoSection> photoSections();

    PlexSection section(int id);

}