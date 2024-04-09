package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackSecondaryDirectory;

public class TrackSecondaryDirectory implements PlexTrackSecondaryDirectory {
    private final SectionSecondaryDirectory filter;
    private final MusicSection section;

    TrackSecondaryDirectory(SectionSecondaryDirectory filter, MusicSection section) {
        this.section = section;
        this.filter = filter;
    }

    public List<PlexTrack> tracks() {
        return filter.apply(section, PlexTrack.TYPE_ID);
    }

    public String getFastKey() {
        return filter.getFastKey();
    }

    public URI fastKey() {
        return filter.fastKey();
    }

    public String getType() {
        return filter.getType();
    }

    public String getKey() {
        return filter.getKey();
    }

    public URI key() {
        return filter.key();
    }

    public String getTitle() {
        return filter.getTitle();
    }
}
