package kekolab.javaplex.model;

import java.util.List;

public interface PlexCollections {

    List<? extends PlexCollection> list();

    void delete(PlexCollection target);

}