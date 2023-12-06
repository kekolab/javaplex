package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlexShow extends PlexMediatag<PlexShowSection> {
	public static final int TYPE_ID = 2;
	public static final String TYPE_DESCRIPTION = "show";
	private Double audienceRating;
	private String audienceRatingImage;
	private Integer childCount;
	private String contentRating;
	@JsonProperty("Country")
	private List<PlexTag> countries;
	private Long duration;
	@JsonProperty("Genre")
	private List<PlexTag> genres;
	private Integer leafCount;
	@JsonProperty("Location")
	private List<PlexLocation> locations;
	private Date originallyAvailableAt;
	private String originalTitle;
	private Double rating;
	@JsonProperty("Rating")
	private List<PlexRating> ratings;
	@JsonProperty("Role")
	private List<PlexRole> roles;
	@JsonProperty("Similar")
	private List<PlexTag> similars;
	private String studio;
	private String tagline;
	private Integer viewedLeafCount;
	private Integer year;
	private UriProvider art;
	private UriProvider banner;
	private UriProvider theme;
	private UriProvider thumb;

	@JsonIgnore
	private FieldEditor<List<PlexTag>> genreEditor;

	public PlexShow() {
		art = new UriProvider(this::uri);
		banner = new UriProvider(this::uri);
		countries = new ArrayList<>();
		genres = new ArrayList<>();
		locations = new ArrayList<>();
		ratings = new ArrayList<>();
		roles = new ArrayList<>();
		similars = new ArrayList<>();
		theme = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);

		genreEditor = new TagListFieldEditor("genre", this::getGenres);
	}

	@Override
	protected void clear() {
		super.clear();
		art.setValue(null);
		audienceRating = null;
		audienceRatingImage = null;
		banner.setValue(null);
		childCount = null;
		contentRating = null;
		countries.clear();
		duration = null;
		genres.clear();
		leafCount = null;
		locations.clear();
		originallyAvailableAt = null;
		originalTitle = null;
		rating = null;
		ratings.clear();
		roles.clear();
		similars.clear();
		studio = null;
		tagline = null;
		theme.setValue(null);
		thumb.setValue(null);
		viewedLeafCount = null;
		year = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexShow show) {
			art.setValue(show.art.getValue());
			audienceRating = show.audienceRating;
			audienceRatingImage = show.audienceRatingImage;
			banner.setValue(show.banner.getValue());
			childCount = show.childCount;
			contentRating = show.contentRating;
			countries.clear();
			countries.addAll(show.countries);
			duration = show.duration;
			genres.clear();
			genres.addAll(show.genres);
			leafCount = show.leafCount;
			locations.clear();
			locations.addAll(show.locations);
			originallyAvailableAt = show.originallyAvailableAt;
			originalTitle = show.originalTitle;
			rating = show.rating;
			ratings.clear();
			ratings.addAll(show.ratings);
			roles.clear();
			roles.addAll(show.roles);
			similars.clear();
			similars.addAll(show.similars);
			studio = show.studio;
			tagline = show.tagline;
			theme.setValue(show.theme.getValue());
			thumb.setValue(show.thumb.getValue());
			viewedLeafCount = show.viewedLeafCount;
			year = show.year;
		} else
			throw new ClassCastException("Cannot cast item to PlexShow");
	}

	public String getStudio() {
		fetchDetailedIfNullOrEmpty(studio);
		return studio;
	}

	public String getContentRating() {
		fetchDetailedIfNullOrEmpty(contentRating);
		return contentRating;
	}

	public Double getRating() {
		fetchDetailedIfNullOrEmpty(rating);
		return rating;
	}

	public Integer getYear() {
		fetchDetailedIfNullOrEmpty(year);
		return year;
	}

	public Long getDuration() {
		fetchDetailedIfNullOrEmpty(duration);
		return duration;
	}

	public Integer getLeafCount() {
		fetchDetailedIfNullOrEmpty(leafCount);
		return leafCount;
	}

	public Integer getViewedLeafCount() {
		fetchDetailedIfNullOrEmpty(viewedLeafCount);
		return viewedLeafCount;
	}

	public Integer getChildCount() {
		fetchDetailedIfNullOrEmpty(childCount);
		return childCount;
	}

	public List<PlexTag> getGenres() {
		fetchDetailedIfNullOrEmpty(genres);
		return genres;
	}

	public void setGenres(List<PlexTag> genres) {
		this.genres = genres;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	public void setViewedLeafCount(Integer viewedLeafCount) {
		this.viewedLeafCount = viewedLeafCount;
	}

	public void setLeafCount(Integer leafCount) {
		this.leafCount = leafCount;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public void setBanner(String banner) {
		this.banner.setValue(banner);
	}

	public String getBanner() {
		fetchDetailedIfNullOrEmpty(banner.getValue());
		return (String) banner.getValue();
	}

	public void setTheme(String theme) {
		this.theme.setValue(theme);
	}

	public String getTheme() {
		fetchDetailedIfNullOrEmpty(theme.getValue());
		return (String) theme.getValue();
	}

	public Date getOriginallyAvailableAt() {
		fetchDetailedIfNullOrEmpty(originallyAvailableAt);
		return originallyAvailableAt;
	}

	public List<PlexRole> getRoles() {
		fetchDetailedIfNullOrEmpty(roles);
		return roles;
	}

	public String getOriginalTitle() {
		fetchDetailedIfNullOrEmpty(originalTitle);
		return originalTitle;
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

	public List<PlexTag> getCountries() {
		fetchDetailedIfNullOrEmpty(countries);
		return countries;
	}

	public void setRoles(List<PlexRole> roles) {
		this.roles = roles;
	}

	public void setOriginallyAvailableAt(Date originallyAvailableAt) {
		this.originallyAvailableAt = originallyAvailableAt;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public void setAudienceRating(Double audienceRating) {
		this.audienceRating = audienceRating;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public void setAudienceRatingImage(String audienceRatingImage) {
		this.audienceRatingImage = audienceRatingImage;
	}

	public void setCountries(List<PlexTag> countries) {
		this.countries = countries;
	}

	public List<PlexLocation> getLocations() {
		fetchDetailedIfNullOrEmpty(locations);
		return locations;
	}

	public void setLocations(List<PlexLocation> locations) {
		this.locations = locations;
	}

	public List<PlexTag> getSimilars() {
		fetchDetailedIfNullOrEmpty(similars);
		return similars;
	}

	public List<PlexRating> getRatings() {
		fetchDetailedIfNullOrEmpty(ratings);
		return ratings;
	}

	public void setRatings(List<PlexRating> ratings) {
		this.ratings = ratings;
	}

	public List<PlexSeason> children() {
		fetchDetailedIfNullOrEmpty(key());
		return new MetadataContainer<PlexSeason, PlexDirectory>(key(), getClient(), getToken(), server()).getMetadata();
	}

	public List<PlexEpisode> grandchildren() {
		fetchDetailedIfNullOrEmpty(ratingKey());
		URI uri;
		try {
			uri = new URIBuilder(ratingKey()).appendPath("allLeaves").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexEpisode, PlexDirectory>(uri, getClient(), getToken(), server()).getMetadata();
	}

	public URI banner() {
		fetchDetailedIfNullOrEmpty(banner.getValue());
		return banner.uri();
	}

	public URI theme() {
		fetchDetailedIfNullOrEmpty(theme.getValue());
		return theme.uri();
	}

	@Override
	public PlexShowSection section() {
		return (PlexShowSection) super.section();
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

	public void editGenres(List<PlexTag> genres) {
		editTaglist(genreEditor, genres);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.add(genreEditor);
		return fieldEditors;
	}
}
