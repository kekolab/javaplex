package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeEditor;
import kekolab.javaplex.model.PlexRating;
import kekolab.javaplex.model.PlexRole;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowSection;
import kekolab.javaplex.model.PlexTag;

class Episode extends Video<PlexShowSection> implements PlexEpisode {
	private Double rating;
	private String audienceRatingImage;
	@JsonProperty("Director")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> directors;
	@JsonProperty("Role")
	@JsonDeserialize(contentAs = Role.class)
	private List<PlexRole> roles;
	@JsonProperty("Writer")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> writers;
	@JsonProperty("Producer")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> producers;
	@JsonProperty("Rating")
	@JsonDeserialize(contentAs = Rating.class)
	private List<PlexRating> ratings;
	private String chapterSource;
	private Double audienceRating;

	private UriProvider art, thumb;

	@JsonIgnore
	private Grandchild<PlexShow, PlexSeason, PlexShowSection> asGrandchild;

	public void setParentGuid(String guid) {
		asGrandchild.setParentGuid(guid);
	}

	public void setParentIndex(Integer index) {
		asGrandchild.setParentIndex(index);
	}

	public void setParentStudio(String studio) {
		asGrandchild.setParentStudio(studio);
	}

	public void setParentTitle(String title) {
		asGrandchild.setParentTitle(title);
	}

	public void setParentYear(Integer year) {
		asGrandchild.setParentYear(year);
	}

	public void setParentKey(String key) {
		asGrandchild.setParentKey(key);
	}

	public void setGrandparentGuid(String grandParentGuid) {
		asGrandchild.setGrandparentGuid(grandParentGuid);
	}

	public void setParentRatingKey(Integer ratingKey) {
		asGrandchild.setParentRatingKey(ratingKey);
	}

	public void setGrandparentTitle(String grandparentTitle) {
		asGrandchild.setGrandparentTitle(grandparentTitle);
	}

	public void setParentThumb(String thumb) {
		asGrandchild.setParentThumb(thumb);
	}

	public void setParentTheme(String theme) {
		asGrandchild.setParentTheme(theme);
	}

	public void setGrandparentYear(Integer grandparentYear) {
		asGrandchild.setGrandparentYear(grandparentYear);
	}

	public void setGrandparentArt(String art) {
		asGrandchild.setGrandparentArt(art);
	}

	public void setGrandparentKey(String key) {
		asGrandchild.setGrandparentKey(key);
	}

	public void setGrandparentRatingKey(Integer ratingKey) {
		asGrandchild.setGrandparentRatingKey(ratingKey);
	}

	public void setGrandparentTheme(String theme) {
		asGrandchild.setGrandparentTheme(theme);
	}

	public void setGrandparentThumb(String thumb) {
		asGrandchild.setGrandparentThumb(thumb);
	}

	public PlexSeason parent() {
		return asGrandchild.parent();
	}

	public PlexShow grandparent() {
		return asGrandchild.grandparent();
	}

	public String getParentGuid() {
		return asGrandchild.getParentGuid();
	}

	public Integer getParentIndex() {
		return asGrandchild.getParentIndex();
	}

	public String getParentKey() {
		return asGrandchild.getParentKey();
	}

	public String getGrandparentArt() {
		return asGrandchild.getGrandparentArt();
	}

	public URI parentKey() {
		return asGrandchild.parentKey();
	}

	public URI grandparentArt() {
		return asGrandchild.grandparentArt();
	}

	public Integer getParentRatingKey() {
		return asGrandchild.getParentRatingKey();
	}

	public String getGrandparentGuid() {
		return asGrandchild.getGrandparentGuid();
	}

	public URI parentRatingKey() {
		return asGrandchild.parentRatingKey();
	}

	public String getGrandparentKey() {
		return asGrandchild.getGrandparentKey();
	}

	public String getParentStudio() {
		return asGrandchild.getParentStudio();
	}

	public URI grandparentKey() {
		return asGrandchild.grandparentKey();
	}

	public String getParentTheme() {
		return asGrandchild.getParentTheme();
	}

	public Integer getGrandparentRatingKey() {
		return asGrandchild.getGrandparentRatingKey();
	}

	public URI parentTheme() {
		return asGrandchild.parentTheme();
	}

	public URI grandparentRatingKey() {
		return asGrandchild.grandparentRatingKey();
	}

	public String getParentThumb() {
		return asGrandchild.getParentThumb();
	}

	public String getGrandparentTheme() {
		return asGrandchild.getGrandparentTheme();
	}

	public URI parentThumb() {
		return asGrandchild.parentThumb();
	}

	public String getParentTitle() {
		return asGrandchild.getParentTitle();
	}

	public URI grandparentTheme() {
		return asGrandchild.grandparentTheme();
	}

	public Integer getParentYear() {
		return asGrandchild.getParentYear();
	}

	public String getGrandparentThumb() {
		return asGrandchild.getGrandparentThumb();
	}

	public URI grandparentThumb() {
		return asGrandchild.grandparentThumb();
	}

	public String getGrandparentTitle() {
		return asGrandchild.getGrandparentTitle();
	}

	public Integer getGrandparentYear() {
		return asGrandchild.getGrandparentYear();
	}

	public Episode() {
		art = new UriProvider(this::uri);
		directors = new ArrayList<>();
		roles = new ArrayList<>();
		writers = new ArrayList<>();
		producers = new ArrayList<>();
		ratings = new ArrayList<>();
		thumb = new UriProvider(this::uri);
		asGrandchild = new Grandchild<PlexShow, PlexSeason, PlexShowSection>() {
			@Override
			public int typeId() {
				return Episode.this.typeId();
			}

			@Override
			public PlexEpisodeEditor editor() {
				return Episode.this.editor();
			}
		};

	}

	public List<PlexTag> getWriters() {
		ensureDetailed(writers);
		return writers;
	}

	public Double getRating() {
		ensureDetailed(rating);
		return rating;
	}

	public Double getAudienceRating() {
		ensureDetailed(audienceRating);
		return audienceRating;
	}

	public String getAudienceRatingImage() {
		ensureDetailed(audienceRatingImage);
		return audienceRatingImage;
	}

	public List<PlexTag> getDirectors() {
		ensureDetailed(directors);
		return directors;
	}

	public List<PlexRole> getRoles() {
		ensureDetailed(roles);
		return roles;
	}

	public String getChapterSource() {
		ensureDetailed(chapterSource);
		return chapterSource;
	}

	public void setChapterSource(String chapterSource) {
		this.chapterSource = chapterSource;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public void setAudienceRating(Double audienceRating) {
		this.audienceRating = audienceRating;
	}

	public void setAudienceRatingImage(String audienceRatingImage) {
		this.audienceRatingImage = audienceRatingImage;
	}

	public void setDirectors(List<PlexTag> directors) {
		this.directors = directors;
	}

	public void setRoles(List<PlexRole> roles) {
		this.roles = roles;
	}

	public void setWriters(List<PlexTag> writers) {
		this.writers = writers;
	}

	public List<PlexTag> getProducers() {
		ensureDetailed(producers);
		return producers;
	}

	public List<PlexRating> getRatings() {
		ensureDetailed(ratings);
		return ratings;
	}

	public void setRatings(List<PlexRating> ratings) {
		this.ratings = ratings;
	}

	public void setProducers(List<PlexTag> producers) {
		this.producers = producers;
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

	public Boolean getWritersLocked() {
		return getFieldLocked("writer");
	}

	public Boolean getDirectorsLocked() {
		return getFieldLocked("director");
	}

	@Override
	public PlexEpisodeEditor editor() {
		return new EpisodeEditor(this);
	}

	@Override
	public int typeId() {
		return PlexEpisode.super.typeId();
	}
}
