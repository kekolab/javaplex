package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;



public interface PlexArtist extends PlexMediatag, PlexGrandparent {
    int TYPE_ID = 8;
    String TYPE_DESCRIPTION = "artist";
    
    PlexFilterableString TITLE = () -> "artist.title";
    PlexFilterableInteger USER_RATING = () -> "artist.userRating";
    PlexFilterableTag GENRE = () -> "artist.genre";
    PlexFilterableTag COLLECTION = () -> "artist.collection";
    PlexFilterableTag COUNTRY = () -> "artist.country";
    PlexFilterableTag MOOD = () -> "artist.mood";
    PlexFilterableTag STYLE = () -> "artist.style";
    PlexFilterableDate DATE_ADDED = () -> "artist.addedAt";
    PlexFilterableDate LAST_PLAYED = () -> "artist.lastViewedAt";
    PlexFilterableBoolean UNMATCHED = () -> "artist.unmatched";

    List<PlexTag> getStyles();

    Integer getAlbumSort();

    List<PlexTag> getLocations();

    List<PlexTag> getCountries();

    List<PlexTag> getMoods();

    List<PlexTag> getSimilars();

    List<PlexTag> getGenres();

    Integer getChildCount();

    PlexMusicSection section();

    List<PlexAlbum> children();

    List<PlexTrack> grandchildren();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    Boolean getCountriesLocked();

    Boolean getGenresLocked();

    Boolean getSimilarsLocked();

    Boolean getMoodsLocked();

    Boolean getStylesLocked();

    int typeId();

    PlexArtistEditor editor();

}