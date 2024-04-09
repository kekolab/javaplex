package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistSecondaryDirectory;

public class ArtistFilter implements PlexArtistSecondaryDirectory {
    private final SectionSecondaryDirectory filter;
    private final MusicSection section;

    public ArtistFilter(SectionSecondaryDirectory delegate, MusicSection section) {
        this.section = section;
        this.filter = delegate;
    }

    @Override
    public List<PlexArtist> artists() {
        return filter.apply(section, PlexArtist.TYPE_ID);
    }

    @Override
    public String getFastKey() {
        return filter.getFastKey();
    }

    @Override
    public URI fastKey() {
        return filter.fastKey();
    }

    @Override
    public String getType() {
        return filter.getType();
    }

    @Override
    public String getKey() {
        return filter.getKey();
    }

    @Override
    public URI key() {
        return filter.key();
    }

    @Override
    public String getTitle() {
        return filter.getTitle();
    }
}
