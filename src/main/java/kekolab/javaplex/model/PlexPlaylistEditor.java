package kekolab.javaplex.model;

import java.util.Optional;

public interface PlexPlaylistEditor extends PlexMetadataEditor {
    void setSummary(Optional<String> summary);

    void setTitle(String title);
}