package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTag;
import kekolab.javaplex.model.PlexTrack;

class Artist extends Mediatag<PlexMusicSection> implements PlexArtist {
	private Integer albumSort;
	private Integer childCount;
	@JsonProperty("Country")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> countries;
	@JsonProperty("Genre")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> genres;
	@JsonProperty("Location")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> locations;
	@JsonProperty("Mood")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> moods;
	@JsonProperty("Similar")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> similars;
	@JsonProperty("Style")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> styles;
	private UriProvider art, thumb;

	@JsonIgnore
	private FieldEditor<List<PlexTag>> countryEditor;
	@JsonIgnore
	private FieldEditor<Boolean> countryLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> genreEditor;
	@JsonIgnore
	private FieldEditor<Boolean> genreLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> moodEditor;
	@JsonIgnore
	private FieldEditor<Boolean> moodLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> similarEditor;
	@JsonIgnore
	private FieldEditor<Boolean> similarLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> styleEditor;
	@JsonIgnore
	private FieldEditor<Boolean> styleLockEditor;

	public Artist() {
		art = new UriProvider(this::uri);
		countries = new ArrayList<>();
		genres = new ArrayList<>();
		locations = new ArrayList<>();
		moods = new ArrayList<>();
		similars = new ArrayList<>();
		styles = new ArrayList<>();
		thumb = new UriProvider(this::uri);

		countryEditor = new TagListFieldEditor("country", this::getCountries);
		countryLockEditor = new BooleanFieldEditor("country.locked", this::isCountriesLocked);
		genreEditor = new TagListFieldEditor("genre", this::getGenres);
		genreLockEditor = new BooleanFieldEditor("genre.locked", this::isGenresLocked);
		moodEditor = new TagListFieldEditor("mood", this::getMoods);
		moodLockEditor = new BooleanFieldEditor("mood.locked", this::isMoodsLocked);
		similarEditor = new TagListFieldEditor("similar", this::getSimilars);
		similarLockEditor = new BooleanFieldEditor("similar.locked", this::isSimilarsLocked);
		styleEditor = new TagListFieldEditor("style", this::getStyles);
		styleLockEditor = new BooleanFieldEditor("style.locked", this::isStylesLocked);
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		Artist a = (Artist) source;
		setAlbumSort(a.getAlbumSort());
		setChildCount(a.getChildCount());
		setCountries(a.getCountries());
		setGenres(a.getGenres());
		setLocations(a.getLocations());
		setMoods(a.getMoods());
		setSimilars(a.getSimilars());
		setStyles(a.getStyles());
		setArt(a.getArt());
		setThumb(a.getThumb());
	}


	public List<PlexTag> getStyles() {
		ensureDetailed(styles);
		return styles;
	}

	public void setStyles(List<PlexTag> styles) {
		this.styles = styles;
	}

	public Integer getAlbumSort() {
		ensureDetailed(albumSort);
		return albumSort;
	}

	public void setAlbumSort(Integer albumSort) {
		this.albumSort = albumSort;
	}

	public List<PlexTag> getLocations() {
		ensureDetailed(locations);
		return locations;
	}

	public void setLocations(List<PlexTag> locations) {
		this.locations = locations;
	}

	public List<PlexTag> getCountries() {
		ensureDetailed(countries);
		return countries;
	}

	public void setCountries(List<PlexTag> countries) {
		this.countries = countries;
	}

	public List<PlexTag> getMoods() {
		ensureDetailed(moods);
		return moods;
	}

	public void setMoods(List<PlexTag> moods) {
		this.moods = moods;
	}

	public List<PlexTag> getSimilars() {
		ensureDetailed(similars);
		return similars;
	}

	public void setSimilars(List<PlexTag> similars) {
		this.similars = similars;
	}

	public List<PlexTag> getGenres() {
		ensureDetailed(genres);
		return genres;
	}

	public void setGenres(List<PlexTag> genres) {
		this.genres = genres;
	}

	public Integer getChildCount() {
		ensureDetailed(childCount);
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	@Override
	public MusicSection section() {
		return (MusicSection) super.section();
	}

	public List<PlexAlbum> children() {
		return new MetadataContainer<PlexAlbum, Directory>(key(), getClient(), getToken(), getServer()).getMetadata();
	}

	public List<PlexTrack> grandchildren() {
		URI uri;
		try {
			uri = new URIBuilder(ratingKey()).appendPath("allLeaves").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexTrack, Directory>(uri, getClient(), getToken(), getServer()).getMetadata();
	}

	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	public URI art() {
		ensureDetailed(art.getValue());
		return art.uri();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public String getThumb() {
		ensureDetailed(thumb.getValue());
		return (String) thumb.getValue();
	}

	public URI thumb() {
		ensureDetailed(thumb.getValue());
		return thumb.uri();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	public boolean isCountriesLocked() {
		return isLocked("country");
	}

	public boolean isGenresLocked() {
		return isLocked("genre");
	}

	public boolean isSimilarsLocked() {
		return isLocked("similar");
	}

	public boolean isMoodsLocked() {
		return isLocked("mood");
	}

	public boolean isStylesLocked() {
		return isLocked("style");
	}

	public void editCountries(List<PlexTag> countries) {
		editTaglist(countryEditor, countries);
	}

	public void editCountriesLock(boolean locked) {
		countryLockEditor.setValue(locked);
	}

	public void editMoods(List<PlexTag> moods) {
		editTaglist(moodEditor, moods);
	}

	public void editMoodsLock(boolean locked) {
		moodLockEditor.setValue(locked);
	}

	public void editSimilars(List<PlexTag> similars) {
		editTaglist(similarEditor, similars);
	}

	public void editSimilarsLock(boolean locked) {
		similarLockEditor.setValue(locked);
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
		fieldEditors.addAll(Arrays.asList(countryEditor, countryLockEditor, genreEditor,
				genreLockEditor, moodEditor, moodLockEditor, styleEditor, styleLockEditor,
				similarEditor, similarLockEditor));
		return fieldEditors;
	}

	@Override
	public int typeId() {
		return PlexArtist.super.typeId();
	}
}
