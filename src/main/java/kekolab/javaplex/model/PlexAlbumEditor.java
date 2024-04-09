package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexAlbumEditor extends PlexSectionItemEditor {

    void setMoods(List<String> values, Optional<Boolean> lock);

    void setStyles(List<String> values, Optional<Boolean> lock);

    void setGenres(List<String> values, Optional<Boolean> lock);

}