package kekolab.javaplex.model;

import java.net.URI;

public interface PlexTag {

    Integer getCount();

    String getThumb();

    URI thumb();

    Integer getId();

    String getFilter();

    String getTag();

    String getPath();

    String getTagKey();

}