package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class PlexSectionItem<S extends PlexSection<?, ?>> extends PlexMetadata {
    private String librarySectionTitle;
    private Integer librarySectionID;
    private String librarySectionKey;
    private String titleSort;
    @JsonIgnore
    private UriProvider sectionUriProvider;

    @JsonIgnore
    private FieldEditor<String> titleEditor;
    @JsonIgnore
    private FieldEditor<Boolean> titleLockEditor;
    @JsonIgnore
    private FieldEditor<String> summaryEditor;
    @JsonIgnore
    private FieldEditor<Boolean> summaryLockEditor;
    @JsonIgnore
    private FieldEditor<String> titleSortEditor;
    @JsonIgnore
    private FieldEditor<Boolean> titleSortLockEditor;

    public PlexSectionItem() {
        sectionUriProvider = new UriProvider(() -> server().uri());
        titleEditor = new StringFieldEditor("title.value", this::getTitle, false);
        titleLockEditor = new BooleanFieldEditor("title.locked", this::isTitleLocked);
        summaryEditor = new StringFieldEditor("summary.value", this::getSummary, true);
        summaryLockEditor = new BooleanFieldEditor("summary.locked", this::isSummaryLocked);
        titleSortEditor = new StringFieldEditor("titleSort.value", this::getTitleSort, true);
        titleSortLockEditor = new BooleanFieldEditor("titleSort.locked", this::isTitleSortLocked);
    }

    @Override
    protected void clear() {
        super.clear();
        librarySectionTitle = null;
        librarySectionID = null;
        librarySectionKey = null;
        titleSort = null;
    }

    protected void update(BaseItem source) {
        super.update(source);
        if (source instanceof PlexSectionItem sectionItem) {
            librarySectionTitle = sectionItem.librarySectionTitle;
            librarySectionID = sectionItem.librarySectionID;
            librarySectionKey = sectionItem.librarySectionKey;
            titleSort = sectionItem.titleSort;
        } else
            throw new ClassCastException("Cannot cast item to PlexSectionItem");
    }

    public S section() {
        if (librarySectionID != null)
            return (S) server().library().section(librarySectionID);
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
        fetchDetailedIfNullOrEmpty(librarySectionTitle);
        return librarySectionTitle;
    }

    public Integer getLibrarySectionID() {
        fetchDetailedIfNullOrEmpty(librarySectionID);
        return librarySectionID;
    }

    public String getLibrarySectionKey() {
        fetchDetailedIfNullOrEmpty(librarySectionKey);
        return librarySectionKey;
    }

    public String getTitleSort() {
        return titleSort;
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

    protected URI editUri() {
        return ratingKey();
    }

    public boolean isTitleLocked() {
        return isLocked("title");
    }

    public boolean isSummaryLocked() {
        return isLocked("summary");
    }

    public boolean isTitleSortLocked() {
        return isLocked("titleSort");
    }

    public void editTitle(String title) {
        titleEditor.setValue(title);
    }

    public void editTitleLock(boolean locked) {
        titleLockEditor.setValue(locked);
    }

    public void editSummary(String summary) {
        summaryEditor.setValue(summary);
    }

    public void editSummaryLock(boolean locked) {
        summaryLockEditor.setValue(locked);
    }

    public void editTitleSort(String titleSort) {
        titleSortEditor.setValue(titleSort);
    }

    public void editTitleSortLock(boolean locked) {
        titleSortLockEditor.setValue(locked);
    }

    protected List<FieldEditor<?>> fieldEditors() {
        return new ArrayList<>(Arrays.asList(new FieldEditor<?>[] {
                titleEditor, titleLockEditor, summaryEditor, summaryLockEditor, titleSortEditor, titleSortLockEditor
        }));
    }

    public void commitEdits() {
        new AttributeEditor(this).commit();
    }

}
