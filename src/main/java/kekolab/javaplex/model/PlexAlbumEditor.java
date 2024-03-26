package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexAlbumEditor extends PlexSectionItemEditor {
    void setGenres(List<String> genres, Optional<Boolean> lock);
    void setMoods(List<String> moods, Optional<Boolean> lock);
    void setStyles(List<String> styles, Optional<Boolean> lock);
}