package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.filtering.PlexFilterableBoolean;
import kekolab.javaplex.filtering.PlexFilterableDate;
import kekolab.javaplex.filtering.PlexFilterableInteger;
import kekolab.javaplex.filtering.PlexFilterableString;
import kekolab.javaplex.filtering.PlexFilterableTag;
import kekolab.javaplex.mappers.StringListDeserializer;

public class PlexTrack extends Grandchild<PlexMusicSection, PlexAlbum, PlexArtist> {
	public static final int TYPE_ID = 10;
	public static final String TYPE_DESCRIPTION = "track";

	public static final PlexFilterableString TITLE = () -> "track.title";
	public static final PlexFilterableTag MOOD = () -> "track.mood";
	public static final PlexFilterableInteger PLAYS = () -> "track.viewCount";
	public static final PlexFilterableDate LAST_PLAYED = () -> "track.lastViewedAt";
	public static final PlexFilterableInteger SKIPS = () -> "track.skipCount";
	public static final PlexFilterableDate LAST_SKIPPED = () -> "track.lastSkippedAt";
	public static final PlexFilterableInteger RATING = () -> "track.userRating";
	public static final PlexFilterableDate LAST_RATED = () -> "track.lastSkippedAt";
	public static final PlexFilterableDate DATE_ADDED = () -> "track.addedAt";
	public static final PlexFilterableInteger FILE_SIZE = () -> "track.mediaSize";
	public static final PlexFilterableInteger BITRATE = () -> "track.mediaBitrate";
	public static final PlexFilterableBoolean TRASHED = () -> "track.trash";

	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	private String createdAtTZOffset;
	private Long duration;
	@JsonProperty("Media")
	private List<PlexMedia> media;
	@JsonProperty("Mood")
	private List<PlexTag> moods;
	private Date originallyAvailableAt;
	private String originalTitle;
	private Integer ratingCount;

	public PlexTrack() {
		createdAtAccuracy = new ArrayList<>();
		media = new ArrayList<>();
		moods = new ArrayList<>();
	}

	@Override
	void update(PlexMetadata source) {
		super.update(source);
		PlexTrack track = (PlexTrack) source;
		setCreatedAtAccuracy(track.getCreatedAtAccuracy());
		setCreatedAtTZOffset(track.getCreatedAtTZOffset());
		setDuration(track.getDuration());
		setMedia(track.getMedia());
		setMoods(track.getMoods());
		setOriginallyAvailableAt(track.getOriginallyAvailableAt());
		setOriginalTitle(track.getOriginalTitle());
		setRatingCount(track.getRatingCount());
	}

	public List<PlexMedia> getMedia() {
		ensureDetailed(media);
		return media;
	}

	public void setMedia(List<PlexMedia> media) {
		this.media = media;
	}

	public Integer getRatingCount() {
		ensureDetailed(ratingCount);
		return ratingCount;
	}

	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}

	public List<PlexTag> getMoods() {
		ensureDetailed(moods);
		return moods;
	}

	public void setMoods(List<PlexTag> moods) {
		this.moods = moods;
	}

	public List<String> getCreatedAtAccuracy() {
		ensureDetailed(createdAtAccuracy);
		return createdAtAccuracy;
	}

	public String getCreatedAtTZOffset() {
		ensureDetailed(createdAtTZOffset);
		return createdAtTZOffset;
	}

	public void setCreatedAtAccuracy(List<String> createdAtAccuracy) {
		this.createdAtAccuracy = createdAtAccuracy;
	}

	public void setCreatedAtTZOffset(String createdAtTZOffset) {
		this.createdAtTZOffset = createdAtTZOffset;
	}

	public String getOriginalTitle() {
		ensureDetailed(originalTitle);
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public Long getDuration() {
		ensureDetailed(duration);
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Date getOriginallyAvailableAt() {
		ensureDetailed(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	public URI parentTheme() {
		ensureDetailed(parentTheme());
		return parentTheme();
	}

	public URI parentThumb() {
		ensureDetailed(parentThumb());
		return parentThumb();
	}

	public Boolean getMoodsLocked() {
		return getFieldLocked("mood");
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	public void editMoods(List<String> value, Optional<Boolean> lock) {
		editList("mood", value, getMoods());
		if (lock.isPresent())
			editField("mood.locked", lock.get() ? "1" : "0");
	}
}
