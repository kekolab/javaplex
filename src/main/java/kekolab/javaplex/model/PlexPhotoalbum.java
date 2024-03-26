package kekolab.javaplex.model;

import java.net.URI;

public interface PlexPhotoalbum extends PlexParent<PlexChild<?, PlexPhotoSection>, PlexPhotoSection> {
	int TYPE_ID = 11;
	String TYPE_DESCRIPTION = "photo";
	
	String getComposite();

	URI composite();

	String getArt();

	URI art();

	String getThumb();

	URI thumb();

	default int typeId() {
		return TYPE_ID;
	}

	@Override
	PlexPhotoalbumEditor editor();
}
