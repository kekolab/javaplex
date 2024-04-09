package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;



public interface PlexMovie extends PlexVideo {
    int TYPE_ID = 1;
    String TYPE_DESCRIPTION = "movie";

    PlexFilterableString TITLE = () -> "title";
    PlexFilterableString STUDIO = () -> "studio";
    PlexFilterableTag CONTENT_RATING = () -> "contentRating";
    PlexFilterableInteger YEAR = () -> "year";
    PlexFilterableInteger DECADE = () -> "decade";
    PlexFilterableBoolean UNMATCHED = () -> "unmatched";
    PlexFilterableBoolean DUPLICATED = () -> "duplicated";
    PlexFilterableTag GENRE = () -> "genre";
    PlexFilterableTag COLLECTION = () -> "collection";
    PlexFilterableTag DIRECTOR = () -> "director";
    PlexFilterableTag WRITER = () -> "writer";
    PlexFilterableTag PRODUCER = () -> "producer";
    PlexFilterableTag ACTOR = () -> "actor";
    PlexFilterableTag COUNTRY = () -> "country";
    PlexFilterableDate DATE_ADDED = () -> "addedAt";
    PlexFilterableInteger PLAYS = () -> "viewCount";
    PlexFilterableDate LAST_PLAYED = () -> "lastViewedAt";
    PlexFilterableBoolean UNPLAYED = () -> "unwatched";
    PlexFilterableInteger RESOLUTION = () -> "resolution";
    PlexFilterableBoolean HDR = () -> "hdr";
    PlexFilterableInteger FILE_SIZE = () -> "mediaSize";
    PlexFilterableInteger BITRATE = () -> "mediaBitrate";
    PlexFilterableTag SUBTITLE_LANGUAGE = () -> "subtitleLanguage";
    PlexFilterableTag AUDIO_LANGUAGE = () -> "audioLanguage";
    PlexFilterableBoolean IN_PROGRESS = () -> "inProgress";
    PlexFilterableBoolean TRASHED = () -> "trash";
    PlexFilterableTag LABEL = () -> "label";

    Double getRating();

    Double getAudienceRating();

    String getTagline();

    String getAudienceRatingImage();

    Integer getHasPremiumExtras();

    Integer getHasPremiumPrimaryExtra();

    String getRatingImage();

    List<PlexTag> getGenres();

    List<PlexTag> getDirectors();

    List<PlexTag> getWriters();

    List<PlexTag> getProducers();

    List<PlexTag> getCountries();

    List<PlexRole> getRoles();

    List<PlexTag> getSimilars();

    String getChapterSource();

    List<PlexRating> getRatings();

    String getSubtype();

    List<String> getCreatedAtAccuracy();

    Integer getCreatedAtTZOffset();

    PlexMovieSection section();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    Boolean getCountriesLocked();

    Boolean getDirectorsLocked();

    Boolean getGenresLocked();

    Boolean getWritersLocked();

    Boolean getProducersLocked();

    PlexMovieEditor editor();

    int typeId();

}