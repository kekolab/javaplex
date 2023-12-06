package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlexAlbum extends PlexMediatag<PlexMusicSection> {
	public static final int TYPE_ID = 10;
	public static final String TYPE_DESCRIPTION = "album";
	@JsonProperty("Director")
	private List<PlexTag> directors;
	@JsonProperty("Format")
	private List<PlexTag> formats;
	@JsonProperty("Genre")
	private List<PlexTag> genres;
	private Integer leafCount;
	private Integer loudnessAnalysisVersion;
	@JsonProperty("Mood")
	private List<PlexTag> moods;
	private Date originallyAvailableAt;
	private String studio;
	@JsonProperty("Subformat")
	private List<PlexTag> subformats;
	@JsonProperty("Style")
	private List<PlexTag> styles;
	private Double rating;
	private Integer viewedLeafCount;
	private Integer year;
	private UriProvider art, thumb;

	@JsonIgnore
	private ChildDelegate<PlexArtist> child;

	@JsonIgnore
	private FieldEditor<List<PlexTag>> genreEditor;
	@JsonIgnore
	private FieldEditor<Boolean> genreLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> moodEditor;
	@JsonIgnore
	private FieldEditor<Boolean> moodLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> styleEditor;
	@JsonIgnore
	private FieldEditor<Boolean> styleLockEditor;

	public PlexAlbum() {
		art = new UriProvider(this::uri);
		directors = new ArrayList<>();
		formats = new ArrayList<>();
		genres = new ArrayList<>();
		moods = new ArrayList<>();
		subformats = new ArrayList<>();
		styles = new ArrayList<>();
		thumb = new UriProvider(this::uri);
		child = new ChildDelegate<>(this::server, this::getClient, this::getToken);
		genreEditor = new TagListFieldEditor("genre", this::getGenres);
		genreLockEditor = new BooleanFieldEditor("genre.locked", this::isGenresLocked);
		moodEditor = new TagListFieldEditor("mood", this::getMoods);
		moodLockEditor = new BooleanFieldEditor("mood.locked", this::isMoodsLocked);
		styleEditor = new TagListFieldEditor("style", this::getStyles);
		styleLockEditor = new BooleanFieldEditor("style.locked", this::isStylesLocked);
	}

	@Override
	protected void clear() {
		super.clear();
		art.setValue(null);
		directors.clear();
		formats.clear();
		genres.clear();
		leafCount = null;
		loudnessAnalysisVersion = null;
		moods.clear();
		originallyAvailableAt = null;
		rating = null;
		studio = null;
		styles.clear();
		subformats.clear();
		thumb.setValue(null);
		viewedLeafCount = null;
		year = null;
		child.clear();
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexAlbum album) {
			art.setValue(album.art.getValue());
			directors.clear();
			directors.addAll(album.directors);
			formats.clear();
			formats.addAll(album.formats);
			genres.clear();
			genres.addAll(album.genres);
			leafCount = album.leafCount;
			loudnessAnalysisVersion = album.loudnessAnalysisVersion;
			moods.clear();
			moods.addAll(album.moods);
			originallyAvailableAt = album.originallyAvailableAt;
			rating = album.rating;
			studio = album.studio;
			styles.clear();
			styles.addAll(album.styles);
			subformats.clear();
			subformats.addAll(album.subformats);
			thumb.setValue(album.thumb.getValue());
			viewedLeafCount = album.viewedLeafCount;
			year = album.year;
			child.update(album.child);
		} else
			throw new ClassCastException("Cannot cast item to PlexAlbum");
	}

	public Double getRating() {
		fetchDetailedIfNullOrEmpty(rating);
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public List<PlexTag> getStyles() {
		fetchDetailedIfNullOrEmpty(styles);
		return styles;
	}

	public void setStyles(List<PlexTag> styles) {
		this.styles = styles;
	}

	public List<PlexTag> getFormats() {
		fetchDetailedIfNullOrEmpty(formats);
		return formats;
	}

	public void setFormats(List<PlexTag> formats) {
		this.formats = formats;
	}

	public Integer getLoudnessAnalysisVersion() {
		fetchDetailedIfNullOrEmpty(loudnessAnalysisVersion);
		return loudnessAnalysisVersion;
	}

	public void setLoudnessAnalysisVersion(Integer loudnessAnalysisVersion) {
		this.loudnessAnalysisVersion = loudnessAnalysisVersion;
	}

	public List<PlexTag> getSubformats() {
		fetchDetailedIfNullOrEmpty(subformats);
		return subformats;
	}

	public void setSubformats(List<PlexTag> subformats) {
		this.subformats = subformats;
	}

	public List<PlexTag> getDirectors() {
		fetchDetailedIfNullOrEmpty(directors);
		return directors;
	}

	public void setDirectors(List<PlexTag> directors) {
		this.directors = directors;
	}

	public Integer getLeafCount() {
		fetchDetailedIfNullOrEmpty(leafCount);
		return leafCount;
	}

	public void setLeafCount(Integer leafCount) {
		this.leafCount = leafCount;
	}

	public List<PlexTag> getMoods() {
		fetchDetailedIfNullOrEmpty(moods);
		return moods;
	}

	public void setMoods(List<PlexTag> moods) {
		this.moods = moods;
	}

	public String getStudio() {
		fetchDetailedIfNullOrEmpty(studio);
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public Integer getViewedLeafCount() {
		fetchDetailedIfNullOrEmpty(viewedLeafCount);
		return viewedLeafCount;
	}

	public void setViewedLeafCount(Integer viewedLeafCount) {
		this.viewedLeafCount = viewedLeafCount;
	}

	public List<PlexTag> getGenres() {
		fetchDetailedIfNullOrEmpty(genres);
		return genres;
	}

	public void setGenres(List<PlexTag> genres) {
		this.genres = genres;
	}

	public Date getOriginallyAvailableAt() {
		fetchDetailedIfNullOrEmpty(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	public Integer getYear() {
		fetchDetailedIfNullOrEmpty(year);
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public PlexArtist parent() {
		fetchDetailedIfNullOrEmpty(child.parent());
		return (PlexArtist) child.parent();
	}

	public String getParentGuid() {
		fetchDetailedIfNullOrEmpty(child.getParentGuid());
		return child.getParentGuid();
	}

	public Integer getParentIndex() {
		fetchDetailedIfNullOrEmpty(child.getParentIndex());
		return child.getParentIndex();
	}

	public String getParentKey() {
		fetchDetailedIfNullOrEmpty(child.getParentKey());
		return child.getParentKey();
	}

	public URI parentKey() {
		return child.parentKey();
	}

	public Integer getParentRatingKey() {
		fetchDetailedIfNullOrEmpty(child.getParentRatingKey());
		return child.getParentRatingKey();
	}

	public URI parentRatingKey() {
		return child.parentRatingKey();
	}

	public String getParentStudio() {
		fetchDetailedIfNullOrEmpty(child.getParentStudio());
		return child.getParentStudio();
	}

	public String getParentTheme() {
		fetchDetailedIfNullOrEmpty(child.getParentTheme());
		return child.getParentTheme();
	}

	public URI parentTheme() {
		return child.parentTheme();
	}

	public String getParentThumb() {
		fetchDetailedIfNullOrEmpty(child.getParentThumb());
		return child.getParentThumb();
	}

	public URI parentThumb() {
		return child.parentThumb();
	}

	public String getParentTitle() {
		fetchDetailedIfNullOrEmpty(child.getParentTitle());
		return child.getParentTitle();
	}

	public Integer getParentYear() {
		fetchDetailedIfNullOrEmpty(child.getParentYear());
		return child.getParentYear();
	}

	public void setParentGuid(String parentGuid) {
		child.setParentGuid(parentGuid);
	}

	public void setParentYear(Integer parentYear) {
		child.setParentYear(parentYear);
	}

	public void setParentTitle(String parentTitle) {
		child.setParentTitle(parentTitle);
	}

	public void setParentThumb(String parentThumb) {
		child.setParentThumb(parentThumb);
	}

	public void setParentTheme(String parentTheme) {
		child.setParentTheme(parentTheme);
	}

	public void setParentStudio(String parentStudio) {
		child.setParentStudio(parentStudio);
	}

	public void setParentKey(String parentKey) {
		child.setParentKey(parentKey);
	}

	public void setParentRatingKey(Integer parentRatingKey) {
		child.setParentRatingKey(parentRatingKey);
	}

	public void setParentIndex(Integer parentIndex) {
		child.setParentIndex(parentIndex);
	}

	@Override
	public PlexMusicSection section() {
		return (PlexMusicSection) super.section();
	}

	public List<PlexTrack> children() {
		return new MetadataContainer<PlexTrack, PlexDirectory>(key(), getClient(), getToken(), server()).getMetadata();
	}

	public String getArt() {
		fetchDetailedIfNullOrEmpty(art.getValue());
		return (String) art.getValue();
	}

	public URI art() {
		fetchDetailedIfNullOrEmpty(art.uri());
		return art.uri();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public String getThumb() {
		fetchDetailedIfNullOrEmpty(thumb.getValue());
		return (String) thumb.getValue();
	}

	public URI thumb() {
		fetchDetailedIfNullOrEmpty(thumb.uri());
		return thumb.uri();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	public boolean isGenresLocked() {
		return isLocked("genre");
	}

	public boolean isMoodsLocked() {
		return isLocked("mood");
	}

	public boolean isStylesLocked() {
		return isLocked("style");
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	public void editMoods(List<PlexTag> moods) {
		editTaglist(moodEditor, moods);
	}

	public void editMoodsLock(boolean locked) {
		moodLockEditor.setValue(locked);
	}

	public void editStyles(List<PlexTag> styles) {
		editTaglist(styleEditor, styles);
	}

		public void editStylesLock(boolean locked) {
		styleLockEditor.setValue(locked);
	}

	public void editGenres(List<PlexTag> genres) {
		editTaglist(genreEditor, genres);
	}

	public void editGenresLock(boolean locked) {
		genreLockEditor.setValue(locked);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.addAll(Arrays.asList(genreEditor, genreLockEditor, styleEditor, styleLockEditor, moodEditor, moodLockEditor));
		return fieldEditors;
	}

}
