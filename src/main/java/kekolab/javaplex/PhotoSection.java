package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoSectionSecondaryDirectory;
import kekolab.javaplex.model.PlexPhotoalbum;
import kekolab.javaplex.model.PlexSectionQueryBuilder;

public class PhotoSection extends Section implements PlexPhotoSection {
	private Boolean enableAutoPhotoTags;

	@Override
	public Boolean getEnableAutoPhotoTags() {
		return enableAutoPhotoTags;
	}

	public void setEnableAutoPhotoTags(Boolean enableAutoPhotoTags) {
		this.enableAutoPhotoTags = enableAutoPhotoTags;
	}

	@Override
	public PlexSectionQueryBuilder<PlexPhotoalbum> all() {
		return new SectionQueryBuilder<PlexPhotoalbum>()
				.withSection(this)
				.withPath("all");
	}

	@Override
	public List<PlexPhotoalbum> recentlyAdded() {
		return new SectionQueryBuilder<PlexPhotoalbum>()
				.withSection(this)
				.withPath("recentlyAdded")
				.execute();
	}

	@Override
	public List<PlexPhotoSectionSecondaryDirectory> byYear() {
		return byFeature("year", f -> new PhotoSectionSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexPhotoSectionSecondaryDirectory> byCameraMake() {
		return byFeature("make", f -> new PhotoSectionSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexPhotoSectionSecondaryDirectory> byCameraModel() {
		return byFeature("model", f -> new PhotoSectionSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexPhotoSectionSecondaryDirectory> byAperture() {
		return byFeature("aperture", f -> new PhotoSectionSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexPhotoSectionSecondaryDirectory> byShutterSpeed() {
		return byFeature("exposure", f -> new PhotoSectionSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexPhotoSectionSecondaryDirectory> byISO() {
		return byFeature("iso", f -> new PhotoSectionSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexPhotoSectionSecondaryDirectory> byLens() {
		return byFeature("lens", f -> new PhotoSectionSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexPhotoSectionSecondaryDirectory> byTag() {
		return byFeature("tag", f -> new PhotoSectionSecondaryDirectory(f, this));
	}
}
