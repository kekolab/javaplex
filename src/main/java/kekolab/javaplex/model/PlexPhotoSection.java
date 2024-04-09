package kekolab.javaplex.model;

import java.util.List;

public interface PlexPhotoSection extends PlexSection {

    String TYPE_DESCRIPTION = "photo";

    Boolean getEnableAutoPhotoTags();

    PlexSectionQueryBuilder<PlexPhotoalbum> all();

    List<PlexPhotoalbum> recentlyAdded();

    List<PlexPhotoSectionSecondaryDirectory> byYear();

    List<PlexPhotoSectionSecondaryDirectory> byCameraMake();

    List<PlexPhotoSectionSecondaryDirectory> byCameraModel();

    List<PlexPhotoSectionSecondaryDirectory> byAperture();

    List<PlexPhotoSectionSecondaryDirectory> byShutterSpeed();

    List<PlexPhotoSectionSecondaryDirectory> byISO();

    List<PlexPhotoSectionSecondaryDirectory> byLens();

    List<PlexPhotoSectionSecondaryDirectory> byTag();

}