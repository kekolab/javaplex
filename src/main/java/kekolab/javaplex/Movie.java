package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieSection;
import kekolab.javaplex.model.PlexRating;
import kekolab.javaplex.model.PlexRole;
import kekolab.javaplex.model.PlexTag;

class Movie extends Video<PlexMovieSection> implements PlexMovie {
	private Double audienceRating;
	private String audienceRatingImage;
	private String chapterSource;
	@JsonProperty("Country")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> countries;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	private Integer createdAtTZOffset;
	@JsonProperty("Director")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> directors;
	@JsonProperty("Genre")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> genres;
	private Integer hasPremiumExtras;
	private Integer hasPremiumPrimaryExtra;
	@JsonProperty("Producer")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> producers;
	private Double rating;
	private String ratingImage;
	@JsonProperty("Rating")
	@JsonDeserialize(contentAs = Rating.class)
	private List<PlexRating> ratings;
	@JsonProperty("Role")
	@JsonDeserialize(contentAs = Role.class)
	private List<PlexRole> roles;
	@JsonProperty("Similar")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> similars;
	private String subtype;
	private String tagline;
	@JsonProperty("Writer")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> writers;
	private UriProvider art, thumb;

	@JsonIgnore
	private FieldEditor<List<PlexTag>> countryEditor;
	@JsonIgnore
	private FieldEditor<Boolean> countryLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> directorEditor;
	@JsonIgnore
	private FieldEditor<Boolean> directorLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> genreEditor;
	@JsonIgnore
	private FieldEditor<Boolean> genreLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> writerEditor;
	@JsonIgnore
	private FieldEditor<Boolean> writerLockEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> producerEditor;
	@JsonIgnore
	private FieldEditor<Boolean> producerLockEditor;

	public Movie() {
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
		countryLockEditor = new BooleanFieldEditor("country.locked", this::isCountriesLocked);
		directorEditor = new TagListFieldEditor("director", this::getDirectors);
		directorLockEditor = new BooleanFieldEditor("director.locked", this::isDirectorsLocked);
		genreEditor = new TagListFieldEditor("genre", this::getGenres);
		genreLockEditor = new BooleanFieldEditor("genre.locked", this::isGenresLocked);
		writerEditor = new TagListFieldEditor("writer", this::getWriters);
		writerLockEditor = new BooleanFieldEditor("writer.locked", this::isWritersLocked);
		producerEditor = new TagListFieldEditor("producer", this::getProducers);
		producerLockEditor = new BooleanFieldEditor("country.locked", this::isProducersLocked);

	}

	public Double getRating() {
		ensureDetailed(rating);
		return rating;
	}

	public Double getAudienceRating() {
		ensureDetailed(audienceRating);
		return audienceRating;
	}

	public String getTagline() {
		ensureDetailed(tagline);
		return tagline;
	}

	public String getAudienceRatingImage() {
		ensureDetailed(audienceRatingImage);
		return audienceRatingImage;
	}

	public Integer getHasPremiumExtras() {
		ensureDetailed(hasPremiumExtras);
		return hasPremiumExtras;
	}

	public Integer getHasPremiumPrimaryExtra() {
		ensureDetailed(hasPremiumPrimaryExtra);
		return hasPremiumPrimaryExtra;
	}

	public String getRatingImage() {
		ensureDetailed(ratingImage);
		return ratingImage;
	}

	public List<PlexTag> getGenres() {
		ensureDetailed(genres);
		return genres;
	}

	public List<PlexTag> getDirectors() {
		ensureDetailed(directors);
		return directors;
	}

	public List<PlexTag> getWriters() {
		ensureDetailed(writers);
		return writers;
	}

	public List<PlexTag> getProducers() {
		ensureDetailed(producers);
		return producers;
	}

	public List<PlexTag> getCountries() {
		ensureDetailed(countries);
		return countries;
	}

	public List<PlexRole> getRoles() {
		ensureDetailed(roles);
		return roles;
	}

	public List<PlexTag> getSimilars() {
		ensureDetailed(similars);
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
		ensureDetailed(chapterSource);
		return chapterSource;
	}

	public void setChapterSource(String chapterSource) {
		this.chapterSource = chapterSource;
	}

	public List<PlexRating> getRatings() {
		ensureDetailed(ratings);
		return ratings;
	}

	public void setRatings(List<PlexRating> ratings) {
		this.ratings = ratings;
	}

	public String getSubtype() {
		ensureDetailed(subtype);
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public List<String> getCreatedAtAccuracy() {
		ensureDetailed(createdAtAccuracy);
		return createdAtAccuracy;
	}

	public void setCreatedAtAccuracy(List<String> createdAtAccuracy) {
		this.createdAtAccuracy = createdAtAccuracy;
	}

	public Integer getCreatedAtTZOffset() {
		ensureDetailed(createdAtTZOffset);
		return createdAtTZOffset;
	}

	public void setCreatedAtTZOffset(Integer createdAtTZOffset) {
		this.createdAtTZOffset = createdAtTZOffset;
	}

	@Override
	public MovieSection section() {
		return (MovieSection) super.section();
	}

	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	public URI art() {
		ensureDetailed(art.uri());
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
		ensureDetailed(thumb.uri());
		return thumb.uri();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	public boolean isCountriesLocked() {
		return isLocked("country");
	}

	public boolean isDirectorsLocked() {
		return isLocked("director");
	}

	public boolean isGenresLocked() {
		return isLocked("genre");
	}

	public boolean isWritersLocked() {
		return isLocked("writer");
	}

	public boolean isProducersLocked() {
		return isLocked("producer");
	}

	public void editCountries(List<PlexTag> countries) {
		editTaglist(countryEditor, countries);
	}

	public void editCountriesLock(boolean locked) {
		countryLockEditor.setValue(locked);
	}

	public void editGenres(List<PlexTag> genres) {
		editTaglist(genreEditor, genres);
	}

	public void editGenresLock(boolean locked) {
		genreLockEditor.setValue(locked);
	}

	public void editWriters(List<PlexTag> writers) {
		editTaglist(writerEditor, writers);
	}

	public void editWritersLock(boolean locked) {
		writerLockEditor.setValue(locked);
	}

	public void editDirectors(List<PlexTag> directors) {
		editTaglist(directorEditor, directors);
	}

	public void editDirectorsLock(boolean locked) {
		directorLockEditor.setValue(locked);
	}

	public void editProducers(List<PlexTag> producers) {
		editTaglist(producerEditor, producers);
	}

	public void editProducersLock(boolean locked) {
		producerLockEditor.setValue(locked);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.addAll(Arrays.asList(countryEditor, countryLockEditor, genreEditor, genreLockEditor, writerEditor,
				writerLockEditor, directorEditor, directorLockEditor, producerEditor, producerLockEditor));
		return fieldEditors;
	}

	@Override
	public int typeId() {
		return PlexMovie.super.typeId();
	}
}
