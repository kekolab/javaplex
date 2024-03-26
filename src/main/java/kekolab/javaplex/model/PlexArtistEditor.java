package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexArtistEditor extends PlexSectionItemEditor {
    void setCountries(List<String> countries, Optional<Boolean> lock);
    void setGenres(List<String> genres, Optional<Boolean> lock);
    void setMoods(List<String> moods, Optional<Boolean> lock);
    void setSimilars(List<String> similars, Optional<Boolean> lock);
    void setStyles(List<String> styles, Optional<Boolean> lock);
}