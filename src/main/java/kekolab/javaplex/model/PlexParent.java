package kekolab.javaplex.model;

import java.util.List;

public interface PlexParent {
    List<? extends PlexMediatag> children();
}