package kekolab.javaplex;

import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexPhotoPlaylist;
import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoalbum;

class PhotoPlaylist extends Playlist<PlexMediatag<PlexPhotoSection>> implements PlexPhotoPlaylist {

    public void add(PlexPhotoalbum item) {
		new GenericCollectionsHelper(this).add(item);
	}
}
