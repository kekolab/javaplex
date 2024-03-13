package kekolab.javaplex;

import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexVideo;
import kekolab.javaplex.model.PlexVideoPlaylist;

class VideoPlaylist extends Playlist<PlexVideo<?>> implements PlexVideoPlaylist {
    public void add(PlexShow show) {
		new GenericCollectionsHelper(this).add(show);
	}

	public void add(PlexSeason season) {
		new GenericCollectionsHelper(this).add(season);
	}
}
