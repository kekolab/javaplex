package kekolab.javaplex.model;

import java.util.List;

public interface PlexTrackCollection extends PlexCollection {

    String TRACK_COLLECTION_SUBTYPE = "track";

    List<PlexTrack> children();

    PlexMusicSection section();

}