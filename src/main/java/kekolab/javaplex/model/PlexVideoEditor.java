package kekolab.javaplex.model;

import java.util.Optional;

public interface PlexVideoEditor extends PlexSectionItemEditor {

    void setContentRating(Optional<String> value, Optional<Boolean> lock);

}