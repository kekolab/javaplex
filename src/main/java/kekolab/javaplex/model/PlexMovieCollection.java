package kekolab.javaplex.model;

import java.util.List;

public interface PlexMovieCollection extends PlexCollection {

    String MOVIE_COLLECTION_SUBTYPE = "movie";

    List<PlexMovie> children();

    PlexMovieSection section();

}