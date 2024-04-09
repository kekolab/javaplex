package kekolab.javaplex.model;

import java.net.URI;

public interface PlexUser {

    String getId();

    String getTitle();

    String getThumb();

    URI thumb();

}