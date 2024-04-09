package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;



public interface PlexTrack extends PlexMediatag, PlexGrandchild {
    int TYPE_ID = 10;
    String TYPE_DESCRIPTION = "track";

    PlexFilterableString TITLE = () -> "track.title";
    PlexFilterableTag MOOD = () -> "track.mood";
    PlexFilterableInteger PLAYS = () -> "track.viewCount";
    PlexFilterableDate LAST_PLAYED = () -> "track.lastViewedAt";
    PlexFilterableInteger SKIPS = () -> "track.skipCount";
    PlexFilterableDate LAST_SKIPPED = () -> "track.lastSkippedAt";
    PlexFilterableInteger RATING = () -> "track.userRating";
    PlexFilterableDate LAST_RATED = () -> "track.lastSkippedAt";
    PlexFilterableDate DATE_ADDED = () -> "track.addedAt";
    PlexFilterableInteger FILE_SIZE = () -> "track.mediaSize";
    PlexFilterableInteger BITRATE = () -> "track.mediaBitrate";
    PlexFilterableBoolean TRASHED = () -> "track.trash";
    PlexFilterableTag SOURCE = () -> "artist.SOURCE";
    PlexFilterableTag COLLECTION = () -> "artist.collection";
    PlexFilterableTag COUNTRY = () -> "artist.country";

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    List<PlexMedia> getMedia();

    Integer getRatingCount();

    List<PlexTag> getMoods();

    List<String> getCreatedAtAccuracy();

    String getCreatedAtTZOffset();

    String getOriginalTitle();

    Long getDuration();

    Date getOriginallyAvailableAt();

    URI parentTheme();

    URI parentThumb();

    Boolean getMoodsLocked();

    int typeId();

    PlexTrackEditor editor();

    PlexAlbum parent();

    PlexArtist grandparent();

    PlexMusicSection section();

}