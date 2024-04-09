package kekolab.javaplex.model;


public interface PlexMovieCollections extends PlexCollections {

    PlexMovieCollection create(String title, PlexMovie item);

    PlexMovieCollection add(PlexMovieCollection collection, PlexMovie movie);

    PlexMovieCollection remove(PlexMovieCollection collection, PlexMovie movie);

}