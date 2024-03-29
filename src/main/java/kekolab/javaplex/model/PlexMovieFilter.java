package kekolab.javaplex.model;

import java.util.List;

public interface PlexMovieFilter extends PlexFilter {
    List<PlexMovie> movies();
}