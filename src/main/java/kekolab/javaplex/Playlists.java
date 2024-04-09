package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexAudioPlaylist;
import kekolab.javaplex.model.PlexClassicPlaylist;
import kekolab.javaplex.model.PlexClip;
import kekolab.javaplex.model.PlexDirectory;
import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieSection;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexPhoto;
import kekolab.javaplex.model.PlexPhotoPlaylist;
import kekolab.javaplex.model.PlexPhotoalbum;
import kekolab.javaplex.model.PlexPlaylist;
import kekolab.javaplex.model.PlexPlaylists;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexSection;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowSection;
import kekolab.javaplex.model.PlexSmartPlaylist;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexVideo;
import kekolab.javaplex.model.PlexVideoPlaylist;

public class Playlists implements PlexPlaylists {
    private final MediaServer server;

    protected Playlists(MediaServer server) {
        this.server = server;
    }

    @Override
    public List<? extends Playlist> list() {
        URI uri;
        try {
            uri = new URIBuilder(server.getUri()).appendPath("playlists").build();
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
        return new MetadataContainer<Playlist, Directory>(uri, server).getMetadata();
    }

    @Override
    public void delete(PlexPlaylist target) {
        server.getClient().delete(target.ratingKey(), server.getToken(), Optional.empty());
    }

    @Override
    public PlexSmartPlaylist createSmart(String title, PlexSection section, PlexFilter filter) {
        String type = playlistTypeFromPlexSection(section);
        return (PlexSmartPlaylist) create(buildCreationUri(title, type, section, filter, true));
    }

    @Override
    public PlexSmartPlaylist createSmart(String title, PlexSection section, PlexFilter filter, String sort) {
        String type = playlistTypeFromPlexSection(section);
        return (PlexSmartPlaylist) create(buildCreationUri(title, type, section, filter, true, sort));
    }

    @Override
    public PlexClassicPlaylist create(String title, PlexMediatag tag) {
        String type = playlistTypeFromPlexSection(tag.section());
        URI uri;
        try {
            uri = new URIBuilder(server.getUri()).appendPath("playlists").addParameter("title", title)
                    .addParameter("type", type)
                    .addParameter("uri", GenericCollectionsHelper.uriParameter(server, tag).toString()).build();
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }

        PlexHTTPClient client = server.getClient();
        Optional<String> token = server.getToken();
        MetadataContainer<PlexClassicPlaylist, Directory> pmmc = new MetadataContainer<>(uri, server);
        return client.post(token, pmmc).getMetadata().get(0);
    }

    @Override
    public PlexClassicPlaylist create(String title, PlexSection section, PlexFilter filter) {
        String type = playlistTypeFromPlexSection(section);
        return (PlexClassicPlaylist) create(buildCreationUri(title, type, section, filter, false));
    }

    @Override
    public PlexClassicPlaylist create(String title, PlexSection section, PlexFilter filter, String sort) {
        String type = playlistTypeFromPlexSection(section);
        return (PlexClassicPlaylist) create(
                buildCreationUri(title, type, section, filter, false, sort));
    }

    @Override
    public PlexClassicPlaylist add(PlexClassicPlaylist playlist, PlexMediatag mediatag) {
        if (playlist instanceof PlexAudioPlaylist
                && !(mediatag instanceof PlexArtist || mediatag instanceof PlexAlbum || mediatag instanceof PlexTrack))
            throw new PlexException("Only PlexArtist, PlexAlbum or PlexTrack can be added to a PlexAudioPlaylist");
        if (playlist instanceof PlexVideo && !(mediatag instanceof PlexMovie || mediatag instanceof PlexShow
                || mediatag instanceof PlexSeason || mediatag instanceof PlexEpisode))
            throw new PlexException(
                    "Only PlexMovie, PlexShow, PlexSeason or PlexEpisode can be added to a PlexVideooPlaylist");
        if (playlist instanceof PlexPhotoPlaylist
                && !(mediatag instanceof PlexPhotoalbum || mediatag instanceof PlexPhoto
                        || mediatag instanceof PlexClip))
            throw new PlexException("Only PlexPhotoalbum, PlexPhoto or PlexClip can be added to a PlexPhotoPlaylist");
        return (PlexClassicPlaylist) new GenericCollectionsHelper(playlist, server).add(mediatag);
    }

    @Override
    public PlexClassicPlaylist remove(PlexClassicPlaylist playlist, PlexMediatag item) {
        return playlist.children().stream()
                .filter(child -> child.getRatingKey().equals(item.getRatingKey())).map(PlexMediatag::getPlaylistItemID)
                .findAny()
                .map(itemId -> {
                    try {
                        URI uri = new URIBuilder(playlist.key()).appendPath(Integer.toString(itemId)).build();
                        return (PlexClassicPlaylist) new GenericCollectionsHelper(playlist, server).remove(uri);
                    } catch (URISyntaxException e) {
                        throw new PlexException("Unknown error. Please see attache stacktrace", e);
                    }
                }).orElse(playlist);
    }

    protected PlexMediaServer getServer() {
        return server;
    }

    private URI buildCreationUri(String title, String type, PlexSection section, PlexFilter filter,
            boolean smart) {
        URIBuilder uriBuilder = new URIBuilder(server.getUri()).appendPath("playlists").addParameter("title", title)
                .addParameter("type", type)
                .setParameter("uri", GenericCollectionsHelper.uriParameter(server, section, filter).toString());
        if (smart)
            uriBuilder.addParameter("smart", Integer.toString(1));
        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
    }

    private URI buildCreationUri(String title, String type, PlexSection section, PlexFilter filter,
            boolean smart, String sort) {
        try {
            return new URIBuilder(buildCreationUri(title, type, section, filter, smart))
                    .setParameter("uri",
                            GenericCollectionsHelper.uriParameter(server, section, filter, sort).toString())
                    .build();
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
    }

    private PlexPlaylist create(URI uri) {
        PlexHTTPClient client = server.getClient();
        Optional<String> token = server.getToken();
        MetadataContainer<PlexSmartPlaylist, PlexDirectory> pmmc = new MetadataContainer<>(uri, server);
        return client.post(token, pmmc).getMetadata().get(0);
    }

    private String playlistTypeFromPlexSection(PlexSection section) {
        if (section instanceof PlexMusicSection)
            return PlexAudioPlaylist.SUBTYPE_DESCRIPTION;
        if (section instanceof PlexMovieSection || section instanceof PlexShowSection)
            return PlexVideoPlaylist.SUBTYPE_DESCRIPTION;
        if (section instanceof PhotoSection)
            return PlexPhotoPlaylist.SUBTYPE_DESCRIPTION;
        throw new PlexException("Cannot determine the smart playlist type");
    }

    @Override
    public PlexSmartPlaylist alter(PlexSmartPlaylist playlist, PlexFilter filter) {
        try {
            URI uri = new URIBuilder(playlist.key())
                    .addParameter("uri",
                            GenericCollectionsHelper.uriParameter(server, playlist.section(), filter).toString())
                    .build();
            MetadataContainer<PlexSmartPlaylist, PlexDirectory> mc = new MetadataContainer<>(uri, server);
            return server.getClient().put(server.getToken(), mc).getMetadata().get(0);
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
    }

    @Override
    public PlexSmartPlaylist alter(PlexSmartPlaylist playlist, PlexFilter filter, String sort) {
        try {
            URI uri = new URIBuilder(playlist.key())
                    .addParameter("uri",
                            GenericCollectionsHelper.uriParameter(server, playlist.section(), filter, sort)
                                    .toString())
                    .build();
            MetadataContainer<PlexSmartPlaylist, PlexDirectory> mc = new MetadataContainer<>(uri, server);
            return server.getClient().put(server.getToken(), mc).getMetadata().get(0);
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
    }
}
