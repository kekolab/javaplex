package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtistOrAlbumFilter;
import kekolab.javaplex.model.PlexMusicSection;

class ArtistOrAlbumFilter extends ArtistFilter implements PlexArtistOrAlbumFilter {
    private final AlbumFilter albumFilter;

    ArtistOrAlbumFilter(Filter delegate, PlexMusicSection section) {
        super(delegate, section);
        this.albumFilter = new AlbumFilter(delegate, section);
    }

    @Override
    public List<PlexAlbum> albums() {
        return albumFilter.albums();
    }
}
