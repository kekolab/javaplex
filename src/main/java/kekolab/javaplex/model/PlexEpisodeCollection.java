package kekolab.javaplex.model;

import java.util.List;

public interface PlexEpisodeCollection extends PlexCollection {

    String EPISODE_COLLECTION_SUBTYPE = "episode";

    List<PlexEpisode> children();

    PlexShowSection section();

}