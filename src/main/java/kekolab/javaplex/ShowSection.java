package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeFilter;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowCollections;
import kekolab.javaplex.model.PlexShowFilter;
import kekolab.javaplex.model.PlexShowOrEpisodeFilter;
import kekolab.javaplex.model.PlexShowSection;

class ShowSection extends Section<PlexShow, PlexEpisode> implements PlexShowSection {

	public List<PlexEpisode> newest() {
		return executeRequestAndCastMetadata("newest", PlexEpisode.class);
	}

	public List<PlexEpisode> onDeck() {
		return executeRequestAndCastMetadata("onDeck", PlexEpisode.class);
	}

	public List<PlexEpisode> recentlyViewed() {
		return executeRequestAndCastMetadata("recentlyViewed", PlexEpisode.class);
	}

	public List<PlexShow> recentlyViewedShows() {
		return executeRequestAndCastMetadata("recentlyViewedShows", PlexShow.class);
	}

	public List<PlexShow> unwatched() {
		return executeRequestAndCastMetadata("unwatched", PlexShow.class);
	}

	@Override
	public PlexShowCollections collections() {
		return new ShowCollections(this);
	}

	@Override
	public List<PlexEpisode> episodes() {
		return executeRequestAndCastMetadata("allLeaves", PlexEpisode.class);
	}

	@Override
	public List<PlexShowFilter> byGenre() {
		return byFeature("genre", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexShowOrEpisodeFilter> byYear() {
		return byFeature("year", f -> new ShowOrEpisodeFilter(f, this));
	}

	@Override
	public List<PlexShowFilter> byContentRating() {
		return byFeature("contentRating", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexShowFilter> byStudio() {
		return byFeature("studio", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexShowFilter> byNetwork() {
		return byFeature("network", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexShowFilter> byCountry() {
		return byFeature("country", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexShowOrEpisodeFilter> byCollection() {
		return byFeature("collection", f -> new ShowOrEpisodeFilter(f, this));
	}

	@Override
	public List<PlexShowFilter> byDirector() {
		return byFeature("director", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexShowFilter> byActor() {
		return byFeature("actor", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexShowFilter> byWriter() {
		return byFeature("writer", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexShowFilter> byProducer() {
		return byFeature("producer", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexShowFilter> byLabel() {
		return byFeature("label", f -> new ShowFilter(f, this));
	}

	@Override
	public List<PlexEpisodeFilter> byResolution() {
		return byFeature("resolution", f -> new EpisodeFilter(f, this));
	}

	@Override
	public List<PlexEpisodeFilter> byAudioLanguage() {
		return byFeature("audioLanguage", f -> new EpisodeFilter(f, this));
	}

	@Override
	public List<PlexEpisodeFilter> bySubtitleLanguage() {
		return byFeature("subtitleLanguage", f -> new EpisodeFilter(f, this));
	}
}
