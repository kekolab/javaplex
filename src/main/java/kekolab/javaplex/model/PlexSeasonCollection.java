package kekolab.javaplex.model;

import java.util.List;

public interface PlexSeasonCollection extends PlexCollection {

    String SEASON_COLLECTION_SUBTYPE = "season";

    List<PlexSeason> children();

    PlexShowSection section();

}