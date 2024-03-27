package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexMusicCollections;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;

class MusicSection extends Section<PlexArtist, PlexAlbum>  implements PlexMusicSection {


    public List<PlexAlbum> albums() {
		return executeRequestAndCastMetadata("albums", PlexAlbum.class);
	}

	@Override
	public PlexMusicCollections collections() {
		return new MusicCollections(this);
	}

	@Override
	public List<PlexTrack> tracks() {
		return executeRequestAndCastMetadata("allLeaves", PlexTrack.class);
	}	
}
