package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackFilter;

class TrackFilter implements PlexTrackFilter {
    private final Filter filter;
    private final PlexMusicSection section;

    TrackFilter(Filter filter, PlexMusicSection section) {
        this.section = section;
        this.filter = filter;
    }

    @Override
    public List<PlexTrack> tracks() {
        return filter.apply(section, PlexTrack.TYPE_ID);
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
