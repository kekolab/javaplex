package kekolab.javaplex.model;

import java.util.List;



public interface PlexShowSection extends PlexSection {

    String TYPE_DESCRIPTION = "show";

    PlexSectionQueryBuilder<PlexShow> all();

    List<PlexEpisode> recentlyAdded();

    List<PlexEpisode> newest();

    List<PlexEpisode> onDeck();

    List<PlexEpisode> recentlyViewed();

    List<PlexShow> recentlyViewedShows();

    List<PlexShow> unwatched();

    PlexSectionQueryBuilder<PlexSeason> seasons();

    PlexSectionQueryBuilder<PlexEpisode> episodes();

    PlexShowCollections collections();

    List<PlexShowSecondaryDirectory> byGenre();

    List<PlexShowOrEpisodeSecondaryDirectory> byYear();

    List<PlexShowSecondaryDirectory> byContentRating();

    List<PlexShowSecondaryDirectory> byStudio();

    List<PlexShowSecondaryDirectory> byNetwork();

    List<PlexShowSecondaryDirectory> byCountry();

    List<PlexShowOrEpisodeSecondaryDirectory> byCollection();

    List<PlexShowSecondaryDirectory> byDirector();

    List<PlexShowSecondaryDirectory> byActor();

    List<PlexShowSecondaryDirectory> byWriter();

    List<PlexShowSecondaryDirectory> byProducer();

    List<PlexShowSecondaryDirectory> byLabel();

    List<PlexEpisodeSecondaryDirectory> byResolution();

    List<PlexEpisodeSecondaryDirectory> byAudioLanguage();

    List<PlexEpisodeSecondaryDirectory> bySubtitleLanguage();

}