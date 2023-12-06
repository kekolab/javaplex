package kekolab.javaplex;

import java.util.List;

public interface PlexParent<M extends PlexMediatag<?>> {
    List<M> children();
}