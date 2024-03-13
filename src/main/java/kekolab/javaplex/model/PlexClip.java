package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;

public interface PlexClip extends PlexChild<PlexPhotoalbum, PlexPhotoSection>, PlexVideo<PlexPhotoSection> {
	int TYPE_ID = 14;
	String TYPE_DESCRIPTION = "clip";

	Integer getCreatedAtTZOffset();

	List<String> getCreatedAtAccuracy();

	String getSubtype();

	String getTagline();

	String getArt();

	URI art();

	String getThumb();

	URI thumb();

	default int typeId() {
		return TYPE_ID;
	}

}
