package kekolab.javaplex;

import java.util.List;
import java.util.Optional;

import kekolab.javaplex.model.PlexShowEditor;

public class ShowEditor extends SectionItemEditor implements PlexShowEditor {

    private FieldEditor<List<String>> genreEditor;
    private FieldEditor<Boolean> genreLockEditor;

    protected ShowEditor(Show source) {
        super(source);
        genreEditor = new TagListFieldEditor("genre", source::getGenres);
        genreLockEditor = new BooleanFieldEditor("genre.locked", source::getGenresLocked);

        addFieldEditor(genreEditor);
        addFieldEditor(genreLockEditor);
    }

    public void setGenres(List<String> values, Optional<Boolean> lock) {
        editField(genreEditor, values, genreLockEditor, lock);
    }

}
