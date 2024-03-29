package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistEditor;
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

	public Artist() {
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
		return new MetadataContainer<PlexAlbum, Directory>(key(), getServer()).getMetadata();
	}

	public List<PlexTrack> grandchildren() {
		URI uri;
		try {
			uri = new URIBuilder(ratingKey()).appendPath("allLeaves").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexTrack, Directory>(uri, getServer()).getMetadata();
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

	@Override
	public int typeId() {
		return PlexArtist.super.typeId();
	}

	@Override
	public PlexArtistEditor editor() {
		return new ArtistEditor(this);
	}


}
