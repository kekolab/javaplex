package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexMovieEditor extends PlexVideoEditor {
    void setCountries(List<String> countries, Optional<Boolean> lock);
    void setDirectors(List<String> directors, Optional<Boolean> lock);
    void setGenres(List<String> genres, Optional<Boolean> lock);
    void setProducers(List<String> producers, Optional<Boolean> lock);
    void setWriters(List<String> writers, Optional<Boolean> lock);
}