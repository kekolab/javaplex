package kekolab.javaplex.model;

import java.util.List;



public interface PlexMovieSection extends PlexSection {

    String TYPE_DESCRIPTION = "movie";    

    PlexSectionQueryBuilder<PlexMovie> all();

    List<PlexMovie> recentlyAdded();

    List<PlexMovie> newest();

    List<PlexMovie> onDeck();

    List<PlexMovie> recentlyViewed();

    List<PlexMovie> unwatched();

    PlexMovieCollections collections();

    List<PlexMovieSecondaryDirectory> byGenre();

    List<PlexMovieSecondaryDirectory> byYear();

    List<PlexMovieSecondaryDirectory> byDecade();

    List<PlexMovieSecondaryDirectory> byContentRating();

    List<PlexMovieSecondaryDirectory> byCollection();

    List<PlexMovieSecondaryDirectory> byDirector();

    List<PlexMovieSecondaryDirectory> byActor();

    List<PlexMovieSecondaryDirectory> byWriter();

    List<PlexMovieSecondaryDirectory> byProducer();

    List<PlexMovieSecondaryDirectory> byCountry();

    List<PlexMovieSecondaryDirectory> byStudio();

    List<PlexMovieSecondaryDirectory> byResolution();

    List<PlexMovieSecondaryDirectory> byHDR();

    List<PlexMovieSecondaryDirectory> byAudioLanguage();

    List<PlexMovieSecondaryDirectory> bySubtitleLanguage();

    List<PlexMovieSecondaryDirectory> byLabel();

}