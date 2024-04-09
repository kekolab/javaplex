package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieCollection;
import kekolab.javaplex.model.PlexMovieSection;

public class MovieCollection extends Collection implements PlexMovieCollection {
    @Override
    public List<PlexMovie> children() {
        return super.children().stream().map(PlexMovie.class::cast).toList();
    }

    @Override
    public PlexMovieSection section() {
        return (PlexMovieSection) super.section();
    }
}
