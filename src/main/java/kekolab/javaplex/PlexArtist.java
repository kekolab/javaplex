package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlexArtist extends PlexMediatag<PlexMusicSection> {
	public static final int TYPE_ID = 8;
	public static final String TYPE_DESCRIPTION = "artist";
	private Integer albumSort;
	private Integer childCount;
	@JsonProperty("Country")
	private List<PlexTag> countries;
	@JsonProperty("Genre")
	private List<PlexTag> genres;
	@JsonProperty("Location")
	private List<PlexTag> locations;
	@JsonProperty("Mood")
	private List<PlexTag> moods;
	@JsonProperty("Similar")
	private List<PlexTag> similars;
	@JsonProperty("Style")
	private List<PlexTag> styles;
	private UriProvider art, thumb;

	@JsonIgnore
	private TagListFieldEditor countryEditor;
	@JsonIgnore
	private TagListFieldEditor genreEditor;
	@JsonIgnore
	private TagListFieldEditor moodEditor;
	@JsonIgnore
	private TagListFieldEditor similarEditor;
	@JsonIgnore
	private TagListFieldEditor styleEditor;

	public PlexArtist() {
		art = new UriProvider(this::uri);
		countries = new ArrayList<>();
		genres = new ArrayList<>();
		locations = new ArrayList<>();
		moods = new ArrayList<>();
		similars = new ArrayList<>();
		styles = new ArrayList<>();
		thumb = new UriProvider(this::uri);

		countryEditor = new TagListFieldEditor("country", this::getCountries);
		genreEditor = new TagListFieldEditor("genre", this::getGenres);
		moodEditor = new TagListFieldEditor("mood", this::getMoods);
		similarEditor = new TagListFieldEditor("similar", this::getSimilars);
		styleEditor = new TagListFieldEditor("style", this::getStyles);
	}

	@Override
	protected void clear() {
		super.clear();
		albumSort = null;
		art.setValue(null);
		countries.clear();
		childCount = null;
		genres.clear();
		locations.clear();
		moods.clear();
		similars.clear();
		styles.clear();
		thumb.setValue(null);
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexArtist artist) {
			albumSort = artist.albumSort;
			art.setValue(artist.art.getValue());
			countries.clear();
			countries.addAll(artist.countries);
			childCount = artist.childCount;
			genres.clear();
			genres.addAll(artist.genres);
			locations.clear();
			locations.addAll(artist.locations);
			moods.clear();
			moods.addAll(artist.moods);
			similars.clear();
			similars.addAll(artist.similars);
			styles.clear();
			styles.addAll(artist.styles);
			thumb.setValue(artist.thumb.getValue());
		} else
			throw new ClassCastException("Cannot cast item to PlexArtist");
	}

	public List<PlexTag> getStyles() {
		fetchDetailedIfNullOrEmpty(styles);
		return styles;
	}

	public void setStyles(List<PlexTag> styles) {
		this.styles = styles;
	}

	public Integer getAlbumSort() {
		fetchDetailedIfNullOrEmpty(albumSort);
		return albumSort;
	}

	public void setAlbumSort(Integer albumSort) {
		this.albumSort = albumSort;
	}

	public List<PlexTag> getLocations() {
		fetchDetailedIfNullOrEmpty(locations);
		return locations;
	}

	public void setLocations(List<PlexTag> locations) {
		this.locations = locations;
	}

	public List<PlexTag> getCountries() {
		fetchDetailedIfNullOrEmpty(countries);
		return countries;
	}

	public void setCountries(List<PlexTag> countries) {
		this.countries = countries;
	}

	public List<PlexTag> getMoods() {
		fetchDetailedIfNullOrEmpty(moods);
		return moods;
	}

	public void setMoods(List<PlexTag> moods) {
		this.moods = moods;
	}

	public List<PlexTag> getSimilars() {
		fetchDetailedIfNullOrEmpty(similars);
		return similars;
	}

	public void setSimilars(List<PlexTag> similars) {
		this.similars = similars;
	}

	public List<PlexTag> getGenres() {
		fetchDetailedIfNullOrEmpty(genres);
		return genres;
	}

	public void setGenres(List<PlexTag> genres) {
		this.genres = genres;
	}

	public Integer getChildCount() {
		fetchDetailedIfNullOrEmpty(childCount);
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	@Override
	public PlexMusicSection section() {
		return (PlexMusicSection) super.section();
	}

	public List<PlexAlbum> children() {
		return new MetadataContainer<PlexAlbum, PlexDirectory>(key(), getClient(), getToken(), server()).getMetadata();
	}

	public List<PlexTrack> grandchildren() {
		URI uri;
		try {
			uri = new URIBuilder(ratingKey()).appendPath("allLeaves").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexTrack, PlexDirectory>(uri, getClient(), getToken(), server()).getMetadata();
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

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	public void editCountries(List<PlexTag> countries) {
		editTaglist(countryEditor, countries);
	}

	public void editMoods(List<PlexTag> moods) {
		editTaglist(moodEditor, moods);
	}

	public void editSimilars(List<PlexTag> similars) {
		editTaglist(similarEditor, similars);
	}

	public void editStyles(List<PlexTag> styles) {
		editTaglist(styleEditor, styles);
	}

	public void editGenres(List<PlexTag> genres) {
		editTaglist(genreEditor, genres);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.add(countryEditor);
		fieldEditors.add(genreEditor);
		fieldEditors.add(moodEditor);
		fieldEditors.add(styleEditor);
		fieldEditors.add(similarEditor);
		return fieldEditors;
	}
}
