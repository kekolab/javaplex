package kekolab.javaplex;

import kekolab.javaplex.model.PlexSmartPhotoPlaylist;

public class PhotoSmartPlaylist extends SmartPlaylist implements PlexSmartPhotoPlaylist {
	@Override
	public PhotoSection section() {
		return (PhotoSection) super.section();
	}
}