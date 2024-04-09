package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieSecondaryDirectory;

public class MovieSecondaryDirectory implements PlexMovieSecondaryDirectory {
    private final SectionSecondaryDirectory filter;
    private final MovieSection section;

    MovieSecondaryDirectory(SectionSecondaryDirectory delegate, MovieSection section) {
        this.section = section;
        this.filter = delegate;
    }

    @Override
    public String getFastKey() {
        return filter.getFastKey();
    }

    @Override
    public URI fastKey() {
        return filter.fastKey();
    }

    @Override
    public String getType() {
        return filter.getType();
    }

    @Override
    public String getKey() {
        return filter.getKey();
    }

    @Override
    public URI key() {
        return filter.key();
    }

    @Override
    public String getTitle() {
        return filter.getTitle();
    }

    @Override
    public List<PlexMovie> movies() {
        return filter.apply(section, PlexMovie.TYPE_ID);
    }
}
