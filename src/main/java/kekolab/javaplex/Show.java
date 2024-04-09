package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexLocation;
import kekolab.javaplex.model.PlexRating;
import kekolab.javaplex.model.PlexRole;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowEditor;
import kekolab.javaplex.model.PlexShowSection;
import kekolab.javaplex.model.PlexTag;

public class Show extends Mediatag implements  PlexShow {
	private Double audienceRating;
	private String audienceRatingImage;
	private Integer childCount;
	private String contentRating;
	@JsonProperty("Country")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> countries;
	private Long duration;
	@JsonProperty("Genre")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> genres;
	private Integer leafCount;
	@JsonProperty("Location")
	@JsonDeserialize(contentAs = Location.class)
	private List<PlexLocation> locations;
	private Date originallyAvailableAt;
	private String originalTitle;
	private Double rating;
	@JsonProperty("Rating")
	@JsonDeserialize(contentAs = Rating.class)
	private List<PlexRating> ratings;
	@JsonProperty("Role")
	@JsonDeserialize(contentAs = Role.class)
	private List<PlexRole> roles;
	@JsonProperty("Similar")
	@JsonDeserialize(contentAs = Tag.class)
	private List<PlexTag> similars;
	private String studio;
	private String tagline;
	private Integer viewedLeafCount;
	private Integer year;
	private UriProvider art;
	private UriProvider banner;
	private UriProvider theme;
	private UriProvider thumb;

	public Show() {
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
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		PlexShow s = (PlexShow) source;
		setAudienceRating(s.getAudienceRating());
		setAudienceRatingImage(s.getAudienceRatingImage());
		setChildCount(s.getChildCount());
		setContentRating(s.getContentRating());
		setCountries(s.getCountries());
		setDuration(s.getDuration());
		setGenres(s.getGenres());
		setLeafCount(s.getLeafCount());
		setOriginallyAvailableAt(s.getOriginallyAvailableAt());
		setOriginalTitle(s.getOriginalTitle());
		setRating(s.getRating());
		setRatings(s.getRatings());
		setRoles(s.getRoles());
		setSimilars(s.getSimilars());
		setStudio(s.getStudio());
		setTagline(s.getTagline());
		setViewCount(s.getViewedLeafCount());
		setYear(s.getYear());
		setArt(s.getArt());
		setBanner(s.getBanner());
		setTheme(s.getTheme());
		setThumb(s.getThumb());
	}

	public void setSimilars(List<PlexTag> similars) {
		this.similars = similars;
	}

	@Override
	public String getStudio() {
		ensureDetailed(studio);
		return studio;
	}

	@Override
	public String getContentRating() {
		ensureDetailed(contentRating);
		return contentRating;
	}

	@Override
	public Double getRating() {
		ensureDetailed(rating);
		return rating;
	}

	@Override
	public Integer getYear() {
		ensureDetailed(year);
		return year;
	}

	@Override
	public Long getDuration() {
		ensureDetailed(duration);
		return duration;
	}

	@Override
	public Integer getLeafCount() {
		ensureDetailed(leafCount);
		return leafCount;
	}

	@Override
	public Integer getViewedLeafCount() {
		ensureDetailed(viewedLeafCount);
		return viewedLeafCount;
	}

	@Override
	public Integer getChildCount() {
		ensureDetailed(childCount);
		return childCount;
	}

	@Override
	public List<PlexTag> getGenres() {
		ensureDetailed(genres);
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

	@Override
	public String getBanner() {
		ensureDetailed(banner.getValue());
		return (String) banner.getValue();
	}

	public void setTheme(String theme) {
		this.theme.setValue(theme);
	}

	@Override
	public String getTheme() {
		ensureDetailed(theme.getValue());
		return (String) theme.getValue();
	}

	@Override
	public Date getOriginallyAvailableAt() {
		ensureDetailed(originallyAvailableAt);
		return originallyAvailableAt;
	}

	@Override
	public List<PlexRole> getRoles() {
		ensureDetailed(roles);
		return roles;
	}

	@Override
	public String getOriginalTitle() {
		ensureDetailed(originalTitle);
		return originalTitle;
	}

	@Override
	public Double getAudienceRating() {
		ensureDetailed(audienceRating);
		return audienceRating;
	}

	@Override
	public String getTagline() {
		ensureDetailed(tagline);
		return tagline;
	}

	@Override
	public String getAudienceRatingImage() {
		ensureDetailed(audienceRatingImage);
		return audienceRatingImage;
	}

	@Override
	public List<PlexTag> getCountries() {
		ensureDetailed(countries);
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

	@Override
	public List<PlexLocation> getLocations() {
		ensureDetailed(locations);
		return locations;
	}

	public void setLocations(List<PlexLocation> locations) {
		this.locations = locations;
	}

	@Override
	public List<PlexTag> getSimilars() {
		ensureDetailed(similars);
		return similars;
	}

	@Override
	public List<PlexRating> getRatings() {
		ensureDetailed(ratings);
		return ratings;
	}

	public void setRatings(List<PlexRating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public List<PlexSeason> children() {
		ensureDetailed(key());
		return new MetadataContainer<PlexSeason, Directory>(key(), getServer()).getMetadata();
	}

	@Override
	public List<PlexEpisode> grandchildren() {
		ensureDetailed(ratingKey());
		URI uri;
		try {
			uri = new URIBuilder(ratingKey()).appendPath("allLeaves").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexEpisode, Directory>(uri, getServer()).getMetadata();
	}

	@Override
	public URI banner() {
		ensureDetailed(banner.getValue());
		return banner.uri();
	}

	@Override
	public URI theme() {
		ensureDetailed(theme.getValue());
		return theme.uri();
	}

	@Override
	public PlexShowSection section() {
		return (PlexShowSection) super.section();
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
	public Boolean getGenresLocked() {
		return getFieldLocked("genre");
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	@Override
	public PlexShowEditor editor() {
		return new ShowEditor(this);
	}
}
