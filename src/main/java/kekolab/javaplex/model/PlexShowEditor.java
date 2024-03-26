package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexShowEditor extends PlexSectionItemEditor {
    void setGenres(List<String> genres, Optional<Boolean> lock);

}