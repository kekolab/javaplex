package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;



public interface PlexEpisode extends PlexVideo, PlexGrandchild {
    int TYPE_ID = 4;
    String TYPE_DESCRIPTION = "episode";
    
    PlexFilterableString TITLE = () -> "episode.title";
    PlexFilterableDate DATE_ADDED = () -> "episode.addedAt";
    PlexFilterableDate AIR_DATE = () -> "episode.originallyAvailableAt";
    PlexFilterableInteger YEAR = () -> "episode.year";
    PlexFilterableInteger RATING = () -> "episode.userRating";
    PlexFilterableInteger PLAYS = () -> "episode.viewCount";
    PlexFilterableDate LAST_PLAYED = () -> "episode.lastViewedAt";
    PlexFilterableBoolean UNWATCHED = () -> "episode.unwatched";
    PlexFilterableBoolean IN_PROGRESS = () -> "episode.inProgress";
    PlexFilterableBoolean DUPLICATED = () -> "episode.duplicate";
    PlexFilterableBoolean HDR = () -> "episode.hdr";
    PlexFilterableTag RESOLUTION = () -> "episode.resolution";
    PlexFilterableInteger FILE_SIZE = () -> "episode.mediaSize";
    PlexFilterableInteger BITRATE = () -> "episode.mediaBitrate";
    PlexFilterableTag SUBTITLE_LANGUAGE = () -> "episode.subtitleLanguage";
    PlexFilterableTag AUDIO_LANGUAGE = () -> "episode.audioLanguage";
    PlexFilterableBoolean TRASHED = () -> "episode.trash";
    PlexFilterableBoolean UNMATCHED = () -> "episode.unmatched";

    PlexShowSection section();

    PlexSeason parent();

    PlexShow grandparent();

    String getParentGuid();

    Integer getParentIndex();

    String getParentKey();

    String getGrandparentArt();

    URI parentKey();

    URI grandparentArt();

    Integer getParentRatingKey();

    String getGrandparentGuid();

    URI parentRatingKey();

    String getGrandparentKey();

    String getParentStudio();

    URI grandparentKey();

    String getParentTheme();

    Integer getGrandparentRatingKey();

    URI parentTheme();

    URI grandparentRatingKey();

    String getParentThumb();

    String getGrandparentTheme();

    URI parentThumb();

    String getParentTitle();

    URI grandparentTheme();

    Integer getParentYear();

    String getGrandparentThumb();

    URI grandparentThumb();

    String getGrandparentTitle();

    Integer getGrandparentYear();

    List<PlexTag> getWriters();

    Double getRating();

    Double getAudienceRating();

    String getAudienceRatingImage();

    List<PlexTag> getDirectors();

    List<PlexRole> getRoles();

    String getChapterSource();

    List<PlexTag> getProducers();

    List<PlexRating> getRatings();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    Boolean getWritersLocked();

    Boolean getDirectorsLocked();

    PlexEpisodeEditor editor();

    int typeId();

}