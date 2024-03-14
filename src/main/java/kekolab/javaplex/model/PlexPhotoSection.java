package kekolab.javaplex.model;

public interface PlexPhotoSection extends PlexSection<PlexPhotoalbum, PlexPhotoalbum> {
	String TYPE_DESCRIPTION = "photo";

	Boolean getEnableAutoPhotoTags();
}
