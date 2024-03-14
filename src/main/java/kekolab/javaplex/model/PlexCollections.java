package kekolab.javaplex.model;

import java.util.*;

public interface PlexCollections<S extends PlexSection<?, ?>> {
    List<PlexCollection<?, S>> list();

    void delete(PlexCollection<?, S> target);

}
