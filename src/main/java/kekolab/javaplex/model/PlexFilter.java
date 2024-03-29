package kekolab.javaplex.model;

import java.net.URI;

public interface PlexFilter extends PlexDirectory {
    String getFastKey();

    URI fastKey();

    String getType();

}
