package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

public interface PlexSection extends PlexDirectory {

    String getArt();

    URI art();

    String getComposite();

    URI composite();

    String getThumb();

    URI thumb();

    Boolean getAllowSync();

    Boolean getFilters();

    String getType();

    String getAgent();

    String getScanner();

    String getLanguage();

    String getUuid();

    Date getUpdatedAt();

    Date getCreatedAt();

    Date getScannedAt();

    Boolean getContent();

    Boolean getDirectory();

    Long getContentChangedAt();

    List<PlexLocation> getLocations();

    Boolean getRefreshing();

    Integer getHidden();

    PlexSectionQueryBuilder<?> all();

    List<? extends PlexMediatag> recentlyAdded();

    URI key();

}