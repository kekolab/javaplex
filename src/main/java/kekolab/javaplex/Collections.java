package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexCollection;
import kekolab.javaplex.model.PlexCollections;
import kekolab.javaplex.model.PlexDirectory;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexSection;;

class Collections<S extends PlexSection<?, ?>> implements PlexCollections<S> {
    private final Section<?, ?> section;

    Collections(Section<?, ?> section) {
        this.section = section;
    }

    @Override
    public List<PlexCollection<?, S>> list() {
        try {
            URI uri = new URIBuilder(section.key()).appendPath("collections").build();
            return new MetadataContainer<PlexCollection<?, S>, PlexDirectory>(uri, section.getServer()).getMetadata();
        } catch (URISyntaxException e) {
            throw new PlexException("Unknown exception. See attached stacktrace", e);
        }
    }

    
    <M extends PlexMediatag<S>> PlexCollection<M, S> add(M item, PlexCollection<M, S> target) {
        return (PlexCollection<M, S>) new GenericCollectionsHelper(target, section.getServer()).add(item);
    }

    
    <M extends PlexMediatag<S>> PlexCollection<M, S> remove(M item, PlexCollection<M, S> target) {

        try {
            URI uri = new URIBuilder(target.key()).appendPath(Integer.toString(item.getRatingKey()))
                    .addParameter("excludeAllLeaves", "1").build();
            return (PlexCollection<M, S>) new GenericCollectionsHelper(target, section.getServer()).remove(uri);
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }

    }

    @Override
    public void delete(PlexCollection<?, S> target) {
        MediaServer server = section.getServer();
        server.getClient().delete(target.ratingKey(), server.getToken(), Optional.empty());
    }

    
    <M extends PlexMediatag<S>> PlexCollection<M, S> create(String title, M item) {
        MediaServer server = section.getServer();
        URI uri;
        try {
            uri = new URIBuilder(server.getUri()).appendPathSegments("library", "collections")
                    .addParameter("type", Integer.toString(item.typeId())).addParameter("title", title)
                    .addParameter("uri", item.serverSchemeUri(server).toString())
                    .addParameter("sectionId", section.getKey())
                    .build();
        } catch (URISyntaxException e) {
            throw new PlexException("Unknown error. See attached stacktrace", e);
        }
        MetadataContainer<PlexCollection<M, S>, PlexDirectory> container = new MetadataContainer<>(uri, server);
        return server.getClient().post(server.getToken(), container).getMetadata().get(0);
    }
}
