package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

public interface PlexPlaylist<M extends PlexMediatag<?>> extends PlexMetadata {
    String TYPE_DESCRIPTION = "playlist";

    Boolean getSmart();

    String getPlaylistType();

    Date getLastViewedAt();

    Long getDuration();

    Integer getLeafCount();

    String getComposite();

    URI composite();

    List<M> children();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    void editTitle(String title); // TODO Move to editor?

    void editSummary(String summary);// TODO Move to editor?

    void commitEdits();// TODO Move to editor?
}
