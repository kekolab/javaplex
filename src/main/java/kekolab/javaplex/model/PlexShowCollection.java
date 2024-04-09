package kekolab.javaplex.model;

import java.util.List;

public interface PlexShowCollection extends PlexCollection {

    String SHOW_COLLECTION_SUBTYPE = "show";

    List<PlexShow> children();

    PlexShowSection section();

}