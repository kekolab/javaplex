package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieSection;

class MovieSection extends Section<PlexMovie, PlexMovie>  implements PlexMovieSection {


    public MovieCollection createCollection(String title, PlexMovie movie) {
		return (MovieCollection) super.createCollection(title, movie);
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
