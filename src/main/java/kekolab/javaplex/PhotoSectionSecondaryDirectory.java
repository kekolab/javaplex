package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexClip;
import kekolab.javaplex.model.PlexPhoto;
import kekolab.javaplex.model.PlexPhotoSectionSecondaryDirectory;

public class PhotoSectionSecondaryDirectory implements PlexPhotoSectionSecondaryDirectory {
    private final SectionSecondaryDirectory filter;
    private final PhotoSection section;

    PhotoSectionSecondaryDirectory(SectionSecondaryDirectory delegate, PhotoSection section) {
        this.section = section;
        this.filter = delegate;
    }

    @Override
    public List<PlexPhoto> photos() {
        return filter.apply(section, PlexPhoto.TYPE_ID);
    }

    public List<PlexClip> clips() {
        return filter.apply(section, PlexClip.TYPE_ID);
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
