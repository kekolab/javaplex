package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexAlbumCollection;
import kekolab.javaplex.model.PlexMusicSection;

public class AlbumCollection extends Collection implements PlexAlbumCollection {
    @Override
    public List<PlexAlbum> children() {
        return super.children().stream().map(PlexAlbum.class::cast).toList();
    }

    @Override
    public PlexMusicSection section() {
        return (PlexMusicSection) super.section();
    }
    
}
