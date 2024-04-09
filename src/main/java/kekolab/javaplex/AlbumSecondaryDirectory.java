package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexAlbumSecondaryDirectory;

public class AlbumSecondaryDirectory implements PlexAlbumSecondaryDirectory {
    private final SectionSecondaryDirectory filter;
    private final MusicSection section;

    AlbumSecondaryDirectory(SectionSecondaryDirectory delegate, MusicSection section) {
        this.section = section;
        this.filter = delegate;
    }

    public List<PlexAlbum> albums() {
        return filter.apply(section, PlexAlbum.TYPE_ID);
    }

    public String getFastKey() {
        return filter.getFastKey();
    }

    public URI fastKey() {
        return filter.fastKey();
    }

    public String getType() {
        return filter.getType();
    }

    public String getKey() {
        return filter.getKey();
    }

    public URI key() {
        return filter.key();
    }

    public String getTitle() {
        return filter.getTitle();
    }
}
