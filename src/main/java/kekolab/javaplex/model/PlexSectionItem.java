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

    boolean isTitleLocked();

    boolean isSummaryLocked();

    boolean isTitleSortLocked();

    void editTitle(String title);// TODO Move to editor?

    void editTitleLock(boolean locked);// TODO Move to editor?

    void editSummary(String summary);// TODO Move to editor?

    void editSummaryLock(boolean locked);// TODO Move to editor?

    void editTitleSort(String titleSort);// TODO Move to editor?

    void editTitleSortLock(boolean locked);// TODO Move to editor?

    void commitEdits();// TODO Move to editor?
}
