package kekolab.javaplex.model;

import java.util.List;

public interface PlexPhotoSection extends PlexSection<PlexPhotoalbum, PlexPhotoalbum> {
	String TYPE_DESCRIPTION = "photo";

	Boolean getEnableAutoPhotoTags();

	List<PlexPhotoSectionItemFilter> byYear();
	List<PlexPhotoSectionItemFilter> byCameraMake();
	List<PlexPhotoSectionItemFilter> byCameraModel();
	List<PlexPhotoSectionItemFilter> byAperture();
	List<PlexPhotoSectionItemFilter> byShutterSpeed();
	List<PlexPhotoSectionItemFilter> byISO();
	List<PlexPhotoSectionItemFilter> byLens();
	List<PlexPhotoSectionItemFilter> byTag();
	// TODO trashed
	
}
