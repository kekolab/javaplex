package kekolab.javaplex.model;

import java.util.List;

public interface PlexVideoPlaylist extends PlexPlaylist {

    String SUBTYPE_DESCRIPTION = "video";

    List<? extends PlexVideo> children();

}