package kekolab.javaplex;

import java.util.List;

public class PlexMovieSection extends PlexSection<PlexMovie, PlexMovie> {

	public static final String TYPE_DESCRIPTION = "movie";

    public PlexMovieCollection createCollection(String title, PlexMovie movie) {
		return (PlexMovieCollection) super.createCollection(title, movie);
	}

	public List<PlexMovie> newest() {
		return executeRequestAndCastMetadata("newest", PlexMovie.class);
	}

	public List<PlexMovie> onDeck() {
		return executeRequestAndCastMetadata("onDeck", PlexMovie.class);
	}

	public List<PlexMovie> recentlyViewed() {
		return executeRequestAndCastMetadata("recentlyViewed", PlexMovie.class);
	}

	public List<PlexMovie> unwatched() {
		return executeRequestAndCastMetadata("unwatched", PlexMovie.class);
	}
}
