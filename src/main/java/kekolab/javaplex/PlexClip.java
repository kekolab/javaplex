package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.StringListDeserializer;

public class PlexClip extends PlexVideo<PlexPhotoSection> {
	public static final int TYPE_ID = 14;
	public static final String TYPE_DESCRIPTION = "clip";

	private Integer createdAtTZOffset;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	private String subtype;
	private String tagline;

	@JsonIgnore
	private Child<PlexPhotoSection, PlexPhotoalbum> asChild;

	@Override
	void update(PlexMetadata source) {
		super.update(source);
		PlexClip clip = (PlexClip) source;
		setCreatedAtTZOffset(clip.getCreatedAtTZOffset());
		setCreatedAtAccuracy(clip.getCreatedAtAccuracy());
		setSubtype(clip.getSubtype());
		setTagline(clip.getTagline());
		asChild.update(clip);
	}

	public void setParentGuid(String guid) {
		asChild.setParentGuid(guid);
	}

	public void setParentIndex(Integer index) {
		asChild.setParentIndex(index);
	}

	public void setParentStudio(String studio) {
		asChild.setParentStudio(studio);
	}

	public void setParentTitle(String title) {
		asChild.setParentTitle(title);
	}

	public void setParentYear(Integer year) {
		asChild.setParentYear(year);
	}

	public void setParentKey(String key) {
		asChild.setParentKey(key);
	}

	public void setParentRatingKey(Integer ratingKey) {
		asChild.setParentRatingKey(ratingKey);
	}

	public void setParentThumb(String thumb) {
		asChild.setParentThumb(thumb);
	}

	public void setParentTheme(String theme) {
		asChild.setParentTheme(theme);
	}

	public PlexPhotoalbum parent() {
		return asChild.parent();
	}

	public String getParentGuid() {
		return asChild.getParentGuid();
	}

	public Integer getParentIndex() {
		return asChild.getParentIndex();
	}

	public String getParentKey() {
		return asChild.getParentKey();
	}

	public URI parentKey() {
		return asChild.parentKey();
	}

	public Integer getParentRatingKey() {
		return asChild.getParentRatingKey();
	}

	public URI parentRatingKey() {
		return asChild.parentRatingKey();
	}

	public String getParentStudio() {
		return asChild.getParentStudio();
	}

	public String getParentTheme() {
		return asChild.getParentTheme();
	}

	public URI parentTheme() {
		return asChild.parentTheme();
	}

	public String getParentThumb() {
		return asChild.getParentThumb();
	}

	public URI parentThumb() {
		return asChild.parentThumb();
	}

	public String getParentTitle() {
		return asChild.getParentTitle();
	}

	public Integer getParentYear() {
		return asChild.getParentYear();
	}

	public PlexClip() {
		createdAtAccuracy = new ArrayList<>();
		asChild = new Child<>() {
			@Override
			public int typeId() {
				return TYPE_ID;
			}
		};
	}

	public Integer getCreatedAtTZOffset() {
		ensureDetailed(createdAtTZOffset);
		return createdAtTZOffset;
	}

	public void setCreatedAtTZOffset(Integer createdAtTZOffset) {
		this.createdAtTZOffset = createdAtTZOffset;
	}

	public List<String> getCreatedAtAccuracy() {
		ensureDetailed(createdAtAccuracy);
		return createdAtAccuracy;
	}

	public void setCreatedAtAccuracy(List<String> createdAtAccuracy) {
		this.createdAtAccuracy = createdAtAccuracy;
	}

	public String getSubtype() {
		ensureDetailed(subtype);
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getTagline() {
		ensureDetailed(tagline);
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public int typeId() {
		return TYPE_ID;
	}

}
