package kekolab.javaplex.model;

public interface PlexMovieCollections extends PlexCollections<PlexMovieSection> {
    PlexMovieCollection create(String title, PlexMovie movie);
    PlexMovieCollection add(PlexMovie movie, PlexMovieCollection collection);
    PlexMovieCollection remove(PlexMovie movie, PlexMovieCollection collection);
}