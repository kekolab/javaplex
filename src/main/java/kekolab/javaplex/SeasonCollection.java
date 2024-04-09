package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexSeasonCollection;
import kekolab.javaplex.model.PlexShowSection;

public class SeasonCollection extends Collection implements PlexSeasonCollection {
    @Override
    public List<PlexSeason> children() {
        return super.children().stream().map(PlexSeason.class::cast).toList();
    }

    @Override
    public PlexShowSection section() {
        return (ShowSection) super.section();
    }
}
