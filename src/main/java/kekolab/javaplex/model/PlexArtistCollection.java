package kekolab.javaplex.model;

import java.util.List;

public interface PlexArtistCollection extends PlexCollection {

    String ARTIST_COLLECTION_SUBTYPE = "artist";

    List<PlexArtist> children();

    PlexMusicSection section();

}