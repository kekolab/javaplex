package kekolab.javaplex.model;


public interface PlexShowCollections extends PlexCollections {

    PlexShowCollection create(String title, PlexShow PlexShow);

    PlexSeasonCollection create(String title, PlexSeason PlexSeason);

    PlexEpisodeCollection create(String title, PlexEpisode PlexEpisode);

    PlexShowCollection add(PlexShowCollection collection, PlexShow PlexShow);

    PlexSeasonCollection add(PlexSeasonCollection collection, PlexSeason PlexSeason);

    PlexEpisodeCollection add(PlexEpisodeCollection collection, PlexEpisode PlexEpisode);

    PlexShowCollection remove(PlexShowCollection collection, PlexShow PlexShow);

    PlexSeasonCollection remove(PlexSeasonCollection collection, PlexSeason PlexSeason);

    PlexEpisodeCollection remove(PlexEpisodeCollection collection, PlexEpisode PlexEpisode);

}