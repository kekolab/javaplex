package kekolab.javaplex;

import java.util.List;
import java.util.Optional;

import kekolab.javaplex.model.PlexEpisodeEditor;

class EpisodeEditor extends VideoEditor implements PlexEpisodeEditor {
    private FieldEditor<List<String>> writerEditor;
    private FieldEditor<Boolean> writerLockEditor;
    private FieldEditor<List<String>> directorEditor;
    private FieldEditor<Boolean> directorLockEditor;

    EpisodeEditor(Episode source) {
        super(source);

        writerEditor = new TagListFieldEditor("writer", source::getWriters);
        writerLockEditor = new BooleanFieldEditor("writer.locked", source::getWritersLocked);
        directorEditor = new TagListFieldEditor("director", source::getDirectors);
        directorLockEditor = new BooleanFieldEditor("director.locked", source::getDirectorsLocked);

        addFieldEditor(writerEditor);
        addFieldEditor(writerLockEditor);
        addFieldEditor(directorEditor);
        addFieldEditor(directorLockEditor);
    }

    @Override
    public void setWriters(List<String> values, Optional<Boolean> lock) {
        editField(writerEditor, values, writerLockEditor, lock);
    }

    @Override
    public void setDirectors(List<String> values, Optional<Boolean> lock) {
        editField(directorEditor, values, directorLockEditor, lock);
    }

}
