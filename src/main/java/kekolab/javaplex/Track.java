package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexMedia;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTag;
import kekolab.javaplex.model.PlexTrack;

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


	@JsonIgnore
	private FieldEditor<List<PlexTag>> moodEditor;
	@JsonIgnore
	private FieldEditor<Boolean> moodLockEditor;

	public Track() {
		createdAtAccuracy = new ArrayList<>();
		media = new ArrayList<>();
		moods = new ArrayList<>();
		moodEditor = new TagListFieldEditor("mood", this::getMoods);
		moodLockEditor = new BooleanFieldEditor("mood.locked", this::isMoodsLocked);
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

	public boolean isMoodsLocked() {
		return isLocked("mood");
	}

	public void editMoods(List<PlexTag> moods) {
		editTaglist(moodEditor, moods);
	}

	public void editMoodsLock(boolean locked) {
		moodLockEditor.setValue(locked);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.addAll(Arrays.asList(moodEditor, moodLockEditor));
		return fieldEditors;
	}

	@Override
	public int typeId() {
		return PlexTrack.super.typeId();
	}
}
