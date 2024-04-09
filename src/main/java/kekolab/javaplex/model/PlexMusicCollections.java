package kekolab.javaplex.model;



public interface PlexMusicCollections extends PlexCollections {

    PlexArtistCollection create(String title, PlexArtist PlexArtist);

    PlexAlbumCollection create(String title, PlexAlbum PlexAlbum);

    PlexTrackCollection create(String title, PlexTrack PlexTrack);

    PlexArtistCollection add(PlexArtistCollection collection, PlexArtist PlexArtist);

    PlexAlbumCollection add(PlexAlbumCollection collection, PlexAlbum PlexAlbum);

    PlexTrackCollection add(PlexTrackCollection collection, PlexTrack PlexTrack);

    PlexArtistCollection remove(PlexArtistCollection collection, PlexArtist PlexArtist);

    PlexAlbumCollection remove(PlexAlbumCollection collection, PlexAlbum PlexAlbum);

    PlexTrackCollection remove(PlexTrackCollection collection, PlexTrack PlexTrack);

}