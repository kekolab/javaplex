package kekolab.javaplex.model;

public interface PlexSectionItem extends PlexMetadata {

    PlexSection section();

    String getLibrarySectionTitle();

    Integer getLibrarySectionID();

    String getLibrarySectionKey();

    String getTitleSort();

    int typeId();

    Boolean getTitleLocked();

    Boolean getSummaryLocked();

    Boolean getTitleSortLocked();

}