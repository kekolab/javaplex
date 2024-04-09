package kekolab.javaplex;

import java.util.List;
import java.util.Optional;

import kekolab.javaplex.model.PlexMovieEditor;

public class MovieEditor extends VideoEditor implements PlexMovieEditor {
    private FieldEditor<List<String>> countryEditor;
    private FieldEditor<Boolean> countryLockEditor;
    private FieldEditor<List<String>> directorEditor;
    private FieldEditor<Boolean> directorLockEditor;
    private FieldEditor<List<String>> genreEditor;
    private FieldEditor<Boolean> genreLockEditor;
    private FieldEditor<List<String>> writerEditor;
    private FieldEditor<Boolean> writerLockEditor;
    private FieldEditor<List<String>> producerEditor;
    private FieldEditor<Boolean> producerLockEditor;

    protected MovieEditor(Movie source) {
        super(source);

        countryEditor = new TagListFieldEditor("country", source::getCountries);
        countryLockEditor = new BooleanFieldEditor("country.locked", source::getCountriesLocked);
        directorEditor = new TagListFieldEditor("director", source::getDirectors);
        directorLockEditor = new BooleanFieldEditor("director.locked", source::getDirectorsLocked);
        genreEditor = new TagListFieldEditor("genre", source::getGenres);
        genreLockEditor = new BooleanFieldEditor("genre.locked", source::getGenresLocked);
        writerEditor = new TagListFieldEditor("writer", source::getWriters);
        writerLockEditor = new BooleanFieldEditor("writer.locked", source::getWritersLocked);
        producerEditor = new TagListFieldEditor("producer", source::getProducers);
        producerLockEditor = new BooleanFieldEditor("country.locked", source::getProducersLocked);

        addFieldEditor(countryEditor);
        addFieldEditor(countryLockEditor);
        addFieldEditor(directorEditor);
        addFieldEditor(directorLockEditor);
        addFieldEditor(genreEditor);
        addFieldEditor(genreLockEditor);
        addFieldEditor(writerEditor);
        addFieldEditor(writerLockEditor);
        addFieldEditor(producerEditor);
        addFieldEditor(producerLockEditor);
    }

    public void setWriters(List<String> values, Optional<Boolean> lock) {
        editField(writerEditor, values, writerLockEditor, lock);
    }

    public void setDirectors(List<String> values, Optional<Boolean> lock) {
        editField(directorEditor, values, directorLockEditor, lock);
    }

    public void setCountries(List<String> countries, Optional<Boolean> lock) {
        editField(countryEditor, countries, countryLockEditor, lock);
    }

    public void setGenres(List<String> values, Optional<Boolean> lock) {
        editField(genreEditor, values, genreLockEditor, lock);
    }

    public void setProducers(List<String> values, Optional<Boolean> lock) {
        editField(producerEditor, values, producerLockEditor, lock);
    }

}
