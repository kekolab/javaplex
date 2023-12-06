package kekolab.javaplex;

public class PlexAudioPlaylist extends PlexPlaylist<PlexTrack> {

	public static final String SUBTYPE_DESCRIPTION = "audio";

    public void add(PlexArtist artist) {
		new GenericCollectionsHelper(this).add(artist);
	}

	public void add(PlexAlbum album) {
		new GenericCollectionsHelper(this).add(album);
	}
}
