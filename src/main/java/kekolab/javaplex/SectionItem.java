package kekolab.javaplex;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kekolab.javaplex.model.PlexSection;
import kekolab.javaplex.model.PlexSectionItem;

abstract class SectionItem<S extends PlexSection<?, ?>> extends Metadata implements PlexSectionItem<S> {
    private String librarySectionTitle;
    private Integer librarySectionID;
    private String librarySectionKey;
    private String titleSort;
    @JsonIgnore
    private UriProvider sectionUriProvider;

    public SectionItem() {
        sectionUriProvider = new UriProvider(() -> getServer().getUri());

    }

    @Override
    void update(Metadata source) {
        super.update(source);
        SectionItem<?> item = (SectionItem<?>) source;
        setLibrarySectionID(item.getLibrarySectionID());
        setLibrarySectionKey(item.getLibrarySectionKey());
        setLibrarySectionTitle(item.getLibrarySectionTitle());
        setTitleSort(item.getTitleSort());
    }

    public S section() {
        if (librarySectionID != null)
            return (S) getServer().library().section(librarySectionID);
        return null;
    }

    public URI sectionUri() {
        if (librarySectionKey != null) {
            sectionUriProvider.setValue(librarySectionKey);
            return sectionUriProvider.uri();
        } else if (librarySectionID != null) {
            sectionUriProvider.setValue("/library/sections/" + librarySectionID);
            return sectionUriProvider.uri();
        }
        return null;
    }

    public String getLibrarySectionTitle() {
        ensureDetailed(librarySectionTitle);
        return librarySectionTitle;
    }

    public Integer getLibrarySectionID() {
        ensureDetailed(librarySectionID);
        return librarySectionID;
    }

    public String getLibrarySectionKey() {
        ensureDetailed(librarySectionKey);
        return librarySectionKey;
    }

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

    public abstract int typeId();

    public Boolean getTitleLocked() {
        return getFieldLocked("title");
    }

    public Boolean getSummaryLocked() {
        return getFieldLocked("summary");
    }

    public Boolean getTitleSortLocked() {
        return getFieldLocked("titleSort");
    }
}
