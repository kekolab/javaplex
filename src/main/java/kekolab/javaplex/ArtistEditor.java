package kekolab.javaplex;

import java.util.List;
import java.util.Optional;

import kekolab.javaplex.model.PlexArtistEditor;

public class ArtistEditor extends SectionItemEditor implements PlexArtistEditor {
    private FieldEditor<List<String>> countryEditor;
    private FieldEditor<Boolean> countryLockEditor;
    private FieldEditor<List<String>> genreEditor;
    private FieldEditor<Boolean> genreLockEditor;
    private FieldEditor<List<String>> moodEditor;
    private FieldEditor<Boolean> moodLockEditor;
    private FieldEditor<List<String>> similarEditor;
    private FieldEditor<Boolean> similarLockEditor;
    private FieldEditor<List<String>> styleEditor;
    private FieldEditor<Boolean> styleLockEditor;

    protected ArtistEditor(Artist source) {
        super(source);

        countryEditor = new TagListFieldEditor("country", source::getCountries);
        countryLockEditor = new BooleanFieldEditor("country.locked", source::getCountriesLocked);
        genreEditor = new TagListFieldEditor("genre", source::getGenres);
        genreLockEditor = new BooleanFieldEditor("genre.locked", source::getGenresLocked);
        moodEditor = new TagListFieldEditor("mood", source::getMoods);
        moodLockEditor = new BooleanFieldEditor("mood.locked", source::getMoodsLocked);
        similarEditor = new TagListFieldEditor("similar", source::getSimilars);
        similarLockEditor = new BooleanFieldEditor("similar.locked", source::getSimilarsLocked);
        styleEditor = new TagListFieldEditor("style", source::getStyles);
        styleLockEditor = new BooleanFieldEditor("style.locked", source::getStylesLocked);

        addFieldEditor(countryEditor);
        addFieldEditor(countryLockEditor);
        addFieldEditor(genreEditor);
        addFieldEditor(genreLockEditor);
        addFieldEditor(moodEditor);
        addFieldEditor(moodLockEditor);
        addFieldEditor(similarEditor);
        addFieldEditor(similarLockEditor);
        addFieldEditor(styleEditor);
        addFieldEditor(styleLockEditor);
    }

    public void setCountries(List<String> countries, Optional<Boolean> lock) {
        editField(countryEditor, countries, countryLockEditor, lock);
    }

    public void setSimilars(List<String> values, Optional<Boolean> lock) {
        editField(similarEditor, values, similarLockEditor, lock);
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
