package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeFilter;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowSection;

class EpisodeFilter implements PlexEpisodeFilter {
    private final Filter filter;
    private final PlexShowSection section;
    
    EpisodeFilter(Filter delegate, PlexShowSection section) {
        this.section = section;
        this.filter = delegate;
    } 
    
    @Override
    public List<PlexEpisode> episodes() {
        return filter.apply(section, PlexShow.TYPE_ID);
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
