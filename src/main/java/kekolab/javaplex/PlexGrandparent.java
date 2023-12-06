package kekolab.javaplex;

import java.util.List;

public interface PlexGrandparent<C extends PlexMediatag<?>, GC extends PlexMediatag<?>> extends PlexParent<C> {
    List<GC> grandchildren();        
}