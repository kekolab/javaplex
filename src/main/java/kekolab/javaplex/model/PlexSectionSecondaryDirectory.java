package kekolab.javaplex.model;

import java.net.URI;

public interface PlexSectionSecondaryDirectory extends PlexDirectory {

    String getFastKey();

    URI fastKey();

    String getType();

}