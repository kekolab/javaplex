package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowCollections;
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
}
