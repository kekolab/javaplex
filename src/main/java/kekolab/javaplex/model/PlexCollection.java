package kekolab.javaplex.model;


import java.net.URI;
import java.util.List;

public interface PlexCollection<M extends PlexMediatag<S>, S extends PlexSection<?, ?>> extends PlexSectionItem<S> {
    int TYPE_ID = 18;
    String TYPE_DESCRIPTION = "collection";

    void add(M mediatag); // TODO Move in PlexCollections?

    Integer getChildCount();

    String getContentRating();

    Integer getIndex();

    Integer getMaxYear();

    Integer getMinYear();

    Integer getRatingCount();

    String getSubtype();

    List<M> children();

    void remove(M mediatag);

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    default int typeId() {
        return TYPE_ID;
    }

    boolean isContentRatingLocked();

    void editContentRating(String contentRating); // TODO Move to editor?

    void editContentRatingLock(boolean locked);// TODO Move to editor?
}
