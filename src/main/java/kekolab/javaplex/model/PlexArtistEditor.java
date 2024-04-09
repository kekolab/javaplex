package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexArtistEditor extends PlexSectionItemEditor {

    void setCountries(List<String> countries, Optional<Boolean> lock);

    void setSimilars(List<String> values, Optional<Boolean> lock);

    void setMoods(List<String> values, Optional<Boolean> lock);

    void setStyles(List<String> values, Optional<Boolean> lock);

    void setGenres(List<String> values, Optional<Boolean> lock);

}