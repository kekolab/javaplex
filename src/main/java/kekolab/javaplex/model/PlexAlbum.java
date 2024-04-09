package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;



public interface PlexAlbum extends PlexMediatag, PlexParent, PlexChild {
    int TYPE_ID = 9;
    String TYPE_DESCRIPTION = "album";

    PlexFilterableString TITLE = () -> "album.title";
    PlexFilterableInteger YEAR = () -> "album.year";
    PlexFilterableInteger DECADE = () -> "album.decade";
    PlexFilterableTag GENRE = () -> "album.genre";
    PlexFilterableInteger PLAYS = () -> "album.viewCount";
    PlexFilterableDate LAST_PLAYED = () -> "album.lastViewedAt";
    PlexFilterableInteger RATING = () -> "album.userRating";
    PlexFilterableInteger CRITIC_RATING = () -> "album.rating";
    PlexFilterableString RECORD_LABEL = () -> "album.studio";
    PlexFilterableTag MOOD = () -> "album.mood";
    PlexFilterableTag STYLE = () -> "album.style";
    PlexFilterableTag FORMAT = () -> "album.format";
    PlexFilterableTag TYPE = () -> "album.subformat";
    PlexFilterableTag COLLECTION = () -> "album.collection";
    PlexFilterableDate DATE_ADDED = () -> "album.addedAt";
    PlexFilterableDate DATE_RELEASED = () -> "album.originallyAvailableAt";
    PlexFilterableBoolean UNMATCHED = () -> "album.unmatched";
    PlexFilterableTag SOURCE = () -> "album.source";
    PlexFilterableTag LABEL = () -> "album.label";

    Double getRating();

    List<PlexTag> getStyles();

    List<PlexTag> getFormats();

    Integer getLoudnessAnalysisVersion();

    List<PlexTag> getSubformats();

    List<PlexTag> getDirectors();

    Integer getLeafCount();

    List<PlexTag> getMoods();

    String getStudio();

    Integer getViewedLeafCount();

    List<PlexTag> getGenres();

    Date getOriginallyAvailableAt();

    Integer getYear();

    PlexMusicSection section();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    Boolean getGenresLocked();

    Boolean getMoodsLocked();

    Boolean getStylesLocked();

    PlexAlbumEditor editor();

    List<PlexTrack> children();

    PlexArtist parent();

    
}