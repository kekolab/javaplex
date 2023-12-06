package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlexEpisode extends PlexVideo<PlexShowSection> {
	public static final int TYPE_ID = 4;
	public static final String TYPE_DESCRIPTION = "episode";
	private Double rating;
	private String audienceRatingImage;
	@JsonProperty("Director")
	private List<PlexTag> directors;
	@JsonProperty("Role")
	private List<PlexRole> roles;
	@JsonProperty("Writer")
	private List<PlexTag> writers;
	@JsonProperty("Producer")
	private List<PlexTag> producers;
	@JsonProperty("Rating")
	private List<PlexRating> ratings;
	private String chapterSource;
	private Double audienceRating;
	@JsonIgnore
	private GrandchildDelegate<PlexSeason, PlexShow> grandchild;
	private UriProvider art, thumb;

	@JsonIgnore
	private FieldEditor<List<PlexTag>> writerEditor;
	@JsonIgnore
	private FieldEditor<List<PlexTag>> directorEditor;

	public PlexEpisode() {
		art = new UriProvider(this::uri);
		directors = new ArrayList<>();
		roles = new ArrayList<>();
		writers = new ArrayList<>();
		producers = new ArrayList<>();
		ratings = new ArrayList<>();
		thumb = new UriProvider(this::uri);
		grandchild = new GrandchildDelegate<>(this::server, this::getClient, this::getToken);

		writerEditor = new TagListFieldEditor("writer", this::getWriters);
		directorEditor = new TagListFieldEditor("director", this::getDirectors);
	}

	@Override
	protected void clear() {
		super.clear();
		art.setValue(null);
		audienceRating = null;
		audienceRatingImage = null;
		chapterSource = null;
		directors.clear();
		producers.clear();
		rating = null;
		ratings.clear();
		roles.clear();
		thumb.setValue(null);
		writers.clear();
		grandchild.clear();
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexEpisode episode) {
			art.setValue(episode.art.getValue());
			audienceRating = episode.audienceRating;
			audienceRatingImage = episode.audienceRatingImage;
			chapterSource = episode.chapterSource;
			directors.clear();
			directors.addAll(episode.directors);
			grandchild.update(episode.grandchild);
			producers.clear();
			producers.addAll(episode.producers);
			rating = episode.rating;
			ratings.clear();
			ratings.addAll(episode.ratings);
			roles.clear();
			roles.addAll(episode.roles);
			thumb.setValue(episode.thumb.getValue());
			writers.clear();
			writers.addAll(episode.writers);
		} else
			throw new ClassCastException("Cannot cast item to PlexEpisode");
	}

	@Override
	public PlexShowSection section() {
		return (PlexShowSection) super.section();
	}

	public List<PlexTag> getWriters() {
		fetchDetailedIfNullOrEmpty(writers);
		return writers;
	}

	public Double getRating() {
		fetchDetailedIfNullOrEmpty(rating);
		return rating;
	}

	public Double getAudienceRating() {
		fetchDetailedIfNullOrEmpty(audienceRating);
		return audienceRating;
	}

	public String getAudienceRatingImage() {
		fetchDetailedIfNullOrEmpty(audienceRatingImage);
		return audienceRatingImage;
	}

	public List<PlexTag> getDirectors() {
		fetchDetailedIfNullOrEmpty(directors);
		return directors;
	}

	public List<PlexRole> getRoles() {
		fetchDetailedIfNullOrEmpty(roles);
		return roles;
	}

	public String getChapterSource() {
		fetchDetailedIfNullOrEmpty(chapterSource);
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
		fetchDetailedIfNullOrEmpty(producers);
		return producers;
	}

	public List<PlexRating> getRatings() {
		fetchDetailedIfNullOrEmpty(ratings);
		return ratings;
	}

	public void setRatings(List<PlexRating> ratings) {
		this.ratings = ratings;
	}

	public void setProducers(List<PlexTag> producers) {
		this.producers = producers;
	}

	public PlexSeason parent() {
		fetchDetailedIfNullOrEmpty(grandchild.parent());
		return (PlexSeason) grandchild.parent();
	}

	public String getParentGuid() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentGuid());
		return grandchild.getParentGuid();
	}

	public Integer getParentIndex() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentIndex());
		return grandchild.getParentIndex();
	}

	public String getParentKey() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentKey());
		return grandchild.getParentKey();
	}

	public URI parentKey() {
		fetchDetailedIfNullOrEmpty(grandchild.parentKey());
		return grandchild.parentKey();
	}

	public Integer getParentRatingKey() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentRatingKey());
		return grandchild.getParentRatingKey();
	}

	public URI parentRatingKey() {
		fetchDetailedIfNullOrEmpty(grandchild.parentRatingKey());
		return grandchild.parentRatingKey();
	}

	public String getParentStudio() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentStudio());
		return grandchild.getParentStudio();
	}

	public String getParentTheme() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentTheme());
		return grandchild.getParentTheme();
	}

	public URI parentTheme() {
		fetchDetailedIfNullOrEmpty(grandchild.parentTheme());
		return grandchild.parentTheme();
	}

	public String getParentThumb() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentThumb());
		return grandchild.getParentThumb();
	}

	public URI parentThumb() {
		fetchDetailedIfNullOrEmpty(grandchild.parentThumb());
		return grandchild.parentThumb();
	}

	public String getParentTitle() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentTitle());
		return grandchild.getParentTitle();
	}

	public Integer getParentYear() {
		fetchDetailedIfNullOrEmpty(grandchild.getParentYear());
		return grandchild.getParentYear();
	}

	public PlexShow grandparent() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparent());
		return (PlexShow) grandchild.grandparent();
	}

	public String getGrandparentArt() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentArt());
		return grandchild.getGrandparentArt();
	}

	public URI grandparentArt() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentArt());
		return grandchild.grandparentArt();
	}

	public String getGrandparentGuid() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentGuid());
		return grandchild.getGrandparentGuid();
	}

	public String getGrandparentKey() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentKey());
		return grandchild.getGrandparentKey();
	}

	public URI grandparentKey() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentKey());
		return grandchild.grandparentKey();
	}

	public Integer getGrandparentRatingKey() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentRatingKey());
		return grandchild.getGrandparentRatingKey();
	}

	public URI grandparentRatingKey() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentRatingKey());
		return grandchild.grandparentRatingKey();
	}

	public String getGrandparentTheme() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentTheme());
		return grandchild.getGrandparentTheme();
	}

	public URI grandparentTheme() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentTheme());
		return grandchild.grandparentTheme();
	}

	public String getGrandparentThumb() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentThumb());
		return grandchild.getGrandparentThumb();
	}

	public URI grandparentThumb() {
		fetchDetailedIfNullOrEmpty(grandchild.grandparentThumb());
		return grandchild.grandparentThumb();
	}

	public String getGrandparentTitle() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentTitle());
		return grandchild.getGrandparentTitle();
	}

	public Integer getGrandparentYear() {
		fetchDetailedIfNullOrEmpty(grandchild.getGrandparentYear());
		return grandchild.getGrandparentYear();
	}

	public void setGrandparentArt(String arg) {
		grandchild.setGrandparentArt(arg);
	}

	public void setGrandparentGuid(String arg) {
		grandchild.setGrandparentGuid(arg);
	}

	public void setGrandparentKey(String arg) {
		grandchild.setGrandparentKey(arg);
	}

	public void setGrandparentRatingKey(Integer arg) {
		grandchild.setGrandparentRatingKey(arg);
	}

	public void setGrandparentTheme(String arg) {
		grandchild.setGrandparentTheme(arg);
	}

	public void setGrandparentThumb(String arg) {
		grandchild.setGrandparentThumb(arg);
	}

	public void setGrandparentTitle(String arg) {
		grandchild.setGrandparentTitle(arg);
	}

	public void setGrandparentYear(Integer arg) {
		grandchild.setGrandparentYear(arg);
	}

	public void setParentGuid(String arg) {
		grandchild.setParentGuid(arg);
	}

	public void setParentIndex(Integer arg) {
		grandchild.setParentIndex(arg);
	}

	public void setParentKey(String arg) {
		grandchild.setParentKey(arg);
	}

	public void setParentRatingKey(Integer arg) {
		grandchild.setParentRatingKey(arg);
	}

	public void setParentStudio(String arg) {
		grandchild.setParentStudio(arg);
	}

	public void setParentTheme(String arg) {
		grandchild.setParentTheme(arg);
	}

	public void setParentThumb(String arg) {
		grandchild.setParentThumb(arg);
	}

	public void setParentTitle(String arg) {
		grandchild.setParentTitle(arg);
	}

	public void setParentYear(Integer arg) {
		grandchild.setParentYear(arg);
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

	public void editWriters(List<PlexTag> writers) {
		editTaglist(writerEditor, writers);
	}

	public void editDirectors(List<PlexTag> directors) {
		editTaglist(directorEditor, directors);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.add(directorEditor);
		fieldEditors.add(writerEditor);
		return fieldEditors;
	}
}
