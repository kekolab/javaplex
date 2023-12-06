package kekolab.javaplex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PlexVideo<S extends PlexSection<?, ?>> extends PlexMediatag<S> {
	private String contentRating;
	private Long duration;
	@JsonProperty("Media")
	private List<PlexMedia> media;
	private Date originallyAvailableAt;
	private String originalTitle;
	private String studio;
	private Integer year;

	@JsonIgnore
	private FieldEditor<String> contentRatingEditor;
	@JsonIgnore
	private FieldEditor<Boolean> contentRatingLockEditor;

	public PlexVideo() {
		media = new ArrayList<>();
		contentRatingEditor = new StringFieldEditor("contentRating.value", this::getContentRating, true);
		contentRatingLockEditor = new BooleanFieldEditor("contentRating.locked", this::isContentRatingLocked);
	}

	@Override
	protected void clear() {
		super.clear();
		contentRating = null;
		duration = null;
		media.clear();
		originallyAvailableAt = null;
		originalTitle = null;
		studio = null;
		year = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexVideo<?> video) {
			contentRating = video.contentRating;
			duration = video.duration;
			media.clear();
			media.addAll(video.media);
			originallyAvailableAt = video.originallyAvailableAt;
			originalTitle = video.originalTitle;
			studio = video.studio;
			year = video.year;
		} else
			throw new ClassCastException("Cannot cast item to PlexVideo");
	}

	public String getContentRating() {
		fetchDetailedIfNullOrEmpty(contentRating);
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public Long getDuration() {
		fetchDetailedIfNullOrEmpty(duration);
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public List<PlexMedia> getMedia() {
		fetchDetailedIfNullOrEmpty(media);
		return media;
	}

	public void setMedia(List<PlexMedia> media) {
		this.media = media;
	}

	public Date getOriginallyAvailableAt() {
		fetchDetailedIfNullOrEmpty(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	public String getOriginalTitle() {
		fetchDetailedIfNullOrEmpty(originalTitle);
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getStudio() {
		fetchDetailedIfNullOrEmpty(studio);
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public Integer getYear() {
		fetchDetailedIfNullOrEmpty(year);
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public boolean isContentRatingLocked() {
		return isLocked("contentRating");
	}

	public void editContentRating(String contentRating) {
		contentRatingEditor.setValue(contentRating);
	}

	public void editContentRatingLock(boolean locked) {
		contentRatingLockEditor.setValue(locked);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.addAll(Arrays.asList(
				contentRatingEditor, contentRatingLockEditor));
		return fieldEditors;
	}
}
