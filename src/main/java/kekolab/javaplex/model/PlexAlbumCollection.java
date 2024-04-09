package kekolab.javaplex.model;

import java.util.List;

public interface PlexAlbumCollection extends PlexCollection {

    String ALBUM_COLLECTION_SUBTYPE = "album";

    List<PlexAlbum> children();

    PlexMusicSection section();

}