package kekolab.javaplex.model;

import java.net.URI;

public interface PlexSectionItem<S extends PlexSection<?, ?>> extends PlexMetadata {
    S section();

    URI sectionUri();

    String getLibrarySectionTitle();

    Integer getLibrarySectionID();

    String getLibrarySectionKey();

    String getTitleSort();

    int typeId();

    Boolean getTitleLocked();

    Boolean getSummaryLocked();

    Boolean getTitleSortLocked();

    @Override
    PlexSectionItemEditor editor();

    // TODO Delete a sectionItem? It is deleted just like a PlexCollection (see classes PlexCollections and Collections)
}
