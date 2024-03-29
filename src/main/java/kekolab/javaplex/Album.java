package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexAlbumEditor;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTag;
import kekolab.javaplex.model.PlexTrack;

class Album extends Child<PlexArtist, PlexMusicSection> implements PlexAlbum {
	@JsonProperty("Director")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> directors;
	@JsonProperty("Format")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> formats;
	@JsonProperty("Genre")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> genres;
	private Integer leafCount;
	private Integer loudnessAnalysisVersion;
	@JsonProperty("Mood")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> moods;
	private Date originallyAvailableAt;
	private String studio;
	@JsonProperty("Subformat")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> subformats;
	@JsonProperty("Style")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> styles;
	private Double rating;
	private Integer viewedLeafCount;
	private Integer year;
	private UriProvider art, thumb;

	public Album() {
		art = new UriProvider(this::uri);
		directors = new ArrayList<>();
		formats = new ArrayList<>();
		genres = new ArrayList<>();
		moods = new ArrayList<>();
		subformats = new ArrayList<>();
		styles = new ArrayList<>();
		thumb = new UriProvider(this::uri);
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		Album a = (Album) source;
		setDirectors(a.getDirectors());
		setFormats(a.getFormats());
		setGenres(a.getGenres());
		setLeafCount(a.getLeafCount());
		setLoudnessAnalysisVersion(a.getLoudnessAnalysisVersion());
		setMoods(a.getMoods());
		setOriginallyAvailableAt(a.getOriginallyAvailableAt());
		setStudio(a.getStudio());
		setSubformats(a.getSubformats());
		setStyles(a.getStyles());
		setRating(a.getRating());
		setViewedLeafCount(a.getViewedLeafCount());
		setYear(a.getYear());
		setArt(a.getArt());
		setThumb(a.getThumb());
	}

	public Double getRating() {
		ensureDetailed(rating);
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public List<PlexTag> getStyles() {
		ensureDetailed(styles);
		return styles;
	}

	public void setStyles(List<PlexTag> styles) {
		this.styles = styles;
	}

	public List<PlexTag> getFormats() {
		ensureDetailed(formats);
		return formats;
	}

	public void setFormats(List<PlexTag> formats) {
		this.formats = formats;
	}

	public Integer getLoudnessAnalysisVersion() {
		ensureDetailed(loudnessAnalysisVersion);
		return loudnessAnalysisVersion;
	}

	public void setLoudnessAnalysisVersion(Integer loudnessAnalysisVersion) {
		this.loudnessAnalysisVersion = loudnessAnalysisVersion;
	}

	public List<PlexTag> getSubformats() {
		ensureDetailed(subformats);
		return subformats;
	}

	public void setSubformats(List<PlexTag> subformats) {
		this.subformats = subformats;
	}

	public List<PlexTag> getDirectors() {
		ensureDetailed(directors);
		return directors;
	}

	public void setDirectors(List<PlexTag> directors) {
		this.directors = directors;
	}

	public Integer getLeafCount() {
		ensureDetailed(leafCount);
		return leafCount;
	}

	public void setLeafCount(Integer leafCount) {
		this.leafCount = leafCount;
	}

	public List<PlexTag> getMoods() {
		ensureDetailed(moods);
		return moods;
	}

	public void setMoods(List<PlexTag> moods) {
		this.moods = moods;
	}

	public String getStudio() {
		ensureDetailed(studio);
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public Integer getViewedLeafCount() {
		ensureDetailed(viewedLeafCount);
		return viewedLeafCount;
	}

	public void setViewedLeafCount(Integer viewedLeafCount) {
		this.viewedLeafCount = viewedLeafCount;
	}

	public List<PlexTag> getGenres() {
		ensureDetailed(genres);
		return genres;
	}

	public void setGenres(List<PlexTag> genres) {
		this.genres = genres;
	}

	public Date getOriginallyAvailableAt() {
		ensureDetailed(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	public Integer getYear() {
		ensureDetailed(year);
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<PlexTrack> children() {
		return new MetadataContainer<PlexTrack, Directory>(key(), getServer()).getMetadata();
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

	public Boolean getGenresLocked() {
		return getFieldLocked("genre");
	}

	public Boolean getMoodsLocked() {
		return getFieldLocked("mood");
	}

	public Boolean getStylesLocked() {
		return getFieldLocked("style");
	}

	@Override
	public int typeId() {
		return PlexAlbum.super.typeId();
	}

	@Override
	public PlexAlbumEditor editor() {
		return new AlbumEditor(this);
	}
}
