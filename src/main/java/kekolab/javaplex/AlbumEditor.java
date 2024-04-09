package kekolab.javaplex;

import java.util.List;
import java.util.Optional;

import kekolab.javaplex.model.PlexAlbumEditor;

public class AlbumEditor extends SectionItemEditor implements PlexAlbumEditor {
    private FieldEditor<List<String>> genreEditor;
    private FieldEditor<Boolean> genreLockEditor;
    private FieldEditor<List<String>> moodEditor;
    private FieldEditor<Boolean> moodLockEditor;
    private FieldEditor<List<String>> styleEditor;
    private FieldEditor<Boolean> styleLockEditor;

    protected AlbumEditor(Album source) {
        super(source);

        genreEditor = new TagListFieldEditor("genre", source::getGenres);
        genreLockEditor = new BooleanFieldEditor("genre.locked", source::getGenresLocked);
        moodEditor = new TagListFieldEditor("mood", source::getMoods);
        moodLockEditor = new BooleanFieldEditor("mood.locked", source::getMoodsLocked);
        styleEditor = new TagListFieldEditor("style", source::getStyles);
        styleLockEditor = new BooleanFieldEditor("style.locked", source::getStylesLocked);

        addFieldEditor(genreEditor);
        addFieldEditor(genreLockEditor);
        addFieldEditor(moodEditor);
        addFieldEditor(moodLockEditor);
        addFieldEditor(styleEditor);
        addFieldEditor(styleLockEditor);

    }

    public void setMoods(List<String> values, Optional<Boolean> lock) {
        editField(moodEditor, values, moodLockEditor, lock);
    }

    public void setStyles(List<String> values, Optional<Boolean> lock) {
        editField(styleEditor, values, styleLockEditor, lock);
    }

    public void setGenres(List<String> values, Optional<Boolean> lock) {
        editField(genreEditor, values, genreLockEditor, lock);
    }

}
