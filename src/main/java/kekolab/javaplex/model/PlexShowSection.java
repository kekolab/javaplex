package kekolab.javaplex.model;

import java.util.List;

public interface PlexShowSection extends PlexSection<PlexShow, PlexEpisode>, WithCollections<PlexShowCollections, PlexShowSection> {

	String TYPE_DESCRIPTION = "show";

	List<PlexEpisode> newest();

	List<PlexEpisode> onDeck();

	List<PlexEpisode> recentlyViewed();

	List<PlexShow> recentlyViewedShows();

	List<PlexShow> unwatched();

}
