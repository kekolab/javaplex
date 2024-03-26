package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;

public interface PlexMovie extends PlexVideo<PlexMovieSection> {
	int TYPE_ID = 1;
	String TYPE_DESCRIPTION = "movie";

	Double getRating();

	Double getAudienceRating();

	String getTagline();

	String getAudienceRatingImage();

	Integer getHasPremiumExtras();

	Integer getHasPremiumPrimaryExtra();

	String getRatingImage();

	List<PlexTag> getGenres();

	List<PlexTag> getDirectors();

	List<PlexTag> getWriters();

	List<PlexTag> getProducers();

	List<PlexTag> getCountries();

	List<PlexRole> getRoles();

	List<PlexTag> getSimilars();

	List<PlexRating> getRatings();

	String getSubtype();

	List<String> getCreatedAtAccuracy();

	Integer getCreatedAtTZOffset();

	String getArt();

	URI art();

	String getThumb();

	URI thumb();

	Boolean getCountriesLocked();

	Boolean getDirectorsLocked();

	Boolean getGenresLocked();

	Boolean getWritersLocked();

	Boolean getProducersLocked();

	default int typeId() {
		return TYPE_ID;
	}

	PlexMovieEditor editor();
}
