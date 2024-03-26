package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexEpisodeEditor extends PlexVideoEditor {
    void setDirectors(List<String> directors, Optional<Boolean> lock);
    void setWriters(List<String> writers, Optional<Boolean> lock);
}