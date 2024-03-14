package kekolab.javaplex.model;

import java.util.List;

public interface PlexMusicSection extends PlexSection<PlexArtist, PlexAlbum>, WithCollections<PlexMusicCollections, PlexMusicSection> {

	String TYPE_DESCRIPTION = "artist";

    List<PlexAlbum> albums();
}
