package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackCollection;

public class TrackCollection extends Collection implements PlexTrackCollection {
    @Override
    public List<PlexTrack> children() {
        return super.children().stream().map(PlexTrack.class::cast).toList();
    }

    @Override
    public MusicSection section() {
        return (MusicSection) super.section();
    }
}
