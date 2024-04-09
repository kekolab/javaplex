package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexSmartAudioPlaylist;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;

public class AudioSmartPlaylist extends SmartPlaylist implements PlexSmartAudioPlaylist {
	@Override
	public List<PlexTrack> children() {
		return super.children().stream().map(PlexTrack.class::cast).toList();
	}

	@Override
	public PlexMusicSection section() {
		return (MusicSection) super.section();
	}
}