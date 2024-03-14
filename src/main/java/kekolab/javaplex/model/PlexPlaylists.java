package kekolab.javaplex.model;

import java.util.*;

public interface PlexPlaylists {
    List<PlexPlaylist<?>> list();

    void delete(PlexPlaylist<?> target);

    // Audio playlists
    PlexAudioPlaylist create(String title, PlexArtist artist);

    PlexAudioPlaylist create(String title, PlexAlbum album);

    PlexAudioPlaylist create(String title, PlexTrack track);

    PlexAudioPlaylist add(PlexArtist artist, PlexAudioPlaylist target);
    
    PlexAudioPlaylist add(PlexAlbum album, PlexAudioPlaylist target);

    PlexAudioPlaylist add(PlexTrack track, PlexAudioPlaylist target);

    PlexAudioPlaylist remove(PlexTrack track, PlexAudioPlaylist target);

    // Photo playlists

    PlexPhotoPlaylist create(String title, PlexPhotoalbum photoalbum);

    PlexPhotoPlaylist create(String title, PlexPhoto photo);

    PlexPhotoPlaylist create(String title, PlexClip clip);

    PlexPhotoPlaylist add(PlexPhotoalbum photoalbum, PlexPhotoPlaylist target);

    PlexPhotoPlaylist add(PlexPhoto photo, PlexPhotoPlaylist target);

    PlexPhotoPlaylist add(PlexClip clip, PlexPhotoPlaylist target);

    PlexPhotoPlaylist remove(PlexPhoto photo, PlexPhotoPlaylist target);

    PlexPhotoPlaylist remove(PlexClip clip, PlexPhotoPlaylist target);

    // Video playlists

    PlexVideoPlaylist create(String title, PlexShow show);

    PlexVideoPlaylist create(String title, PlexSeason season);

    PlexVideoPlaylist create(String title, PlexEpisode episode);

    PlexVideoPlaylist create(String title, PlexMovie movie);
    
    PlexVideoPlaylist add(PlexShow show, PlexVideoPlaylist target);

    PlexVideoPlaylist add(PlexSeason season, PlexVideoPlaylist target);

    PlexVideoPlaylist add(PlexEpisode episode, PlexVideoPlaylist target);

    PlexVideoPlaylist add(PlexMovie movie, PlexVideoPlaylist target);

    PlexVideoPlaylist remove(PlexEpisode episode, PlexVideoPlaylist target);

    PlexVideoPlaylist remove(PlexMovie movie, PlexVideoPlaylist target);   

}
