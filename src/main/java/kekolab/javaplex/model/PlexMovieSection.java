package kekolab.javaplex.model;

import java.util.List;

public interface PlexMovieSection extends PlexSection<PlexMovie, PlexMovie>, WithCollections<PlexMovieCollections, PlexMovieSection> {

	String TYPE_DESCRIPTION = "movie";

	List<PlexMovie> newest();

	List<PlexMovie> onDeck();

	List<PlexMovie> recentlyViewed();

	List<PlexMovie> unwatched();
}
