package kekolab.javaplex;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeCollection;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexSeasonCollection;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowCollection;
import kekolab.javaplex.model.PlexShowCollections;
import kekolab.javaplex.model.PlexShowSection;

class ShowCollections extends Collections<PlexShowSection> implements PlexShowCollections {

    ShowCollections(ShowSection section) {
        super(section);
    }

    @Override
    public PlexShowCollection create(String title, PlexShow show) {
        return (PlexShowCollection) super.create(title, show);
    }

    @Override
    public PlexShowCollection add(PlexShow show, PlexShowCollection collection) {
        return (PlexShowCollection) super.add(show, collection);
    }

    @Override
    public PlexShowCollection remove(PlexShow show, PlexShowCollection collection) {
        return (PlexShowCollection) super.remove(show, collection);
    }

    @Override
    public PlexSeasonCollection create(String title, PlexSeason season) {
        return (PlexSeasonCollection) super.create(title, season);
    }

    @Override
    public PlexSeasonCollection add(PlexSeason season, PlexSeasonCollection collection) {
        return (PlexSeasonCollection) super.add(season, collection);
    }

    @Override
    public PlexSeasonCollection remove(PlexSeason season, PlexSeasonCollection collection) {
        return (PlexSeasonCollection) super.remove(season, collection);
    }

    @Override
    public PlexEpisodeCollection create(String title, PlexEpisode episode) {
        return (PlexEpisodeCollection) super.create(title, episode);
    }

    @Override
    public PlexEpisodeCollection add(PlexEpisode episode, PlexEpisodeCollection collection) {
        return (PlexEpisodeCollection) super.add(episode, collection);
    }

    @Override
    public PlexEpisodeCollection remove(PlexEpisode episode, PlexEpisodeCollection collection) {
        return (PlexEpisodeCollection) super.remove(episode, collection);
    }

}