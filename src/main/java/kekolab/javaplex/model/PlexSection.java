package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

// TODO Should All and RecentlyAdded extend PlexMediatag or PlexSectionItem?
public interface PlexSection<All extends PlexMediatag<?>, RecentlyAdded extends PlexMediatag<?>> extends PlexDirectory {
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

    List<All> all();

    List<RecentlyAdded> recentlyAdded();

    List<PlexCollection<?, ?>> collections(); // TODO PlexCollections

    <M extends PlexMediatag<S>, S extends PlexSection<?, ?>> PlexCollection<M, S> createCollection(String title, // TODO Move in PlexCollections
            M item);
}