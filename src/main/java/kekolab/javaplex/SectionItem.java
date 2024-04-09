package kekolab.javaplex;

import kekolab.javaplex.model.PlexSection;
import kekolab.javaplex.model.PlexSectionItem;

public abstract class SectionItem extends Metadata implements PlexSectionItem {
    // TODO Delete a sectionItem? It is deleted just like a PlexCollection (see
    // classes PlexCollections and Collections)

    private String librarySectionTitle;
    private Integer librarySectionID;
    private String librarySectionKey;
    private String titleSort;

    @Override
    void update(Metadata source) {
        super.update(source);
        PlexSectionItem item = (PlexSectionItem) source;
        setLibrarySectionID(item.getLibrarySectionID());
        setLibrarySectionKey(item.getLibrarySectionKey());
        setLibrarySectionTitle(item.getLibrarySectionTitle());
        setTitleSort(item.getTitleSort());
    }

    @Override
    public PlexSection section() {
        if (librarySectionID != null)
            return getServer().library().section(librarySectionID);
        return null;
    }

    @Override
    public String getLibrarySectionTitle() {
        ensureDetailed(librarySectionTitle);
        return librarySectionTitle;
    }

    @Override
    public Integer getLibrarySectionID() {
        ensureDetailed(librarySectionID);
        return librarySectionID;
    }

    @Override
    public String getLibrarySectionKey() {
        ensureDetailed(librarySectionKey);
        return librarySectionKey;
    }

    @Override
    public String getTitleSort() {
        return titleSort;
    }

    public void setTitleSort(String titleSort) {
        this.titleSort = titleSort;
    }

    public void setLibrarySectionTitle(String librarySectionTitle) {
        this.librarySectionTitle = librarySectionTitle;
    }

    public void setLibrarySectionID(Integer librarySectionID) {
        this.librarySectionID = librarySectionID;
    }

    public void setLibrarySectionKey(String librarySectionKey) {
        this.librarySectionKey = librarySectionKey;
    }

    @Override
    public abstract int typeId();

    @Override
    public Boolean getTitleLocked() {
        return getFieldLocked("title");
    }

    @Override
    public Boolean getSummaryLocked() {
        return getFieldLocked("summary");
    }

    @Override
    public Boolean getTitleSortLocked() {
        return getFieldLocked("titleSort");
    }
}
