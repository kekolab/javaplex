package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;



public interface PlexShow extends PlexMediatag, PlexGrandparent {
    int TYPE_ID = 2;
    String TYPE_DESCRIPTION = "show";

    PlexFilterableString TITLE = () -> "show.title";
    PlexFilterableString STUDIO = () -> "show.title";
    PlexFilterableTag NETWORK = () -> "show.network";
    PlexFilterableTag COUNTRY = () -> "show.country";
    PlexFilterableInteger RATING = () -> "show.userRating";
    PlexFilterableTag CONTENT_RATING = () -> "show.contentRating";
    PlexFilterableInteger YEAR = () -> "show.year";
    PlexFilterableInteger PLAYS = () -> "show.viewCount";
    PlexFilterableDate LAST_PLAYED = () -> "show.lastViewedAt";
    PlexFilterableTag GENRE = () -> "show.genre";
    PlexFilterableTag COLLECTION = () -> "show.collection";
    PlexFilterableTag DIRECTOR = () -> "show.director";
    PlexFilterableTag WRITER = () -> "show.writer";
    PlexFilterableTag PRODUCER = () -> "show.producer";
    PlexFilterableTag ACTOR = () -> "show.actor";
    PlexFilterableDate DATE_ADDED = () -> "show.addedAt";
    PlexFilterableBoolean UNMATCHED = () -> "show.unmatched";
    PlexFilterableBoolean UNPLAYED_EPISODES = () -> "show.unwatchedLeaves";
    PlexFilterableString LABEL = () -> "show.label";

    String getStudio();

    String getContentRating();

    Double getRating();

    Integer getYear();

    Long getDuration();

    Integer getLeafCount();

    Integer getViewedLeafCount();

    Integer getChildCount();

    List<PlexTag> getGenres();

    String getBanner();

    String getTheme();

    Date getOriginallyAvailableAt();

    List<PlexRole> getRoles();

    String getOriginalTitle();

    Double getAudienceRating();

    String getTagline();

    String getAudienceRatingImage();

    List<PlexTag> getCountries();

    List<PlexLocation> getLocations();

    List<PlexTag> getSimilars();

    List<PlexRating> getRatings();

    List<PlexSeason> children();

    List<PlexEpisode> grandchildren();

    URI banner();

    URI theme();

    PlexShowSection section();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    Boolean getGenresLocked();

    int typeId();

    PlexShowEditor editor();
}