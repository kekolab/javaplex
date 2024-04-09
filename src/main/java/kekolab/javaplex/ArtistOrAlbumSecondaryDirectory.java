package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtistOrAlbumSecondaryDirectory;

public class ArtistOrAlbumSecondaryDirectory extends ArtistFilter implements PlexArtistOrAlbumSecondaryDirectory {
    private final AlbumSecondaryDirectory albumFilter;

    ArtistOrAlbumSecondaryDirectory(SectionSecondaryDirectory delegate, MusicSection section) {
        super(delegate, section);
        this.albumFilter = new AlbumSecondaryDirectory(delegate, section);
    }

    
    @Override
    public List<PlexAlbum> albums() {
        return albumFilter.albums();
    }
}
