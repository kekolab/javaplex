package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexMovieEditor extends PlexVideoEditor {

    void setWriters(List<String> values, Optional<Boolean> lock);

    void setDirectors(List<String> values, Optional<Boolean> lock);

    void setCountries(List<String> countries, Optional<Boolean> lock);

    void setGenres(List<String> values, Optional<Boolean> lock);

    void setProducers(List<String> values, Optional<Boolean> lock);

}