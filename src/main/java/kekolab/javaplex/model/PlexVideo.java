package kekolab.javaplex.model;

import java.util.Date;
import java.util.List;



public interface PlexVideo extends PlexMediatag {

    String getContentRating();

    Long getDuration();

    List<PlexMedia> getMedia();

    Date getOriginallyAvailableAt();

    String getOriginalTitle();

    String getStudio();

    Integer getYear();

    Boolean getContentRatingLocked();

    PlexVideoEditor editor();

}