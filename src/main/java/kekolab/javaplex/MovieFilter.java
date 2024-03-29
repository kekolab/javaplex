package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieFilter;
import kekolab.javaplex.model.PlexMovieSection;

class MovieFilter implements PlexMovieFilter {
    private final Filter filter;
    private final PlexMovieSection section;
    
    MovieFilter(Filter delegate, PlexMovieSection section) {
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
