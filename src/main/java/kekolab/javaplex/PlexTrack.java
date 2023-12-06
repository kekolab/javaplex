package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.StringListDeserializer;

public class PlexTrack extends PlexMediatag<PlexMusicSection> {
	public static final int TYPE_ID = 10;
	public static final String TYPE_DESCRIPTION = "track";
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

	@JsonIgnore
	private GrandchildDelegate<PlexAlbum, PlexArtist> grandchild;

	@JsonIgnore
	private TagListFieldEditor moodEditor;

	public PlexTrack() {
		createdAtAccuracy = new ArrayList<>();
		media = new ArrayList<>();
		moods = new ArrayList<>();
		grandchild = new GrandchildDelegate<>(this::server, this::getClient, this::getToken);
		moodEditor = new TagListFieldEditor("mood", this::getMoods);
	}

	@Override
	protected void clear() {
		super.clear();
		createdAtAccuracy.clear();
		createdAtTZOffset = null;
		duration = null;
		grandchild.clear();
		media.clear();
		moods.clear();
		originallyAvailableAt = null;
		originalTitle = null;
		ratingCount = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexTrack track) {
			createdAtAccuracy = track.createdAtAccuracy;
			createdAtTZOffset = track.createdAtTZOffset;
			duration = track.duration;
			grandchild.update(track.grandchild);
			media.clear();
			media.addAll(track.media);
			moods.clear();
			moods.addAll(track.moods);
			originallyAvailableAt = track.originallyAvailableAt;
			originalTitle = track.originalTitle;
			ratingCount = track.ratingCount;
		} else
			throw new ClassCastException("Cannot cast item to PlexTrack");
	}

	public List<PlexMedia> getMedia() {
		fetchDetailedIfNullOrEmpty(media);
		return media;
	}

	public void setMedia(List<PlexMedia> media) {
		this.media = media;
	}

	public Integer getRatingCount() {
		fetchDetailedIfNullOrEmpty(ratingCount);
		return ratingCount;
	}

	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}

	public List<PlexTag> getMoods() {
		fetchDetailedIfNullOrEmpty(moods);
		return moods;
	}

	public void setMoods(List<PlexTag> moods) {
		this.moods = moods;
	}

	public List<String> getCreatedAtAccuracy() {
		fetchDetailedIfNullOrEmpty(createdAtAccuracy);
		return createdAtAccuracy;
	}

	public String getCreatedAtTZOffset() {
		fetchDetailedIfNullOrEmpty(createdAtTZOffset);
		return createdAtTZOffset;
	}

	public void setCreatedAtAccuracy(List<String> createdAtAccuracy) {
		this.createdAtAccuracy = createdAtAccuracy;
	}

	public void setCreatedAtTZOffset(String createdAtTZOffset) {
		this.createdAtTZOffset = createdAtTZOffset;
	}

	public String getOriginalTitle() {
		fetchDetailedIfNullOrEmpty(originalTitle);
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public Long getDuration() {
		fetchDetailedIfNullOrEmpty(duration);
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Date getOriginallyAvailableAt() {
		fetchDetailedIfNullOrEmpty(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	public String getParentGuid() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentGuid());
		return grandchild.getParentGuid();
	}

	public Integer getParentIndex() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentIndex());
		return grandchild.getParentIndex();
	}

	public String getParentKey() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentKey());
		return grandchild.getParentKey();
	}

	public Integer getParentRatingKey() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentRatingKey());
		return grandchild.getParentRatingKey();
	}

	public String getParentStudio() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentStudio());
		return grandchild.getParentStudio();
	}

	public String getParentTheme() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentTheme());
		return grandchild.getParentTheme();
	}

	public String getParentThumb() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentThumb());
		return grandchild.getParentThumb();
	}

	public String getParentTitle() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentTitle());
		return grandchild.getParentTitle();
	}

	public Integer getParentYear() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentYear());
		return grandchild.getParentYear();
	}

	public PlexAlbum parent() {
		fetchDetailedIfNullOrEmpty(grandchild.parent());
		return (PlexAlbum) grandchild.parent();
	}

	public URI parentKey() {
		fetchDetailedIfNullOrEmpty(grandchild.parentKey());
		return grandchild.parentKey();
	}

	public URI parentRatingKey() {
		fetchDetailedIfNullOrEmpty(grandchild.parentRatingKey());
		return grandchild.parentRatingKey();
	}

	public URI parentTheme() {
		fetchDetailedIfNullOrEmpty(parentTheme());
		return parentTheme();
	}

	public URI parentThumb() {
		fetchDetailedIfNullOrEmpty(parentThumb());
		return parentThumb();
	}

	public void setParentGuid(String parentGuid) {
		grandchild.setParentGuid(parentGuid);
	}

	public void setParentIndex(Integer parentIndex) {
		grandchild.setParentIndex(parentIndex);
	}

	public void setParentKey(String parentKey) {
		grandchild.setParentKey(parentKey);
	}

	public void setParentRatingKey(Integer parentRatingKey) {
		grandchild.setParentRatingKey(parentRatingKey);
	}

	public void setParentStudio(String parentStudio) {
		grandchild.setParentStudio(parentStudio);
	}

	public void setParentTheme(String parentTheme) {
		grandchild.setParentTheme(parentTheme);
	}

	public void setParentThumb(String parentThumb) {
		grandchild.setParentThumb(parentThumb);
	}

	public void setParentTitle(String parentTitle) {
		grandchild.setParentTitle(parentTitle);
	}

	public void setParentYear(Integer parentYear) {
		grandchild.setParentYear(parentYear);
	}

	@Override
	public PlexMusicSection section() {
		return (PlexMusicSection) super.section();
	}

	public PlexArtist grandparent() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparent());
		return (PlexArtist) grandchild.grandparent();
	}

	public String getGrandparentArt() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentArt());
		return grandchild.getGrandparentArt();
	}

	public URI grandparentArt() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentArt());
		return grandchild.grandparentArt();
	}

	public String getGrandparentGuid() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentGuid());
		return grandchild.getGrandparentGuid();
	}

	public String getGrandparentKey() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentKey());
		return grandchild.getGrandparentKey();
	}

	public URI grandparentKey() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentKey());
		return grandchild.grandparentKey();
	}

	public Integer getGrandparentRatingKey() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentRatingKey());
		return grandchild.getGrandparentRatingKey();
	}

	public URI grandparentRatingKey() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentRatingKey());
		return grandchild.grandparentRatingKey();
	}

	public String getGrandparentTheme() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentTheme());
		return grandchild.getGrandparentTheme();
	}

	public URI grandparentTheme() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentTheme());
		return grandchild.grandparentTheme();
	}

	public String getGrandparentThumb() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentThumb());
		return grandchild.getGrandparentThumb();
	}

	public URI grandparentThumb() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentThumb());
		return grandchild.grandparentThumb();
	}

	public String getGrandparentTitle() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentTitle());
		return grandchild.getGrandparentTitle();
	}

	public Integer getGrandparentYear() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentYear());
		return grandchild.getGrandparentYear();
	}

	public void setGrandparentArt(String art) {
		grandchild.setGrandparentArt(art);
	}

	public void setGrandparentGuid(String guid) {
		grandchild.setGrandparentGuid(guid);
	}

	public void setGrandparentKey(String key) {
		grandchild.setGrandparentKey(key);
	}

	public void setGrandparentRatingKey(Integer ratingKey) {
		grandchild.setGrandparentRatingKey(ratingKey);
	}

	public void setGrandparentTheme(String theme) {
		grandchild.setGrandparentTheme(theme);
	}

	public void setGrandparentThumb(String thumb) {
		grandchild.setGrandparentThumb(thumb);
	}

	public void setGrandparentTitle(String title) {
		grandchild.setGrandparentTitle(title);
	}

	public void setGrandparentYear(Integer year) {
		grandchild.setGrandparentYear(year);
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	public void editMoods(List<PlexTag> moods) {
		editTaglist(moodEditor, moods);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.add(moodEditor);
		return fieldEditors;
	}
}
