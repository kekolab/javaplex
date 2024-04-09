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

public class Episode extends Video implements PlexEpisode {
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
	private Grandchild asGrandchild;

	@Override
	public PlexShowSection section() {
		return (PlexShowSection) super.section();
	}

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

	@Override
	public PlexSeason parent() {
		return (PlexSeason) asGrandchild.parent();
	}

	@Override
	public PlexShow grandparent() {
		return (PlexShow) asGrandchild.grandparent();
	}

	@Override
	public String getParentGuid() {
		return asGrandchild.getParentGuid();
	}

	@Override
	public Integer getParentIndex() {
		return asGrandchild.getParentIndex();
	}

	@Override
	public String getParentKey() {
		return asGrandchild.getParentKey();
	}

	@Override
	public String getGrandparentArt() {
		return asGrandchild.getGrandparentArt();
	}

	@Override
	public URI parentKey() {
		return asGrandchild.parentKey();
	}

	@Override
	public URI grandparentArt() {
		return asGrandchild.grandparentArt();
	}

	@Override
	public Integer getParentRatingKey() {
		return asGrandchild.getParentRatingKey();
	}

	@Override
	public String getGrandparentGuid() {
		return asGrandchild.getGrandparentGuid();
	}

	@Override
	public URI parentRatingKey() {
		return asGrandchild.parentRatingKey();
	}

	@Override
	public String getGrandparentKey() {
		return asGrandchild.getGrandparentKey();
	}

	@Override
	public String getParentStudio() {
		return asGrandchild.getParentStudio();
	}

	@Override
	public URI grandparentKey() {
		return asGrandchild.grandparentKey();
	}

	@Override
	public String getParentTheme() {
		return asGrandchild.getParentTheme();
	}

	@Override
	public Integer getGrandparentRatingKey() {
		return asGrandchild.getGrandparentRatingKey();
	}

	@Override
	public URI parentTheme() {
		return asGrandchild.parentTheme();
	}

	@Override
	public URI grandparentRatingKey() {
		return asGrandchild.grandparentRatingKey();
	}

	@Override
	public String getParentThumb() {
		return asGrandchild.getParentThumb();
	}

	@Override
	public String getGrandparentTheme() {
		return asGrandchild.getGrandparentTheme();
	}

	@Override
	public URI parentThumb() {
		return asGrandchild.parentThumb();
	}

	@Override
	public String getParentTitle() {
		return asGrandchild.getParentTitle();
	}

	@Override
	public URI grandparentTheme() {
		return asGrandchild.grandparentTheme();
	}

	@Override
	public Integer getParentYear() {
		return asGrandchild.getParentYear();
	}

	@Override
	public String getGrandparentThumb() {
		return asGrandchild.getGrandparentThumb();
	}

	@Override
	public URI grandparentThumb() {
		return asGrandchild.grandparentThumb();
	}

	@Override
	public String getGrandparentTitle() {
		return asGrandchild.getGrandparentTitle();
	}

	@Override
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
		asGrandchild = new Grandchild() {
			@Override
			public int typeId() {
				return TYPE_ID;
			}
		};

	}

	@Override
	public List<PlexTag> getWriters() {
		ensureDetailed(writers);
		return writers;
	}

	@Override
	public Double getRating() {
		ensureDetailed(rating);
		return rating;
	}

	@Override
	public Double getAudienceRating() {
		ensureDetailed(audienceRating);
		return audienceRating;
	}

	@Override
	public String getAudienceRatingImage() {
		ensureDetailed(audienceRatingImage);
		return audienceRatingImage;
	}

	@Override
	public List<PlexTag> getDirectors() {
		ensureDetailed(directors);
		return directors;
	}

	@Override
	public List<PlexRole> getRoles() {
		ensureDetailed(roles);
		return roles;
	}

	@Override
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

	@Override
	public List<PlexTag> getProducers() {
		ensureDetailed(producers);
		return producers;
	}

	@Override
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

	@Override
	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	@Override
	public URI art() {
		ensureDetailed(art.uri());
		return art.uri();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	@Override
	public String getThumb() {
		ensureDetailed(thumb.getValue());
		return (String) thumb.getValue();
	}

	@Override
	public URI thumb() {
		ensureDetailed(thumb.uri());
		return thumb.uri();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	@Override
	public Boolean getWritersLocked() {
		return getFieldLocked("writer");
	}

	@Override
	public Boolean getDirectorsLocked() {
		return getFieldLocked("director");
	}

	@Override
	public PlexEpisodeEditor editor() {
		return new EpisodeEditor(this);
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}
}
