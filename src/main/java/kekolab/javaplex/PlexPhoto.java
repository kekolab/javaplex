package kekolab.javaplex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.filtering.PlexFilterableBoolean;
import kekolab.javaplex.filtering.PlexFilterableDate;
import kekolab.javaplex.filtering.PlexFilterableInteger;
import kekolab.javaplex.filtering.PlexFilterableString;
import kekolab.javaplex.filtering.PlexFilterableTag;
import kekolab.javaplex.mappers.StringListDeserializer;

public class PlexPhoto extends Child<PlexPhotoSection, PlexPhotoalbum> {
	public static final int TYPE_ID = 13;
	public static final String TYPE_DESCRIPTION = "photo";

	public static final PlexFilterableString TITLE = () -> "title";
	public static final PlexFilterableDate DATE_ADDED = () -> "addedAt";
	public static final PlexFilterableDate DATE_TAKEN = () -> "originallyAvailableAt";
	public static final PlexFilterableInteger RATING = () -> "userRating";
	public static final PlexFilterableInteger FILE_SIZE = () -> "mediaSize";
	public static final PlexFilterableTag TAG = () -> "tag";
	public static final PlexFilterableBoolean TRASHED = () -> "trashed";
	public static final PlexFilterableTag APERTURE = () -> "aperture";
	public static final PlexFilterableTag EXPOSURE = () -> "exposure";
	public static final PlexFilterableTag ISO = () -> "iso";
	public static final PlexFilterableTag LENS = () -> "lens";
	public static final PlexFilterableTag CAMERA_MAKE = () -> "make";
	public static final PlexFilterableTag CAMERA_MODEL = () -> "model";
	public static final PlexFilterableTag DEVICE = () -> "device";

	private Integer createdAtTZOffset;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	@JsonProperty("Media")
	@JsonDeserialize(contentAs = PlexMedia.class)
	private List<PlexMedia> media;
	private Date originallyAvailableAt;
	private Integer year;

	public PlexPhoto() {
		createdAtAccuracy = new ArrayList<>();
		media = new ArrayList<>();
	}

	@Override
	void update(PlexMetadata source) {
		super.update(source);
		PlexPhoto p = (PlexPhoto) source;
		setCreatedAtTZOffset(p.getCreatedAtTZOffset());
		setCreatedAtAccuracy(p.getCreatedAtAccuracy());
		setMedia(p.getMedia());
		setOriginallyAvailableAt(p.getOriginallyAvailableAt());
		setYear(p.getYear());
	}

	public Integer getCreatedAtTZOffset() {
		ensureDetailed(createdAtTZOffset);
		return createdAtTZOffset;
	}

	public List<String> getCreatedAtAccuracy() {
		ensureDetailed(createdAtAccuracy);
		return createdAtAccuracy;
	}

	public Date getOriginallyAvailableAt() {
		ensureDetailed(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public Integer getYear() {
		ensureDetailed(year);
		return year;
	}

	public List<PlexMedia> getMedia() {
		ensureDetailed(media);
		return media;
	}

	public void setCreatedAtTZOffset(Integer createdAtTZOffset) {
		this.createdAtTZOffset = createdAtTZOffset;
	}

	public void setCreatedAtAccuracy(List<String> createdAtAccuracy) {
		this.createdAtAccuracy = createdAtAccuracy;
	}

	public void setMedia(List<PlexMedia> media) {
		this.media = media;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}
}
