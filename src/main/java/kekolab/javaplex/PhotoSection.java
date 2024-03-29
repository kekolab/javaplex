package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoSectionItemFilter;
import kekolab.javaplex.model.PlexPhotoalbum;

class PhotoSection extends Section<PlexPhotoalbum, PlexPhotoalbum> implements PlexPhotoSection {
	private Boolean enableAutoPhotoTags;

	public Boolean getEnableAutoPhotoTags() {
		return enableAutoPhotoTags;
	}

	public void setEnableAutoPhotoTags(Boolean enableAutoPhotoTags) {
		this.enableAutoPhotoTags = enableAutoPhotoTags;
	}

	@Override
	public List<PlexPhotoSectionItemFilter> byYear() {
		return byFeature("year", f -> new PhotoSectionItemFilter(f, this));
	}

	@Override
	public List<PlexPhotoSectionItemFilter> byCameraMake() {
		return byFeature("make", f -> new PhotoSectionItemFilter(f, this));
	}

	@Override
	public List<PlexPhotoSectionItemFilter> byCameraModel() {
		return byFeature("model", f -> new PhotoSectionItemFilter(f, this));
	}

	@Override
	public List<PlexPhotoSectionItemFilter> byAperture() {
		return byFeature("aperture", f -> new PhotoSectionItemFilter(f, this));
	}

	@Override
	public List<PlexPhotoSectionItemFilter> byShutterSpeed() {
		return byFeature("exposure", f -> new PhotoSectionItemFilter(f, this));
	}

	@Override
	public List<PlexPhotoSectionItemFilter> byISO() {
		return byFeature("iso", f -> new PhotoSectionItemFilter(f, this));
	}

	@Override
	public List<PlexPhotoSectionItemFilter> byLens() {
		return byFeature("lens", f -> new PhotoSectionItemFilter(f, this));
	}

	@Override
	public List<PlexPhotoSectionItemFilter> byTag() {
		return byFeature("tag", f -> new PhotoSectionItemFilter(f, this));
	}
}
