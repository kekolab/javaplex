package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

public interface PlexShow extends PlexGrandparent<PlexSeason, PlexEpisode, PlexShowSection> {
	int TYPE_ID = 2;
	String TYPE_DESCRIPTION = "show";

	String getStudio();

	String getContentRating();

	Double getRating();

	Integer getYear();

	Long getDuration();

	Integer getLeafCount();

	Integer getViewedLeafCount();

	Integer getChildCount();

	List<PlexTag> getGenres();

	String getBanner();

	String getTheme();

	Date getOriginallyAvailableAt();

	List<PlexRole> getRoles();

	String getOriginalTitle();

	Double getAudienceRating();

	String getTagline();

	String getAudienceRatingImage();

	List<PlexTag> getCountries();

	List<PlexLocation> getLocations();

	List<PlexTag> getSimilars();

	List<PlexRating> getRatings();

	URI banner();

	URI theme();

	String getArt();

	URI art();

	String getThumb();

	URI thumb();

	boolean isGenresLocked();

	default int typeId() {
		return TYPE_ID;
	}

	void editGenres(List<PlexTag> genres);

	void editGenresLock(boolean locked);
}
