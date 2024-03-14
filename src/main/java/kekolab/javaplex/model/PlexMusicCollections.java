package kekolab.javaplex.model;

public interface PlexMusicCollections extends PlexCollections<PlexMusicSection> {
    PlexArtistCollection create(String title, PlexArtist artist);
    PlexArtistCollection add(PlexArtist artist, PlexArtistCollection collection);
    PlexArtistCollection remove(PlexArtist artist, PlexArtistCollection collection);

    PlexAlbumCollection create(String title, PlexAlbum album);
    PlexAlbumCollection add(PlexAlbum album, PlexAlbumCollection collection);
    PlexAlbumCollection remove(PlexAlbum album, PlexAlbumCollection collection);

    PlexTrackCollection create(String title, PlexTrack track);
    PlexTrackCollection add(PlexTrack track, PlexTrackCollection collection);
    PlexTrackCollection remove(PlexTrack track, PlexTrackCollection collection);
}