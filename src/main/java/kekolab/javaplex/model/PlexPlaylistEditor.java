package kekolab.javaplex.model;

import java.util.Optional;

public interface PlexPlaylistEditor extends PlexMetadataEditor {

    void setTitle(String value);

    void setSummary(Optional<String> value);

}