package kekolab.javaplex;

import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieCollection;
import kekolab.javaplex.model.PlexMovieCollections;
import kekolab.javaplex.model.PlexMovieSection;

class MovieCollections extends Collections<PlexMovieSection> implements PlexMovieCollections {

    MovieCollections(MovieSection section) {
        super(section);
    }

    @Override
    public PlexMovieCollection create(String title, PlexMovie movie) {
        return (PlexMovieCollection) super.create(title, movie);
    }

    @Override
    public PlexMovieCollection add(PlexMovie movie, PlexMovieCollection collection) {
        return (PlexMovieCollection) super.add(movie, collection);
    }

    @Override
    public PlexMovieCollection remove(PlexMovie movie, PlexMovieCollection collection) {
        return (PlexMovieCollection) super.remove(movie, collection);
    }

    
}