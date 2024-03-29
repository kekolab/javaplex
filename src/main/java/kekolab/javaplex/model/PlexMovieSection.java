package kekolab.javaplex.model;

import java.util.List;

public interface PlexMovieSection extends PlexSection<PlexMovie, PlexMovie>, WithCollections<PlexMovieCollections, PlexMovieSection> {

	String TYPE_DESCRIPTION = "movie";

	List<PlexMovie> newest();

	List<PlexMovie> onDeck();

	List<PlexMovie> recentlyViewed();

	List<PlexMovie> unwatched();

	List<PlexMovieFilter> byGenre();
	List<PlexMovieFilter> byYear();
	List<PlexMovieFilter> byDecade();
	List<PlexMovieFilter> byContentRating();
	List<PlexMovieFilter> byCollection();
	List<PlexMovieFilter> byDirector();
	List<PlexMovieFilter> byActor();
	List<PlexMovieFilter> byWriter();
	List<PlexMovieFilter> byProducer();
	List<PlexMovieFilter> byCountry();
	List<PlexMovieFilter> byStudio();
	List<PlexMovieFilter> byResolution();
	List<PlexMovieFilter> byHDR();
	// TODO List<PlexMovieFilter> inProgress();
	// TODO List<PlexMovieFilter> unmatched();
	List<PlexMovieFilter> byAudioLanguage();
	List<PlexMovieFilter> bySubtitleLanguage();
	List<PlexMovieFilter> byLabel();
	// TODO List<PlexMovieFilter> duplicates();
	
}
