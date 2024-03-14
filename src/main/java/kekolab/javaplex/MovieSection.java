package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieCollections;
import kekolab.javaplex.model.PlexMovieSection;

class MovieSection extends Section<PlexMovie, PlexMovie> implements PlexMovieSection {

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

	@Override
	public PlexMovieCollections collections() {
		return new MovieCollections(this);
	}
}
