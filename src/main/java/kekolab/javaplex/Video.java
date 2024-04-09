package kekolab.javaplex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexMedia;
import kekolab.javaplex.model.PlexVideo;
import kekolab.javaplex.model.PlexVideoEditor;

public abstract class Video extends Mediatag implements PlexVideo {
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

	@Override
	public String getContentRating() {
		ensureDetailed(contentRating);
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	@Override
	public Long getDuration() {
		ensureDetailed(duration);
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@Override
	public List<PlexMedia> getMedia() {
		ensureDetailed(media);
		return media;
	}

	public void setMedia(List<PlexMedia> media) {
		this.media = media;
	}

	@Override
	public Date getOriginallyAvailableAt() {
		ensureDetailed(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	@Override
	public String getOriginalTitle() {
		ensureDetailed(originalTitle);
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	@Override
	public String getStudio() {
		ensureDetailed(studio);
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	@Override
	public Integer getYear() {
		ensureDetailed(year);
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public Boolean getContentRatingLocked() {
		return getFieldLocked("contentRating");
	}

	@Override
	public PlexVideoEditor editor() {
		return new VideoEditor(this);
	}
}
