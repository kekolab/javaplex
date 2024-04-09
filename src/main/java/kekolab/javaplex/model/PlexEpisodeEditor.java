package kekolab.javaplex.model;

import java.util.List;
import java.util.Optional;

public interface PlexEpisodeEditor extends PlexVideoEditor {

    void setWriters(List<String> values, Optional<Boolean> lock);

    void setDirectors(List<String> values, Optional<Boolean> lock);

}