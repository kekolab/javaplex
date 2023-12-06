package kekolab.javaplex;

import java.util.List;

public class PlexMusicSection extends PlexSection<PlexArtist, PlexAlbum> {

	public static final String TYPE_DESCRIPTION = "artist";

    public List<PlexAlbum> albums() {
		return executeRequestAndCastMetadata("albums", PlexAlbum.class);
	}

	public PlexAlbumCollection createCollection(String title, PlexAlbum album) {
		return (PlexAlbumCollection) super.createCollection(title, album);
	}

	public PlexArtistCollection createCollection(String title, PlexArtist artist) {
		return (PlexArtistCollection) super.createCollection(title, artist);
	}

	public PlexTrackCollection createCollection(String title, PlexTrack track) {
		return (PlexTrackCollection) super.createCollection(title, track);
	}
}
