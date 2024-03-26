package kekolab.javaplex.model;


import java.net.URI;
import java.util.List;

public interface PlexCollection<M extends PlexSectionItem<S>, S extends PlexSection<?, ?>> extends PlexSectionItem<S> {
    int TYPE_ID = 18;
    String TYPE_DESCRIPTION = "collection";
    
    Integer getChildCount();

    String getContentRating();

    Integer getIndex();

    Integer getMaxYear();

    Integer getMinYear();

    Integer getRatingCount();

    String getSubtype();

    List<M> children();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    default int typeId() {
        return TYPE_ID;
    }

    Boolean getContentRatingLocked();

    @Override
    PlexCollectionEditor editor();
}
