package kekolab.javaplex.model;

import java.util.List;

public interface PlexAudioPlaylist extends PlexPlaylist {

    String SUBTYPE_DESCRIPTION = "audio";

    List<PlexTrack> children();
}