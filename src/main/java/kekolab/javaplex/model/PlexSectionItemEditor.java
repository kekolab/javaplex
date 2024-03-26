package kekolab.javaplex.model;

import java.util.Optional;

public interface PlexSectionItemEditor extends PlexMetadataEditor {
    void setSummary(Optional<String> summary, Optional<Boolean> lock);

    void setTitle(String title, Optional<Boolean> lock);

    void setTitleSort(Optional<String> titleSort, Optional<Boolean> lock);
}