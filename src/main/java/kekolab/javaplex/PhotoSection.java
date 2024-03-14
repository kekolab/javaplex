package kekolab.javaplex;

import kekolab.javaplex.model.PlexCollections;
import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoalbum;
import kekolab.javaplex.model.PlexSection;

class PhotoSection extends Section<PlexPhotoalbum, PlexPhotoalbum> implements PlexPhotoSection {
	private Boolean enableAutoPhotoTags;

	public Boolean getEnableAutoPhotoTags() {
		return enableAutoPhotoTags;
	}

	public void setEnableAutoPhotoTags(Boolean enableAutoPhotoTags) {
		this.enableAutoPhotoTags = enableAutoPhotoTags;
	}
}
