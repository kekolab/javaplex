package kekolab.javaplex;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexAlbumCollection;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistCollection;
import kekolab.javaplex.model.PlexMusicCollections;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackCollection;

public class MusicCollections extends Collections implements PlexMusicCollections {

    protected MusicCollections(MusicSection section) {
        super(section);
    }

    public PlexArtistCollection create(String title, PlexArtist artist) {
        return (PlexArtistCollection) super.create(title, artist);
    }

    public PlexAlbumCollection create(String title, PlexAlbum album) {
        return (PlexAlbumCollection) super.create(title, album);
    }

    public PlexTrackCollection create(String title, PlexTrack track) {
        return (PlexTrackCollection) super.create(title, track);
    }

    public PlexArtistCollection add(PlexArtistCollection collection, PlexArtist artist) {
        return (PlexArtistCollection) super.add(collection, artist);
    }

    public PlexAlbumCollection add(PlexAlbumCollection collection, PlexAlbum album) {
        return (PlexAlbumCollection) super.add(collection, album);
    }

    public PlexTrackCollection add(PlexTrackCollection collection, PlexTrack track) {
        return (PlexTrackCollection) super.add(collection, track);
    }

    public PlexArtistCollection remove(PlexArtistCollection collection, PlexArtist artist) {
        return (PlexArtistCollection) super.remove(collection, artist);
    }

    public PlexAlbumCollection remove(PlexAlbumCollection collection, PlexAlbum album) {
        return (PlexAlbumCollection) super.remove(collection, album);
    }

    public PlexTrackCollection remove(PlexTrackCollection collection, PlexTrack track) {
        return (PlexTrackCollection) super.remove(collection, track);
    }

}