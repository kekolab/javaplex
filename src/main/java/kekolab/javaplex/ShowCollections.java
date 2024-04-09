package kekolab.javaplex;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeCollection;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexSeasonCollection;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowCollection;
import kekolab.javaplex.model.PlexShowCollections;

public class ShowCollections extends Collections implements PlexShowCollections {

    protected ShowCollections(ShowSection section) {
        super(section);
    }

    public PlexShowCollection create(String title, PlexShow show) {
        return (ShowCollection) super.create(title, show);
    }

    public PlexSeasonCollection create(String title, PlexSeason season) {
        return (PlexSeasonCollection) super.create(title, season);
    }

    public PlexEpisodeCollection create(String title, PlexEpisode episode) {
        return (PlexEpisodeCollection) super.create(title, episode);
    }

    public PlexShowCollection add(PlexShowCollection collection, PlexShow show) {
        return (PlexShowCollection) super.add(collection, show);
    }

    public PlexSeasonCollection add(PlexSeasonCollection collection, PlexSeason season) {
        return (PlexSeasonCollection) super.add(collection, season);
    }

    public PlexEpisodeCollection add(PlexEpisodeCollection collection, PlexEpisode episode) {
        return (PlexEpisodeCollection) super.add(collection, episode);
    }

    public PlexShowCollection remove(PlexShowCollection collection, PlexShow show) {
        return (PlexShowCollection) super.remove(collection, show);
    }

    public PlexSeasonCollection remove(PlexSeasonCollection collection, PlexSeason season) {
        return (PlexSeasonCollection) super.remove(collection, season);
    }

    public PlexEpisodeCollection remove(PlexEpisodeCollection collection, PlexEpisode episode) {
        return (PlexEpisodeCollection) super.remove(collection, episode);
    }
}