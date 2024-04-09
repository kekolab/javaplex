package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeSecondaryDirectory;
import kekolab.javaplex.model.PlexShowOrEpisodeSecondaryDirectory;

public class ShowOrEpisodeSecondaryDirectory extends ShowSecondaryDirectory implements PlexShowOrEpisodeSecondaryDirectory {
    private final PlexEpisodeSecondaryDirectory episodeFilter;

    ShowOrEpisodeSecondaryDirectory(SectionSecondaryDirectory delegate, ShowSection section) {
        super(delegate, section);
        episodeFilter = new EpisodeSecondaryDirectory(delegate, section);
    }

    public List<PlexEpisode> episodes() {
        return episodeFilter.episodes();
    }
}
