package kekolab.javaplex;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexAudioPlaylist;
import kekolab.javaplex.model.PlexTrack;

class AudioPlaylist extends Playlist<PlexTrack> implements PlexAudioPlaylist {

	public void add(PlexArtist artist) {
		new GenericCollectionsHelper(this).add(artist);
	}

	public void add(PlexAlbum album) {
		new GenericCollectionsHelper(this).add(album);
	}
}
