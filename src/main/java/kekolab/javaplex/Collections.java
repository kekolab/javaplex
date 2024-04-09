package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexCollection;
import kekolab.javaplex.model.PlexCollections;
import kekolab.javaplex.model.PlexMediatag;

public class Collections implements PlexCollections {
    private final Section section;

    protected Collections(Section section) {
        this.section = section;
    }

    protected PlexCollection create(String title, PlexMediatag item) {
        MediaServer server = section.getServer();
        URI uri;
        try {
            uri = new URIBuilder(server.getUri()).appendPathSegments("library", "collections")
                    .addParameter("type", Integer.toString(item.typeId())).addParameter("title", title)
                    .addParameter("uri", GenericCollectionsHelper.uriParameter(section.getServer(), item).toString())
                    .addParameter("sectionId", section.getKey())
                    .build();
        } catch (URISyntaxException e) {
            throw new PlexException("Unknown error. See attached stacktrace", e);
        }
        MetadataContainer<PlexCollection, Directory> container = new MetadataContainer<>(uri, server);
        return server.getClient().post(server.getToken(), container).getMetadata().get(0);
    }

    protected PlexCollection add(PlexCollection collection, PlexMediatag mediatag) {
        return (PlexCollection) new GenericCollectionsHelper(collection, section.getServer()).add(mediatag);
    }

    protected PlexCollection remove(PlexCollection target, PlexMediatag item) {
        try {
            URI uri = new URIBuilder(target.key()).appendPath(Integer.toString(item.getRatingKey()))
                    .addParameter("excludeAllLeaves", "1").build();
            return (PlexCollection) new GenericCollectionsHelper(target, section.getServer()).remove(uri);
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
    }

    public List<? extends PlexCollection> list() {
        try {
            URI uri = new URIBuilder(section.key()).appendPath("collections").build();
            return new MetadataContainer<Collection, Directory>(uri, section.getServer()).getMetadata();
        } catch (URISyntaxException e) {
            throw new PlexException("Unknown exception. See attached stacktrace", e);
        }
    }

    public void delete(PlexCollection target) {
        MediaServer server = section.getServer();
        server.getClient().delete(target.ratingKey(), server.getToken(), Optional.empty());
    }
}
