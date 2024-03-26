package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;

public interface PlexEpisode extends PlexGrandchild<PlexShow, PlexSeason, PlexShowSection>, PlexVideo<PlexShowSection> {
	int TYPE_ID = 4;
	String TYPE_DESCRIPTION = "episode";

	List<PlexTag> getWriters();

	Double getRating();

	Double getAudienceRating();

	String getAudienceRatingImage();

	List<PlexTag> getDirectors();

	List<PlexRole> getRoles();

	String getChapterSource();

	List<PlexTag> getProducers();

	List<PlexRating> getRatings();

	String getArt();

	URI art();

	String getThumb();

	URI thumb();

	Boolean getWritersLocked();

	Boolean getDirectorsLocked();

	default int typeId() {
		return TYPE_ID;
	}

	PlexEpisodeEditor editor();
}
