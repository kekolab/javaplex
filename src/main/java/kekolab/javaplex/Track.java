package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.StringListDeserializer;
import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexMedia;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTag;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackEditor;

public class Track extends Grandchild implements PlexTrack {
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
	private UriProvider art;
	private UriProvider thumb;

	public Track() {
		createdAtAccuracy = new ArrayList<>();
		media = new ArrayList<>();
		moods = new ArrayList<>();
		art = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		PlexTrack t = (PlexTrack) source;
		setCreatedAtAccuracy(t.getCreatedAtAccuracy());
		setCreatedAtTZOffset(t.getCreatedAtTZOffset());
		setDuration(t.getDuration());
		setMedia(t.getMedia());
		setMoods(t.getMoods());
		setOriginallyAvailableAt(t.getOriginallyAvailableAt());
		setOriginalTitle(t.getOriginalTitle());
		setRatingCount(t.getRatingCount());
		setArt(t.getArt());
		setThumb(t.getThumb());
	}

	@Override
	public String getArt() {
		return (String) art.getValue();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	@Override
	public URI art() {
		return this.art.uri();
	}

	@Override
	public String getThumb() {
		return (String) thumb.getValue();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	@Override
	public URI thumb() {
		return this.thumb.uri();
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
	public Integer getRatingCount() {
		ensureDetailed(ratingCount);
		return ratingCount;
	}

	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}

	@Override
	public List<PlexTag> getMoods() {
		ensureDetailed(moods);
		return moods;
	}

	public void setMoods(List<PlexTag> moods) {
		this.moods = moods;
	}

	@Override
	public List<String> getCreatedAtAccuracy() {
		ensureDetailed(createdAtAccuracy);
		return createdAtAccuracy;
	}

	@Override
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

	@Override
	public String getOriginalTitle() {
		ensureDetailed(originalTitle);
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
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
	public Date getOriginallyAvailableAt() {
		ensureDetailed(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	@Override
	public URI parentTheme() {
		ensureDetailed(parentTheme());
		return parentTheme();
	}

	@Override
	public URI parentThumb() {
		ensureDetailed(parentThumb());
		return parentThumb();
	}

	@Override
	public Boolean getMoodsLocked() {
		return getFieldLocked("mood");
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	@Override
	public PlexTrackEditor editor() {
		return new TrackEditor(this);
	}

	@Override
	public PlexAlbum parent() {
		return (PlexAlbum) super.parent();
	}

	@Override
	public PlexArtist grandparent() {
		return (PlexArtist) super.grandparent();
	}

	@Override
	public PlexMusicSection section() {
		return (PlexMusicSection) super.section();
	}
}
