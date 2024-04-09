package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeSecondaryDirectory;
import kekolab.javaplex.model.PlexShow;

public class EpisodeSecondaryDirectory implements PlexEpisodeSecondaryDirectory {
    private final SectionSecondaryDirectory filter;
    private final ShowSection section;

    EpisodeSecondaryDirectory(SectionSecondaryDirectory delegate, ShowSection section) {
        this.section = section;
        this.filter = delegate;
    }

    @Override
    public List<PlexEpisode> episodes() {
        return filter.apply(section, PlexShow.TYPE_ID);
    }

    public String getFastKey() {
        return filter.getFastKey();
    }

    public URI fastKey() {
        return filter.fastKey();
    }

    public String getType() {
        return filter.getType();
    }

    public String getKey() {
        return filter.getKey();
    }

    public URI key() {
        return filter.key();
    }

    public String getTitle() {
        return filter.getTitle();
    }
}
