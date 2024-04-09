package kekolab.javaplex;

import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieCollection;
import kekolab.javaplex.model.PlexMovieCollections;

public class MovieCollections extends Collections implements PlexMovieCollections  {

    protected MovieCollections(MovieSection section) {
        super(section);
    }

    public PlexMovieCollection create(String title, PlexMovie item) {
        return (PlexMovieCollection) super.create(title, item);
    }

    public PlexMovieCollection add(PlexMovieCollection collection, PlexMovie movie) {
        return (PlexMovieCollection) super.add(collection, movie);
    }

    public PlexMovieCollection remove(PlexMovieCollection collection, PlexMovie movie) {
        return (PlexMovieCollection) super.remove(collection, movie);
    }
}