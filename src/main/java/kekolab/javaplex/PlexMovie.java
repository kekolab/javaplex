package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.StringListDeserializer;

public class PlexMovie extends PlexVideo<PlexMovieSection> {
	public static final int TYPE_ID = 1;
	public static final String TYPE_DESCRIPTION = "movie";
	private Double audienceRating;
	private String audienceRatingImage;
	private String chapterSource;
	@JsonProperty("Country")
	private List<PlexTag> countries;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	private Integer createdAtTZOffset;
	@JsonProperty("Director")
	private List<PlexTag> directors;
	@JsonProperty("Genre")
	private List<PlexTag> genres;
	private Integer hasPremiumExtras;
	private Integer hasPremiumPrimaryExtra;
	@JsonProperty("Producer")
	private List<PlexTag> producers;
	private Double rating;
	private String ratingImage;
	@JsonProperty("Rating")
	private List<PlexRating> ratings;
	@JsonProperty("Role")
	private List<PlexRole> roles;
	@JsonProperty("Similar")
	private List<PlexTag> similars;
	private String subtype;
	private String tagline;
	@JsonProperty("Writer")
	private List<PlexTag> writers;
	private UriProvider art, thumb;

	@JsonIgnore
	private TagListFieldEditor countryEditor;
	@JsonIgnore
	private TagListFieldEditor directorEditor;
	@JsonIgnore
	private TagListFieldEditor genreEditor;
	@JsonIgnore
	private TagListFieldEditor writerEditor;
	@JsonIgnore
	private TagListFieldEditor producerEditor;

	public PlexMovie() {
		art = new UriProvider(this::uri);
		countries = new ArrayList<>();
		directors = new ArrayList<>();
		genres = new ArrayList<>();
		producers = new ArrayList<>();
		ratings = new ArrayList<>();
		roles = new ArrayList<>();
		similars = new ArrayList<>();
		thumb = new UriProvider(this::uri);
		writers = new ArrayList<>();

		countryEditor = new TagListFieldEditor("country", this::getCountries);
		directorEditor = new TagListFieldEditor("director", this::getDirectors);
		genreEditor = new TagListFieldEditor("genre", this::getGenres);
		writerEditor = new TagListFieldEditor("writer", this::getWriters);
		producerEditor = new TagListFieldEditor("producer", this::getProducers);
	}

	@Override
	protected void clear() {
		super.clear();
		art.setValue(null);
		audienceRating = null;
		audienceRatingImage = null;
		chapterSource = null;
		countries.clear();
		createdAtAccuracy = null;
		createdAtTZOffset = null;
		directors.clear();
		genres.clear();
		hasPremiumExtras = null;
		hasPremiumPrimaryExtra = null;
		producers.clear();
		rating = null;
		ratingImage = null;
		ratings.clear();
		roles.clear();
		similars.clear();
		subtype = null;
		tagline = null;
		thumb.setValue(null);
		writers.clear();
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexMovie movie) {
			art.setValue(movie.art.getValue());
			audienceRating = movie.audienceRating;
			audienceRatingImage = movie.audienceRatingImage;
			chapterSource = movie.chapterSource;
			countries.clear();
			countries.addAll(movie.countries);
			createdAtAccuracy = movie.createdAtAccuracy;
			createdAtTZOffset = movie.createdAtTZOffset;
			directors.clear();
			directors.addAll(movie.directors);
			genres.clear();
			genres.addAll(movie.genres);
			hasPremiumExtras = movie.hasPremiumExtras;
			hasPremiumPrimaryExtra = movie.hasPremiumPrimaryExtra;
			producers.clear();
			producers.addAll(movie.producers);
			rating = movie.rating;
			ratingImage = movie.ratingImage;
			ratings.clear();
			ratings.addAll(movie.ratings);
			roles.clear();
			roles.addAll(movie.roles);
			similars.clear();
			similars.addAll(movie.similars);
			subtype = movie.subtype;
			tagline = movie.tagline;
			thumb.setValue(movie.thumb.getValue());
			writers.clear();
			writers.addAll(movie.writers);
		} else
			throw new ClassCastException("Cannot cast item to PlexMovie");
	}

	public Double getRating() {
		fetchDetailedIfNullOrEmpty(rating);
		return rating;
	}

	public Double getAudienceRating() {
		fetchDetailedIfNullOrEmpty(audienceRating);
		return audienceRating;
	}

	public String getTagline() {
		fetchDetailedIfNullOrEmpty(tagline);
		return tagline;
	}

	public String getAudienceRatingImage() {
		fetchDetailedIfNullOrEmpty(audienceRatingImage);
		return audienceRatingImage;
	}

	public Integer getHasPremiumExtras() {
		fetchDetailedIfNullOrEmpty(hasPremiumExtras);
		return hasPremiumExtras;
	}

	public Integer getHasPremiumPrimaryExtra() {
		fetchDetailedIfNullOrEmpty(hasPremiumPrimaryExtra);
		return hasPremiumPrimaryExtra;
	}

	public String getRatingImage() {
		fetchDetailedIfNullOrEmpty(ratingImage);
		return ratingImage;
	}

	public List<PlexTag> getGenres() {
		fetchDetailedIfNullOrEmpty(genres);
		return genres;
	}

	public List<PlexTag> getDirectors() {
		fetchDetailedIfNullOrEmpty(directors);
		return directors;
	}

	public List<PlexTag> getWriters() {
		fetchDetailedIfNullOrEmpty(writers);
		return writers;
	}

	public List<PlexTag> getProducers() {
		fetchDetailedIfNullOrEmpty(producers);
		return producers;
	}

	public List<PlexTag> getCountries() {
		fetchDetailedIfNullOrEmpty(countries);
		return countries;
	}

	public List<PlexRole> getRoles() {
		fetchDetailedIfNullOrEmpty(roles);
		return roles;
	}

	public List<PlexTag> getSimilars() {
		fetchDetailedIfNullOrEmpty(similars);
		return similars;
	}

	public void setSimilars(List<PlexTag> similars) {
		this.similars = similars;
	}

	public void setRoles(List<PlexRole> roles) {
		this.roles = roles;
	}

	public void setCountries(List<PlexTag> countries) {
		this.countries = countries;
	}

	public void setProducers(List<PlexTag> producers) {
		this.producers = producers;
	}

	public void setWriters(List<PlexTag> writers) {
		this.writers = writers;
	}

	public void setDirectors(List<PlexTag> directors) {
		this.directors = directors;
	}

	public void setGenres(List<PlexTag> genres) {
		this.genres = genres;
	}

	public void setRatingImage(String ratingImage) {
		this.ratingImage = ratingImage;
	}

	public void setHasPremiumExtras(Integer hasPremiumExtra) {
		this.hasPremiumExtras = hasPremiumExtra;
	}

	public void setAudienceRatingImage(String audienceRatingImage) {
		this.audienceRatingImage = audienceRatingImage;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public void setAudienceRating(Double audienceRating) {
		this.audienceRating = audienceRating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public void setHasPremiumPrimaryExtra(Integer hasPremiumPrimaryExtra) {
		this.hasPremiumPrimaryExtra = hasPremiumPrimaryExtra;
	}

	public String getChapterSource() {
		fetchDetailedIfNullOrEmpty(chapterSource);
		return chapterSource;
	}

	public void setChapterSource(String chapterSource) {
		this.chapterSource = chapterSource;
	}

	public List<PlexRating> getRatings() {
		fetchDetailedIfNullOrEmpty(ratings);
		return ratings;
	}

	public void setRatings(List<PlexRating> ratings) {
		this.ratings = ratings;
	}

	public String getSubtype() {
		fetchDetailedIfNullOrEmpty(subtype);
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public List<String> getCreatedAtAccuracy() {
		fetchDetailedIfNullOrEmpty(createdAtAccuracy);
		return createdAtAccuracy;
	}

	public void setCreatedAtAccuracy(List<String> createdAtAccuracy) {
		this.createdAtAccuracy = createdAtAccuracy;
	}

	public Integer getCreatedAtTZOffset() {
		fetchDetailedIfNullOrEmpty(createdAtTZOffset);
		return createdAtTZOffset;
	}

	public void setCreatedAtTZOffset(Integer createdAtTZOffset) {
		this.createdAtTZOffset = createdAtTZOffset;
	}

	@Override
	public PlexMovieSection section() {
		return (PlexMovieSection) super.section();
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

	public void editGenres(List<PlexTag> genres) {
		editTaglist(genreEditor, genres);
	}

	public void editWriters(List<PlexTag> writers) {
		editTaglist(writerEditor, writers);
	}

	public void editDirectors(List<PlexTag> directors) {
		editTaglist(directorEditor, directors);
	}

	public void editProducers(List<PlexTag> producers) {
		editTaglist(producerEditor, producers);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.add(countryEditor);
		fieldEditors.add(genreEditor);
		fieldEditors.add(writerEditor);
		fieldEditors.add(directorEditor);
		fieldEditors.add(producerEditor);
		return fieldEditors;
	}
}
