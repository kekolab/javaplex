package kekolab.javaplex.model;

import java.util.Optional;

public interface PlexSectionItemEditor extends PlexMetadataEditor {

    void setTitle(String value, Optional<Boolean> lock);

    void setSummary(Optional<String> value, Optional<Boolean> lock);

    void setTitleSort(Optional<String> value, Optional<Boolean> lock);

}