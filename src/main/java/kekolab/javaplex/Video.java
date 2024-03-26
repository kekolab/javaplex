package kekolab.javaplex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexMedia;
import kekolab.javaplex.model.PlexSection;
import kekolab.javaplex.model.PlexVideo;
import kekolab.javaplex.model.PlexVideoEditor;

abstract class Video<S extends PlexSection<?, ?>> extends Mediatag<S> implements PlexVideo<S> {
	private String contentRating;
	private Long duration;
	@JsonProperty("Media")
	@JsonDeserialize(contentAs = Media.class)
	private List<PlexMedia> media;
	private Date originallyAvailableAt;
	private String originalTitle;
	private String studio;
	private Integer year;

	public Video() {
		media = new ArrayList<>();
	}

	public String getContentRating() {
		ensureDetailed(contentRating);
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public Long getDuration() {
		ensureDetailed(duration);
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public List<PlexMedia> getMedia() {
		ensureDetailed(media);
		return media;
	}

	public void setMedia(List<PlexMedia> media) {
		this.media = media;
	}

	public Date getOriginallyAvailableAt() {
		ensureDetailed(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	public String getOriginalTitle() {
		ensureDetailed(originalTitle);
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getStudio() {
		ensureDetailed(studio);
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public Integer getYear() {
		ensureDetailed(year);
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Boolean getContentRatingLocked() {
		return getFieldLocked("contentRating");
	}

	@Override
	public PlexVideoEditor editor() {
		return new VideoEditor(this);
	}
}
