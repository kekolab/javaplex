package kekolab.javaplex;

import java.util.List;

public class PlexShowSection extends PlexSection<PlexShow, PlexEpisode> {

	public static final String TYPE_DESCRIPTION = "show";

    public PlexEpisodeCollection createCollection(String title, PlexEpisode episode) {
		return (PlexEpisodeCollection) super.createCollection(title, episode);
	}

	public PlexSeasonCollection createCollection(String title, PlexSeason season) {
		return (PlexSeasonCollection) super.createCollection(title, season);
	}

	public PlexShowCollection createCollection(String title, PlexShow show) {
		return (PlexShowCollection) super.createCollection(title, show);
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
