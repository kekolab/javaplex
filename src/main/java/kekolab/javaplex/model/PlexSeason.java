package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;



public interface PlexSeason extends PlexMediatag, PlexChild, PlexParent {
    int TYPE_ID = 3;
    String TYPE_DESCRIPTION = "season";

    Integer getLeafCount();

    Integer getViewedLeafCount();

    Integer getYear();

    PlexShowSection section();

    PlexShow parent();

    List<PlexEpisode> children();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    int typeId();

    PlexSeasonEditor editor();

}