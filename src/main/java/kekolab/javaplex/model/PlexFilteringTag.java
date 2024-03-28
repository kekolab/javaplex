package kekolab.javaplex.model;

import java.net.URI;

public interface PlexFilteringTag extends PlexDirectory {
    String getFastKey();
    URI fastKey();
    String getType();    
}
