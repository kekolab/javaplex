package kekolab.javaplex.model;

import java.util.Date;
import java.util.List;

public interface PlexPhoto extends PlexChild<PlexPhotoalbum, PlexPhotoSection> {
	int TYPE_ID = 13;
	String TYPE_DESCRIPTION = "photo";

	Integer getCreatedAtTZOffset();

	List<String> getCreatedAtAccuracy();

	Date getOriginallyAvailableAt();

	Integer getYear();

	List<PlexMedia> getMedia();

	default int typeId() {
		return TYPE_ID;
	}

	@Override
	PlexPhotoEditor editor();

}
