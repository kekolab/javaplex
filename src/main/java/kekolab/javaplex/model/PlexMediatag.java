package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

public interface PlexMediatag extends PlexSectionItem {

    Boolean getAllowSync();

    Double getUserRating();

    Date getLastViewedAt();

    Long getViewOffset();

    Integer getSkipCount();

    Integer getIndex();

    Integer getPlaylistItemID();

    List<PlexTag> getCollections();

    List<PlexGuid> getGuids();

    Date getLastRatedAt();

    URI ratingKey();

    PlexUser getUser();

    PlexPlayer getPlayer();

    PlexSession getSession();

    PlexTranscodeSession getTranscodeSession();

    Integer getSessionKey();

}