package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.filtering.PlexFilterableBoolean;
import kekolab.javaplex.filtering.PlexFilterableDate;
import kekolab.javaplex.filtering.PlexFilterableInteger;
import kekolab.javaplex.filtering.PlexFilterableString;
import kekolab.javaplex.filtering.PlexFilterableTag;

public class PlexArtist extends PlexMediatag<PlexMusicSection> implements PlexGrandparent<PlexMusicSection, PlexAlbum, PlexTrack> {
	public static final int TYPE_ID = 8;
    public static final String TYPE_DESCRIPTION = "artist";

	public static final PlexFilterableString TITLE = () -> "artist.title";
    public static final PlexFilterableInteger USER_RATING = () -> "artist.userRating";
    public static final PlexFilterableTag GENRE = () -> "artist.genre";
    public static final PlexFilterableTag COLLECTION = () -> "artist.collection";
    public static final PlexFilterableTag COUNTRY = () -> "artist.country";
    public static final PlexFilterableTag MOOD = () -> "artist.mood";
    public static final PlexFilterableTag STYLE = () -> "artist.style";
    public static final PlexFilterableDate DATE_ADDED = () -> "artist.addedAt";
    public static final PlexFilterableDate LAST_PLAYED = () -> "artist.lastViewedAt";
    public static final PlexFilterableBoolean UNMATCHED = () -> "artist.unmatched";

	private Integer albumSort;
	private Integer childCount;
	@JsonProperty("Country")
	@JsonDeserialize(contentAs = PlexTag.class)
	private List<PlexTag> countries;
	@JsonProperty("Genre")
	@JsonDeserialize(contentAs = PlexTag.class)
	private List<PlexTag> genres;
	@JsonProperty("Location")
	@JsonDeserialize(contentAs = PlexTag.class)
	private List<PlexTag> locations;
	@JsonProperty("Mood")
	@JsonDeserialize(contentAs = PlexTag.class)
	private List<PlexTag> moods;
	@JsonProperty("Similar")
	@JsonDeserialize(contentAs = PlexTag.class)
	private List<PlexTag> similars;
	@JsonProperty("Style")
	@JsonDeserialize(contentAs = PlexTag.class)
	private List<PlexTag> styles;
	private UriProvider art, thumb;

	public PlexArtist() {
		art = new UriProvider(this::uri);
		countries = new ArrayList<>();
		genres = new ArrayList<>();
		locations = new ArrayList<>();
		moods = new ArrayList<>();
		similars = new ArrayList<>();
		styles = new ArrayList<>();
		thumb = new UriProvider(this::uri);
	}

	@Override
	void update(PlexMetadata source) {
		super.update(source);
		PlexArtist a = (PlexArtist) source;
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

	
	public List<PlexAlbum> children() {
		return new PlexGeneralPurposeMediaContainer<PlexAlbum, PlexDirectory>(key(), getServer()).getMetadata();
	}

	
	public List<PlexTrack> grandchildren() {
		URI uri;
		try {
			uri = new URIBuilder(ratingKey()).appendPath("allLeaves").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new PlexGeneralPurposeMediaContainer<PlexTrack, PlexDirectory>(uri, getServer()).getMetadata();
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

	
	public Boolean getCountriesLocked() {
		return getFieldLocked("country");
	}

	
	public Boolean getGenresLocked() {
		return getFieldLocked("genre");
	}

	
	public Boolean getSimilarsLocked() {
		return getFieldLocked("similar");
	}

	
	public Boolean getMoodsLocked() {
		return getFieldLocked("mood");
	}

	
	public Boolean getStylesLocked() {
		return getFieldLocked("style");
	}

	
	public int typeId() {
		return TYPE_ID;
	}

	public void editCountries(List<String> value, Optional<Boolean> lock) {
		editList("country", value, getCountries());
		if (lock.isPresent())
			editField("country.locked", lock.get() ? "1" : "0");
	}

	public void editGenres(List<String> value, Optional<Boolean> lock) {
		editList("genre", value, getGenres());
		if (lock.isPresent())
			editField("genre.locked", lock.get() ? "1" : "0");
	}

	public void editMoods(List<String> value, Optional<Boolean> lock) {
		editList("mood", value, getMoods());
		if (lock.isPresent())
			editField("mood.locked", lock.get() ? "1" : "0");
	}

	public void editSimilars(List<String> value, Optional<Boolean> lock) {
		editList("similar", value, getSimilars());
		if (lock.isPresent())
			editField("similar.locked", lock.get() ? "1" : "0");
	}

	public void editStyles(List<String> value, Optional<Boolean> lock) {
		editList("style", value, getStyles());
		if (lock.isPresent())
			editField("style.locked", lock.get() ? "1" : "0");
	}
	

}
