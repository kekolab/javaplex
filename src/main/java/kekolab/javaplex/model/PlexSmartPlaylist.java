package kekolab.javaplex.model;

import java.util.Optional;

public interface PlexSmartPlaylist extends PlexPlaylist {

    String TYPE_DESCRIPTION = "playlist";

    String getContent();

    // TODO do we need a more specific editor?
    PlexPlaylistEditor editor();

    PlexSection section();

    Optional<String> getSort();

    PlexFilter getFilter();

}