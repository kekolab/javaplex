package kekolab.javaplex;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexAlbumCollection;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistCollection;
import kekolab.javaplex.model.PlexMusicCollections;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackCollection;

class MusicCollections extends Collections<PlexMusicSection> implements PlexMusicCollections {

    MusicCollections(MusicSection section) {
        super(section);
    }

    @Override
    public PlexArtistCollection create(String title, PlexArtist artist) {
        return (PlexArtistCollection) super.create(title, artist);
    }

    @Override
    public PlexArtistCollection add(PlexArtist artist, PlexArtistCollection collection) {
        return (PlexArtistCollection) super.add(artist, collection);
    }

    @Override
    public PlexArtistCollection remove(PlexArtist artist, PlexArtistCollection collection) {
        return (PlexArtistCollection) super.remove(artist, collection);
    }

    @Override
    public PlexAlbumCollection create(String title, PlexAlbum album) {
        return (PlexAlbumCollection) super.create(title, album);
    }

    @Override
    public PlexAlbumCollection add(PlexAlbum album, PlexAlbumCollection collection) {
        return (PlexAlbumCollection) super.add(album, collection);
    }

    @Override
    public PlexAlbumCollection remove(PlexAlbum album, PlexAlbumCollection collection) {
        return (PlexAlbumCollection) super.remove(album, collection);
    }

    @Override
    public PlexTrackCollection create(String title, PlexTrack track) {
        return (PlexTrackCollection) super.create(title, track);
    }

    @Override
    public PlexTrackCollection add(PlexTrack track, PlexTrackCollection collection) {
        return (PlexTrackCollection) super.add(track, collection);
    }

    @Override
    public PlexTrackCollection remove(PlexTrack track, PlexTrackCollection collection) {
        return (PlexTrackCollection) super.remove(track, collection);
    }
}