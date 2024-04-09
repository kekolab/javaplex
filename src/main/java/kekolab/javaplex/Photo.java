package kekolab.javaplex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.StringListDeserializer;
import kekolab.javaplex.model.PlexMedia;
import kekolab.javaplex.model.PlexPhoto;
import kekolab.javaplex.model.PlexPhotoEditor;
import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoalbum;

public class Photo extends Child implements PlexPhoto {
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
		PlexPhoto p = (PlexPhoto) source;
		setCreatedAtTZOffset(p.getCreatedAtTZOffset());
		setCreatedAtAccuracy(p.getCreatedAtAccuracy());
		setMedia(p.getMedia());
		setOriginallyAvailableAt(p.getOriginallyAvailableAt());
		setYear(p.getYear());
	}

	@Override
	public Integer getCreatedAtTZOffset() {
		ensureDetailed(createdAtTZOffset);
		return createdAtTZOffset;
	}

	@Override
	public List<String> getCreatedAtAccuracy() {
		ensureDetailed(createdAtAccuracy);
		return createdAtAccuracy;
	}

	@Override
	public Date getOriginallyAvailableAt() {
		ensureDetailed(originallyAvailableAt);
		return originallyAvailableAt;
	}

	@Override
	public Integer getYear() {
		ensureDetailed(year);
		return year;
	}

	@Override
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

	@Override
	public PlexPhotoEditor editor() {
		return new PhotoEditor(this);
	}

	@Override
	public PlexPhotoSection section() {
		return (PlexPhotoSection) super.section();
	}

	@Override
	public PlexPhotoalbum parent() {
		return (PlexPhotoalbum) super.parent();
	}
}
