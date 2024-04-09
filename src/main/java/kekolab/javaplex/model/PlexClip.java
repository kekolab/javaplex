package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;

public interface PlexClip extends PlexVideo, PlexChild {
    int TYPE_ID = 14;
    String TYPE_DESCRIPTION = "clip";

    PlexPhotoalbum parent();

    String getParentGuid();

    Integer getParentIndex();

    String getParentKey();

    URI parentKey();

    Integer getParentRatingKey();

    URI parentRatingKey();

    String getParentStudio();

    String getParentTheme();

    URI parentTheme();

    String getParentThumb();

    URI parentThumb();

    String getParentTitle();

    Integer getParentYear();

    Integer getCreatedAtTZOffset();

    List<String> getCreatedAtAccuracy();

    String getSubtype();

    String getTagline();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    int typeId();

    PlexClipEditor editor();

    PlexPhotoSection section();

}