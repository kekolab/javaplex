package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistCollection;
import kekolab.javaplex.model.PlexMusicSection;

public class ArtistCollection extends Collection implements PlexArtistCollection {
    @Override
    public List<PlexArtist> children() {
        return super.children().stream().map(PlexArtist.class::cast).toList();
    }

    @Override
    public PlexMusicSection section() {
        return (MusicSection) super.section();
    }
}
