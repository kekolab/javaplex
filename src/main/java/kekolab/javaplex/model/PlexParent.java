package kekolab.javaplex.model;

import java.util.List;

public interface PlexParent<C extends PlexChild<?, S>, S extends PlexSection<?, ?>> extends PlexMediatag<S> {
    List<C> children();
}