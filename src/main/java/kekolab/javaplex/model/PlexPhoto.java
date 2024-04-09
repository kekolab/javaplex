package kekolab.javaplex.model;

import java.util.Date;
import java.util.List;



public interface PlexPhoto extends PlexMediatag, PlexChild {
    int TYPE_ID = 13;
    String TYPE_DESCRIPTION = "photo";

    PlexFilterableString TITLE = () -> "title";
    PlexFilterableDate DATE_ADDED = () -> "addedAt";
    PlexFilterableDate DATE_TAKEN = () -> "originallyAvailableAt";
    PlexFilterableInteger RATING = () -> "userRating";
    PlexFilterableInteger FILE_SIZE = () -> "mediaSize";
    PlexFilterableTag TAG = () -> "tag";
    PlexFilterableBoolean TRASHED = () -> "trashed";
    PlexFilterableTag APERTURE = () -> "aperture";
    PlexFilterableTag EXPOSURE = () -> "exposure";
    PlexFilterableTag ISO = () -> "iso";
    PlexFilterableTag LENS = () -> "lens";
    PlexFilterableTag CAMERA_MAKE = () -> "make";
    PlexFilterableTag CAMERA_MODEL = () -> "model";
    PlexFilterableTag DEVICE = () -> "device";

    Integer getCreatedAtTZOffset();

    List<String> getCreatedAtAccuracy();

    Date getOriginallyAvailableAt();

    Integer getYear();

    List<PlexMedia> getMedia();

    PlexPhotoEditor editor();

    PlexPhotoSection section();

    PlexPhotoalbum parent();
}