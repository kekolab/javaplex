package kekolab.javaplex.model;

import java.util.List;

public interface PlexMusicSection extends PlexSection<PlexArtist, PlexAlbum> {

	String TYPE_DESCRIPTION = "artist";

    List<PlexAlbum> albums();
	PlexAlbumCollection createCollection(String title, PlexAlbum album);
	PlexArtistCollection createCollection(String title, PlexArtist artist);
	PlexTrackCollection createCollection(String title, PlexTrack track);
}
