package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

public class PlexSections {
    private final PlexMediaServer server;

    protected PlexSections(PlexMediaServer server) {
        this.server = server;
    }

    public List<? extends PlexSection> list() {
        try {
            URI uri = new URIBuilder(server.library().getUri()).appendPath("sections").build();
            return new PlexGeneralPurposeMediaContainer<PlexMetadata, PlexSection>(uri, server).getDirectories();
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
    }

    private <A extends PlexSection> List<A> listFilterAndCastSections(Class<A> cls) {
        return list().stream().filter(cls::isInstance).map(cls::cast).toList();
    }

    public List<PlexMusicSection> musicSections() {
        return listFilterAndCastSections(PlexMusicSection.class);
    }

    public List<PlexShowSection> showSections() {
        return listFilterAndCastSections(PlexShowSection.class);
    }

    public List<PlexMovieSection> movieSections() {
        return listFilterAndCastSections(PlexMovieSection.class);
    }

    public List<PlexPhotoSection> photoSections() {
        return listFilterAndCastSections(PlexPhotoSection.class);
    }

    public PlexSection byId(int id) {
        try {
            URI uri = new URIBuilder(server.library().getUri()).appendPath("sections").appendPath(Integer.toString(id))
                    .build();
            List<PlexSection> sections = new PlexGeneralPurposeMediaContainer<PlexMetadata, PlexSection>(uri, server)
                    .getDirectories();
            if (sections.size() == 0)
                throw new PlexException("Section with id " + id + " does not exist");
            return sections.get(0);
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
    }
}
