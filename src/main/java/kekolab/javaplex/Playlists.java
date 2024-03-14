package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexAudioPlaylist;
import kekolab.javaplex.model.PlexClip;
import kekolab.javaplex.model.PlexDirectory;
import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexPhoto;
import kekolab.javaplex.model.PlexPhotoPlaylist;
import kekolab.javaplex.model.PlexPhotoalbum;
import kekolab.javaplex.model.PlexPlaylist;
import kekolab.javaplex.model.PlexPlaylists;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexVideoPlaylist;

class Playlists implements PlexPlaylists {
    private final MediaServer server;

    Playlists(MediaServer server) {
        this.server = server;
    }

    public AudioPlaylist create(String title, PlexArtist artist) {
        return create(title, artist, AudioPlaylist.SUBTYPE_DESCRIPTION);
    }

    public AudioPlaylist create(String title, PlexAlbum album) {
        return create(title, album, AudioPlaylist.SUBTYPE_DESCRIPTION);
    }

    public AudioPlaylist create(String title, PlexTrack track) {
        return create(title, track, AudioPlaylist.SUBTYPE_DESCRIPTION);
    }

    public PhotoPlaylist create(String title, PlexPhotoalbum photoalbum) {
        return create(title, photoalbum, PhotoPlaylist.SUBTYPE_DESCRIPTION);
    }

    public PhotoPlaylist create(String title, PlexPhoto photo) {
        return create(title, photo, PhotoPlaylist.SUBTYPE_DESCRIPTION);
    }

    public PhotoPlaylist create(String title, PlexClip clip) {
        return create(title, clip, PhotoPlaylist.SUBTYPE_DESCRIPTION);
    }

    public VideoPlaylist create(String title, PlexShow show) {
        return create(title, show, VideoPlaylist.SUBTYPE_DESCRIPTION);
    }

    public VideoPlaylist create(String title, PlexSeason season) {
        return create(title, season, VideoPlaylist.SUBTYPE_DESCRIPTION);
    }

    public VideoPlaylist create(String title, PlexEpisode episode) {
        return create(title, episode, VideoPlaylist.SUBTYPE_DESCRIPTION);
    }

    public VideoPlaylist create(String title, PlexMovie movie) {
        return create(title, movie, VideoPlaylist.SUBTYPE_DESCRIPTION);
    }

    private <P extends Playlist<?>> P create(String title, PlexMediatag<?> mediatag, String type) {
        URI uri;
        try {
            uri = new URIBuilder(server.getUri()).appendPath("playlists").addParameter("title", title)
                    .addParameter("type", type)
                    .addParameter("uri", mediatag.serverSchemeUri(server).toString()).build();
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }

        PlexHTTPClient client = server.getClient();
        Optional<String> token = server.getToken();
        MetadataContainer<P, Directory> pmmc = new MetadataContainer<>(uri, server);
        return client.post(token, pmmc).getMetadata().get(0);
    }

    private PlexPlaylist<?> removeItemFromTarget(PlexMediatag<?> item, PlexPlaylist<?> target) {
        Optional<Integer> itemId = target.children().stream()
                .filter(child -> child.getRatingKey().equals(item.getRatingKey())).map(PlexMediatag::getPlaylistItemID)
                .findAny();
        if (itemId.isEmpty()) // The target playlist does not contain the item whose removal was requested
            return target;

        try {
            URI uri = new URIBuilder(target.key()).appendPath(Integer.toString(itemId.get())).build();
            return (PlexPlaylist<?>) new GenericCollectionsHelper(target, server).remove(uri);
        } catch (URISyntaxException e) {
            throw new PlexException("Unknown error. Please see attache stacktrace", e);
        }
    }

    @Override
    public List<PlexPlaylist<?>> list() {
        URI uri;
        try {
            uri = new URIBuilder(server.getUri()).appendPath("playlists").build();
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
        return new MetadataContainer<PlexPlaylist<?>, PlexDirectory>(uri, server)
                .getMetadata();
    }

    private PlexPlaylist<?> add(PlexMediatag<?> item, PlexPlaylist<?> target) {
        return (Playlist<?>) new GenericCollectionsHelper(target, server).add(item);
    }

    @Override
    public PlexAudioPlaylist add(PlexArtist artist, PlexAudioPlaylist target) {
        return (PlexAudioPlaylist) add((PlexMediatag<?>) artist, target);
    }

    @Override
    public PlexAudioPlaylist add(PlexAlbum album, PlexAudioPlaylist target) {
        return (PlexAudioPlaylist) add((PlexMediatag<?>) album, target);
    }

    @Override
    public PlexAudioPlaylist add(PlexTrack track, PlexAudioPlaylist target) {
        return (PlexAudioPlaylist) add((PlexMediatag<?>) track, target);
    }

    @Override
    public PlexAudioPlaylist remove(PlexTrack track, PlexAudioPlaylist target) {
        return (PlexAudioPlaylist) removeItemFromTarget(track, target);
    }

    @Override
    public PlexPhotoPlaylist add(PlexPhotoalbum photoalbum, PlexPhotoPlaylist target) {
        return (PlexPhotoPlaylist) add((PlexMediatag<?>) photoalbum, target);
    }

    @Override
    public PlexPhotoPlaylist add(PlexPhoto photo, PlexPhotoPlaylist target) {
        return (PlexPhotoPlaylist) add((PlexMediatag<?>) photo, target);
    }

    @Override
    public PlexPhotoPlaylist add(PlexClip clip, PlexPhotoPlaylist target) {
        return (PlexPhotoPlaylist) add((PlexMediatag<?>) clip, target);
    }

    @Override
    public PlexPhotoPlaylist remove(PlexPhoto photo, PlexPhotoPlaylist target) {
        return (PlexPhotoPlaylist) removeItemFromTarget(photo, target);
    }

    @Override
    public PlexPhotoPlaylist remove(PlexClip clip, PlexPhotoPlaylist target) {
        return (PlexPhotoPlaylist) removeItemFromTarget(clip, target);
    }

    @Override
    public PlexVideoPlaylist add(PlexShow show, PlexVideoPlaylist target) {
        return (PlexVideoPlaylist) add((PlexMediatag<?>) show, target);
    }

    @Override
    public PlexVideoPlaylist add(PlexSeason season, PlexVideoPlaylist target) {
        return (PlexVideoPlaylist) add((PlexMediatag<?>) season, target);
    }

    @Override
    public PlexVideoPlaylist add(PlexEpisode episode, PlexVideoPlaylist target) {
        return (PlexVideoPlaylist) add((PlexMediatag<?>) episode, target);
    }

    @Override
    public PlexVideoPlaylist add(PlexMovie movie, PlexVideoPlaylist target) {
        return (PlexVideoPlaylist) add((PlexMediatag<?>) movie, target);
    }

    @Override
    public PlexVideoPlaylist remove(PlexEpisode episode, PlexVideoPlaylist target) {
        return (PlexVideoPlaylist) removeItemFromTarget(episode, target);
    }

    @Override
    public PlexVideoPlaylist remove(PlexMovie movie, PlexVideoPlaylist target) {
        return (PlexVideoPlaylist) removeItemFromTarget(movie, target);
    }

    @Override
    public void delete(PlexPlaylist<?> target) {
        server.getClient().delete(target.ratingKey(), server.getToken(), Optional.empty());        
    }
}
