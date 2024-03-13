package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowSection;

class ShowSection extends Section<PlexShow, PlexEpisode> implements PlexShowSection {

	public static final String TYPE_DESCRIPTION = "show";

    public EpisodeCollection createCollection(String title, PlexEpisode episode) {
		return (EpisodeCollection) super.createCollection(title, episode);
	}

	public SeasonCollection createCollection(String title, PlexSeason season) {
		return (SeasonCollection) super.createCollection(title, season);
	}

	public ShowCollection createCollection(String title, PlexShow show) {
		return (ShowCollection) super.createCollection(title, show);
	}

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

}
