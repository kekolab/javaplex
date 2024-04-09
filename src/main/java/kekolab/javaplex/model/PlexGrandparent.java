package kekolab.javaplex.model;

import java.util.List;

public interface PlexGrandparent extends PlexParent {
    List<? extends PlexMediatag> grandchildren();
}