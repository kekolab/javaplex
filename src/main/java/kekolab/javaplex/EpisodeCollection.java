package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeCollection;
import kekolab.javaplex.model.PlexShowSection;

public class EpisodeCollection extends Collection implements PlexEpisodeCollection  {
    @Override
    public List<PlexEpisode> children() {
        return super.children().stream().map(PlexEpisode.class::cast).toList();
    }

    @Override
    public PlexShowSection section() {
        return (PlexShowSection) super.section();
    }

}
