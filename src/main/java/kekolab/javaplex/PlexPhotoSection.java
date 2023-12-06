package kekolab.javaplex;

public class PlexPhotoSection extends PlexSection<PlexPhotoalbum, PlexPhotoalbum> {
	public static final String TYPE_DESCRIPTION = "photo";
	private Boolean enableAutoPhotoTags;

	public Boolean getEnableAutoPhotoTags() {
		return enableAutoPhotoTags;
	}

	public void setEnableAutoPhotoTags(Boolean enableAutoPhotoTags) {
		this.enableAutoPhotoTags = enableAutoPhotoTags;
	}

	@Override
	protected void clear() {
		super.clear();
		enableAutoPhotoTags = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexPhotoSection photoSection) {
			enableAutoPhotoTags = photoSection.enableAutoPhotoTags;
		} else
			throw new ClassCastException("Cannot cast item to PlexPhotoSection");
	}
}
