package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;



public interface PlexCollection extends PlexSectionItem {

    int TYPE_ID = 18;
    String TYPE_DESCRIPTION = "collection";

    Integer getChildCount();

    String getContentRating();

    Integer getIndex();

    Integer getMaxYear();

    Integer getMinYear();

    Integer getRatingCount();

    String getSubtype();

    List<? extends PlexMediatag> children();

    URI ratingKey();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    int typeId();

    Boolean getContentRatingLocked();

    PlexCollectionEditor editor();

}