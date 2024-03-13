package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;

class MusicSection extends Section<PlexArtist, PlexAlbum>  implements PlexMusicSection {


    public List<PlexAlbum> albums() {
		return executeRequestAndCastMetadata("albums", PlexAlbum.class);
	}

	public AlbumCollection createCollection(String title, PlexAlbum album) {
		return (AlbumCollection) super.createCollection(title, album);
	}

	public ArtistCollection createCollection(String title, PlexArtist artist) {
		return (ArtistCollection) super.createCollection(title, artist);
	}

	public TrackCollection createCollection(String title, PlexTrack track) {
		return (TrackCollection) super.createCollection(title, track);
	}
}
