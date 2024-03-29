package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexShowOrEpisodeFilter;
import kekolab.javaplex.model.PlexShowSection;

class ShowOrEpisodeFilter extends ShowFilter implements PlexShowOrEpisodeFilter {
    private final EpisodeFilter episodeFilter;

    ShowOrEpisodeFilter(Filter delegate, PlexShowSection section) {
        super(delegate, section);
        episodeFilter = new EpisodeFilter(delegate, section);
    }

    @Override
    public List<PlexEpisode> episodes() {
        return episodeFilter.episodes();
    }
}
