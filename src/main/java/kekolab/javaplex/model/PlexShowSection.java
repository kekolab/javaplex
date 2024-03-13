package kekolab.javaplex.model;

import java.util.List;

public interface PlexShowSection extends PlexSection<PlexShow, PlexEpisode> {

	String TYPE_DESCRIPTION = "show";

	PlexEpisodeCollection createCollection(String title, PlexEpisode episode);

	PlexSeasonCollection createCollection(String title, PlexSeason season);

	PlexShowCollection createCollection(String title, PlexShow show);

	List<PlexEpisode> newest();

	List<PlexEpisode> onDeck();

	List<PlexEpisode> recentlyViewed();

	List<PlexShow> recentlyViewedShows();

	List<PlexShow> unwatched();

}
