package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.filtering.PlexFilterableBoolean;
import kekolab.javaplex.filtering.PlexFilterableDate;
import kekolab.javaplex.filtering.PlexFilterableInteger;
import kekolab.javaplex.filtering.PlexFilterableString;
import kekolab.javaplex.filtering.PlexFilterableTag;

public class PlexEpisode extends PlexVideo<PlexShowSection> implements PlexGrandchild<PlexShowSection, PlexSeason, PlexShow> {
	public static final int TYPE_ID = 4;
    public static final String TYPE_DESCRIPTION = "episode";

	public static final PlexFilterableString TITLE = () -> "episode.title";
    public static final PlexFilterableDate DATE_ADDED = () -> "episode.addedAt";
    public static final PlexFilterableDate AIR_DATE = () -> "episode.originallyAvailableAt";
    public static final PlexFilterableInteger YEAR = () -> "episode.year";
    public static final PlexFilterableInteger RATING = () -> "episode.userRating";
    public static final PlexFilterableInteger PLAYS = () -> "episode.viewCount";
    public static final PlexFilterableDate LAST_PLAYED = () -> "episode.lastViewedAt";
    public static final PlexFilterableBoolean UNWATCHED = () -> "episode.unwatched";
    public static final PlexFilterableBoolean IN_PROGRESS = () -> "episode.inProgress";
    public static final PlexFilterableBoolean DUPLICATED = () -> "episode.duplicate";
    public static final PlexFilterableBoolean HDR = () -> "episode.hdr";
    public static final PlexFilterableTag RESOLUTION = () -> "episode.resolution";
    public static final PlexFilterableInteger FILE_SIZE = () -> "episode.mediaSize";
    public static final PlexFilterableInteger BITRATE = () -> "episode.mediaBitrate";
    public static final PlexFilterableTag SUBTITLE_LANGUAGE = () -> "episode.subtitleLanguage";
    public static final PlexFilterableTag AUDIO_LANGUAGE = () -> "episode.audioLanguage";
    public static final PlexFilterableBoolean TRASHED = () -> "episode.trash";
    public static final PlexFilterableBoolean UNMATCHED = () -> "episode.unmatched";

	private Double rating;
	private String audienceRatingImage;
	@JsonProperty("Director")
	@JsonDeserialize(contentAs = PlexTag.class)
	private List<PlexTag> directors;
	@JsonProperty("Role")
	@JsonDeserialize(contentAs = PlexRole.class)
	private List<PlexRole> roles;
	@JsonProperty("Writer")
	@JsonDeserialize(contentAs = PlexTag.class)
	private List<PlexTag> writers;
	@JsonProperty("Producer")
	@JsonDeserialize(contentAs = PlexTag.class)
	private List<PlexTag> producers;
	@JsonProperty("Rating")
	@JsonDeserialize(contentAs = PlexRating.class)
	private List<PlexRating> ratings;
	private String chapterSource;
	private Double audienceRating;

	private UriProvider art, thumb;

	@JsonIgnore
	private Grandchild<PlexShowSection, PlexSeason, PlexShow> asGrandchild;

	@Override
	void update(PlexMetadata source) {
		super.update(source);
		PlexEpisode episode = (PlexEpisode) source;
		setRating(episode.getRating());
		setDirectors(episode.getDirectors());
		setRoles(episode.getRoles());
		setWriters(episode.getWriters());
		setProducers(episode.getProducers());
		setRatings(episode.getRatings());
		setChapterSource(episode.getChapterSource());
		setAudienceRating(episode.getAudienceRating());
		setArt(episode.getArt());
		setThumb(episode.getThumb());
		asGrandchild.update(episode);
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

	public PlexEpisode() {
		art = new UriProvider(this::uri);
		directors = new ArrayList<>();
		roles = new ArrayList<>();
		writers = new ArrayList<>();
		producers = new ArrayList<>();
		ratings = new ArrayList<>();
		thumb = new UriProvider(this::uri);
		asGrandchild = new Grandchild<>() {
			@Override
			public int typeId() {
				return TYPE_ID;
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
	public int typeId() {
		return TYPE_ID;
	}

	public void editWriters(List<String> value, Optional<Boolean> lock) {
		editList("writer", value, getWriters());
		if (lock.isPresent())
			editField("writer.locked", lock.get() ? "1" : "0");
	}

	public void editDirectors(List<String> value, Optional<Boolean> lock) {
		editList("director", value, getDirectors());
		if (lock.isPresent())
			editField("director.locked", lock.get() ? "1" : "0");
	}
}
