package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexSmartVideoPlaylist;

public class VideoSmartPlaylist extends SmartPlaylist implements PlexSmartVideoPlaylist {
	@Override
	public List<Video> children() {
		return super.children().stream().map(Video.class::cast).toList();
	}

	@Override
	public MovieSection section() {
		return (MovieSection) super.section();
	}

}