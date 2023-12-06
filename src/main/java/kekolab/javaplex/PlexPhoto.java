package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.StringListDeserializer;

public class PlexPhoto extends PlexMediatag<PlexPhotoSection> {
	public static final int TYPE_ID = 13;
	public static final String TYPE_DESCRIPTION = "photo";
	private Integer createdAtTZOffset;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	@JsonProperty("Media")
	private List<PlexMedia> media;
	private Date originallyAvailableAt;
	private Integer year;

	private ChildDelegate<PlexPhotoalbum> child;

	public PlexPhoto() {
		createdAtAccuracy = new ArrayList<>();
		media = new ArrayList<>();
		child = new ChildDelegate<>(this::server, this::getClient, this::getToken);
	}

	@Override
	protected void clear() {
		super.clear();
		createdAtAccuracy.clear();
		createdAtTZOffset = null;
		media.clear();
		originallyAvailableAt = null;
		child.clear();
		year = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexPhoto photo) {
			createdAtAccuracy = photo.createdAtAccuracy;
			createdAtTZOffset = photo.createdAtTZOffset;
			media.clear();
			media.addAll(photo.media);
			originallyAvailableAt = photo.originallyAvailableAt;
			child.update(photo.child);
			year = photo.year;
		} else
			throw new ClassCastException("Cannot cast item to PlexPhoto");
	}

	public Integer getCreatedAtTZOffset() {
		fetchDetailedIfNullOrEmpty(createdAtTZOffset);
		return createdAtTZOffset;
	}

	public List<String> getCreatedAtAccuracy() {
		fetchDetailedIfNullOrEmpty(createdAtAccuracy);
		return createdAtAccuracy;
	}

	public Date getOriginallyAvailableAt() {
		fetchDetailedIfNullOrEmpty(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public Integer getYear() {
		fetchDetailedIfNullOrEmpty(year);
		return year;
	}

	public PlexPhotoalbum parent() {
		fetchDetailedIfNullOrEmpty(child.parent());
		return (PlexPhotoalbum) child.parent();
	}

	public String getParentGuid() {
		fetchDetailedIfNullOrEmpty(child.getParentGuid());
		return child.getParentGuid();
	}

	public Integer getParentIndex() {
		fetchDetailedIfNullOrEmpty(child.getParentIndex());
		return child.getParentIndex();
	}

	public String getParentKey() {
		fetchDetailedIfNullOrEmpty(child.getParentKey());
		return child.getParentKey();
	}

	public URI parentKey() {
		fetchDetailedIfNullOrEmpty(child.parentKey());
		return child.parentKey();
	}

	public Integer getParentRatingKey() {
		fetchDetailedIfNullOrEmpty(child.getParentRatingKey());
		return child.getParentRatingKey();
	}

	public URI parentRatingKey() {
		fetchDetailedIfNullOrEmpty(child.getParentRatingKey());
		return child.parentRatingKey();
	}

	public String getParentStudio() {
		fetchDetailedIfNullOrEmpty(child.getParentStudio());
		return child.getParentStudio();
	}

	public String getParentTheme() {
		fetchDetailedIfNullOrEmpty(child.getParentTheme());
		return child.getParentTheme();
	}

	public URI parentTheme() {
		fetchDetailedIfNullOrEmpty(child.parentTheme());
		return child.parentTheme();
	}

	public String getParentThumb() {
		fetchDetailedIfNullOrEmpty(child.getParentThumb());
		return child.getParentThumb();
	}

	public URI parentThumb() {
		fetchDetailedIfNullOrEmpty(child.parentThumb());
		return child.parentThumb();
	}

	public String getParentTitle() {
		fetchDetailedIfNullOrEmpty(child.getParentTitle());
		return child.getParentTitle();
	}

	public Integer getParentYear() {
		fetchDetailedIfNullOrEmpty(child.getParentYear());
		return child.getParentYear();
	}

	public List<PlexMedia> getMedia() {
		fetchDetailedIfNullOrEmpty(media);
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

	public void setParentGuid(String arg) {
		child.setParentGuid(arg);
	}

	public void setParentIndex(Integer arg) {
		child.setParentIndex(arg);
	}

	public void setParentKey(String arg) {
		child.setParentKey(arg);
	}

	public void setParentRatingKey(Integer arg) {
		child.setParentRatingKey(arg);
	}

	public void setParentStudio(String arg) {
		child.setParentStudio(arg);
	}

	public void setParentTheme(String arg) {
		child.setParentTheme(arg);
	}

	public void setParentThumb(String arg) {
		child.setParentThumb(arg);
	}

	public void setParentTitle(String arg) {
		child.setParentTitle(arg);
	}

	public void setParentYear(Integer arg) {
		child.setParentYear(arg);
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

}
