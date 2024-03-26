package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexTrackEditor extends PlexSectionItemEditor {
    void setMoods(List<String> moods, Optional<Boolean> lock);

}