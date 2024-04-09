package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieSecondaryDirectory;
import kekolab.javaplex.model.PlexMovieSection;
import kekolab.javaplex.model.PlexSectionQueryBuilder;



public class MovieSection extends Section implements PlexMovieSection {

	@Override
	public PlexSectionQueryBuilder<PlexMovie> all() {
		return new SectionQueryBuilder<PlexMovie>()
				.withSection(this)
				.withPath("all");
	}

	@Override
	public List<PlexMovie> recentlyAdded() {
		return new SectionQueryBuilder<PlexMovie>()
				.withSection(this)
				.withPath("recentlyAdded")
				.execute();
	}


	@Override
	public List<PlexMovie> newest() {
		return new SectionQueryBuilder<PlexMovie>()
				.withSection(this)
				.withPath("newest")
				.execute();
	}

	@Override
	public List<PlexMovie> onDeck() {
		return new SectionQueryBuilder<PlexMovie>()
				.withSection(this)
				.withPath("onDeck")
				.execute();
	}

	@Override
	public List<PlexMovie> recentlyViewed() {
		return new SectionQueryBuilder<PlexMovie>()
				.withSection(this)
				.withPath("recentlyViewed")
				.execute();
	}

	@Override
	public List<PlexMovie> unwatched() {
		return new SectionQueryBuilder<PlexMovie>()
				.withSection(this)
				.withPath("unwatched")
				.execute();
	}

	@Override
	public MovieCollections collections() {
		return new MovieCollections(this);
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byGenre() {
		return byFeature("genre", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byYear() {
		return byFeature("year", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byDecade() {
		return byFeature("decade", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byContentRating() {
		return byFeature("contentRating", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byCollection() {
		return byFeature("collection", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byDirector() {
		return byFeature("director", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byActor() {
		return byFeature("actor", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byWriter() {
		return byFeature("writer", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byProducer() {
		return byFeature("producer", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byCountry() {
		return byFeature("country", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byStudio() {
		return byFeature("studio", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byResolution() {
		return byFeature("resolution", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byHDR() {
		return byFeature("hdr", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byAudioLanguage() {
		return byFeature("audioLanguage", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> bySubtitleLanguage() {
		return byFeature("subtitleLanguage", f -> new MovieSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexMovieSecondaryDirectory> byLabel() {
		return byFeature("label", f -> new MovieSecondaryDirectory(f, this));
	}
}
