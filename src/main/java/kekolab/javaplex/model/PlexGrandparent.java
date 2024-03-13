package kekolab.javaplex.model;

import java.util.List;

public interface PlexGrandparent<C extends PlexChild<?, S>, GC extends PlexGrandchild<?, ?, S>, S extends PlexSection<?, ?>> extends PlexParent<C, S> {
    List<GC> grandchildren();        
}