package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistFilter;
import kekolab.javaplex.model.PlexMusicSection;

class ArtistFilter implements PlexArtistFilter {
    private final Filter filter;
    private final PlexMusicSection section;
    
    ArtistFilter(Filter delegate, PlexMusicSection section) {
        this.section = section;
        this.filter = delegate;
    } 
    
    @Override
    public List<PlexArtist> artists() {
        return filter.apply(section, PlexArtist.TYPE_ID);
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
}
