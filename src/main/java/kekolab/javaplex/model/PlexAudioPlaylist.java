package kekolab.javaplex.model;

public interface PlexAudioPlaylist extends PlexPlaylist<PlexTrack> {

	String SUBTYPE_DESCRIPTION = "audio";

    void add(PlexArtist artist);

	void add(PlexAlbum album);
}
