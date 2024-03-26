package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexMedia;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTag;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackEditor;

class Track extends Grandchild<PlexArtist, PlexAlbum, PlexMusicSection> implements PlexTrack {
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	private String createdAtTZOffset;
	private Long duration;
	@JsonProperty("Media")
	@JsonDeserialize(contentAs = Media.class)
	private List<PlexMedia> media;
	@JsonProperty("Mood")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> moods;
	private Date originallyAvailableAt;
	private String originalTitle;
	private Integer ratingCount;

	public Track() {
		createdAtAccuracy = new ArrayList<>();
		media = new ArrayList<>();
		moods = new ArrayList<>();
		
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		Track t = (Track) source;
		setCreatedAtAccuracy(t.getCreatedAtAccuracy());
		setCreatedAtTZOffset(t.getCreatedAtTZOffset());
		setDuration(t.getDuration());
		setMedia(t.getMedia());
		setMoods(t.getMoods());
		setOriginallyAvailableAt(t.getOriginallyAvailableAt());
		setOriginalTitle(t.getOriginalTitle());
		setRatingCount(t.getRatingCount());
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
		return PlexTrack.super.typeId();
	}

	@Override
	public PlexTrackEditor editor() {
		return new TrackEditor(this);
	}
}
