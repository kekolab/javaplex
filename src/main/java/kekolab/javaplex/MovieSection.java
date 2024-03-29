package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieCollections;
import kekolab.javaplex.model.PlexMovieFilter;
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

	@Override
	public List<PlexMovieFilter> byGenre() {
		return byFeature("genre", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byYear() {
		return byFeature("year", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byDecade() {
		return byFeature("decade", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byContentRating() {
		return byFeature("contentRating", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byCollection() {
		return byFeature("collection", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byDirector() {
		return byFeature("director", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byActor() {
		return byFeature("actor", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byWriter() {
		return byFeature("writer", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byProducer() {
		return byFeature("producer", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byCountry() {
		return byFeature("country", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byStudio() {
		return byFeature("studio", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byResolution() {
		return byFeature("resolution", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byHDR() {
		return byFeature("hdr", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byAudioLanguage() {
		return byFeature("audioLanguage", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> bySubtitleLanguage() {
		return byFeature("subtitleLanguage", f -> new MovieFilter(f, this));
	}

	@Override
	public List<PlexMovieFilter> byLabel() {
		return byFeature("label", f -> new MovieFilter(f, this));
	}
}
