package kekolab.javaplex;

import java.util.Optional;

import kekolab.javaplex.model.PlexSectionItemEditor;

public class SectionItemEditor extends MetadataEditor implements PlexSectionItemEditor {

    private FieldEditor<String> titleEditor;
    private FieldEditor<Boolean> titleLockEditor;
    private FieldEditor<String> summaryEditor;
    private FieldEditor<Boolean> summaryLockEditor;
    private FieldEditor<String> titleSortEditor;
    private FieldEditor<Boolean> titleSortLockEditor;

    protected SectionItemEditor(SectionItem source) {
        super(source, source.ratingKey());

        titleEditor = new StringFieldEditor("title.value", source::getTitle, false);
        titleLockEditor = new BooleanFieldEditor("title.locked", source::getTitleLocked);
        summaryEditor = new StringFieldEditor("summary.value", source::getSummary, true);
        summaryLockEditor = new BooleanFieldEditor("summary.locked", source::getSummaryLocked);
        titleSortEditor = new StringFieldEditor("titleSort.value", source::getTitleSort, true);
        titleSortLockEditor = new BooleanFieldEditor("titleSort.locked", source::getTitleSortLocked);

        addFieldEditor(titleEditor);
        addFieldEditor(titleLockEditor);
        addFieldEditor(summaryEditor);
        addFieldEditor(summaryLockEditor);
        addFieldEditor(titleSortEditor);
        addFieldEditor(titleSortLockEditor);
    }

    <T> void editField(FieldEditor<T> editor, T value, FieldEditor<Boolean> lockEditor, Optional<Boolean> lock) {
        editor.setValue(value);
        if (lock.isPresent())
            lockEditor.setValue(lock.get());
    }

    public void setTitle(String value, Optional<Boolean> lock) {
        editField(titleEditor, value, titleLockEditor, lock);
    }

    public void setSummary(Optional<String> value, Optional<Boolean> lock) {
        editField(summaryEditor, value.orElse(null), summaryLockEditor, lock);
    }

    public void setTitleSort(Optional<String> value, Optional<Boolean> lock) {
        editField(titleSortEditor, value.orElse(null), titleSortLockEditor, lock);
    }
}
