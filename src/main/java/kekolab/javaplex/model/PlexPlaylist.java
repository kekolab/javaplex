package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

public interface PlexPlaylist extends PlexMetadata {

    String TYPE_DESCRIPTION = "playlist";

    Boolean getSmart();

    String getPlaylistType();

    Date getLastViewedAt();

    Long getDuration();

    Integer getLeafCount();

    String getComposite();

    URI composite();

    List<? extends PlexMediatag> children();

    URI ratingKey();

    String getArt();

    String getThumb();

    URI thumb();

    PlexPlaylistEditor editor();

}