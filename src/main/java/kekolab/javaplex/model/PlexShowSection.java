package kekolab.javaplex.model;

import java.util.List;

public interface PlexShowSection extends PlexSection<PlexShow, PlexEpisode>, WithCollections<PlexShowCollections, PlexShowSection> {

	String TYPE_DESCRIPTION = "show";

	List<PlexEpisode> newest();

	List<PlexEpisode> onDeck();

	List<PlexEpisode> recentlyViewed();

	List<PlexShow> recentlyViewedShows();

	List<PlexShow> unwatched();

	List<PlexEpisode> episodes();

	List<PlexShowFilter> byGenre();
	List<PlexShowOrEpisodeFilter> byYear();
	List<PlexShowFilter> byContentRating();
	List<PlexShowFilter> byStudio();
	List<PlexShowFilter> byNetwork();
	List<PlexShowFilter> byCountry();
	List<PlexShowOrEpisodeFilter> byCollection();
	List<PlexShowFilter> byDirector();
	List<PlexShowFilter> byActor();
	List<PlexShowFilter> byWriter();
	List<PlexShowFilter> byProducer();
	// TODO show.unwacthedLeaves
	// TODO show.unwacthed	
	List<PlexShowFilter> byLabel();	

	List<PlexEpisodeFilter> byResolution();
	// TODO episode.unwacthed	
	// TODO episode.inProgress	
	List<PlexEpisodeFilter> byAudioLanguage();
	List<PlexEpisodeFilter> bySubtitleLanguage();
	// TODO episode.unmatched	
	// TODO episode.dupliacte	
}
