package kekolab.javaplex.model;

public interface PlexShowCollections extends PlexCollections<PlexShowSection> {
    PlexShowCollection create(String title, PlexShow show);
    PlexShowCollection add(PlexShow show, PlexShowCollection collection);
    PlexShowCollection remove(PlexShow show, PlexShowCollection collection);

    PlexSeasonCollection create(String title, PlexSeason season);
    PlexSeasonCollection add(PlexSeason season, PlexSeasonCollection collection);
    PlexSeasonCollection remove(PlexSeason season, PlexSeasonCollection collection);

    PlexEpisodeCollection create(String title, PlexEpisode episode);
    PlexEpisodeCollection add(PlexEpisode episode, PlexEpisodeCollection collection);
    PlexEpisodeCollection remove(PlexEpisode episode, PlexEpisodeCollection collection);
}