package kekolab.javaplex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexMedia;
import kekolab.javaplex.model.PlexPhoto;
import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoalbum;

class Photo extends Child<PlexPhotoalbum, PlexPhotoSection> implements PlexPhoto {
	private Integer createdAtTZOffset;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	@JsonProperty("Media")
	@JsonDeserialize(contentAs = Media.class)
	private List<PlexMedia> media;
	private Date originallyAvailableAt;
	private Integer year;

	public Photo() {
		createdAtAccuracy = new ArrayList<>();
		media = new ArrayList<>();
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		Photo p = (Photo) source;
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
		return PlexPhoto.super.typeId();
	}
}
