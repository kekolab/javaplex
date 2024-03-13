package kekolab.javaplex.model;

import java.util.List;

public interface PlexMovieSection extends PlexSection<PlexMovie, PlexMovie> {

	String TYPE_DESCRIPTION = "movie";

    PlexMovieCollection createCollection(String title, PlexMovie movie);
	List<PlexMovie> newest();
	List<PlexMovie> onDeck();
	List<PlexMovie> recentlyViewed();
	List<PlexMovie> unwatched();
}
