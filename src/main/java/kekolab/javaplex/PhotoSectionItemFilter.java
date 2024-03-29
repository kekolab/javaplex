package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexClip;
import kekolab.javaplex.model.PlexPhoto;
import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoSectionItemFilter;

class PhotoSectionItemFilter implements PlexPhotoSectionItemFilter {
    private final Filter filter;
    private final PlexPhotoSection section;
    
    PhotoSectionItemFilter(Filter delegate, PlexPhotoSection section) {
        this.section = section;
        this.filter = delegate;
    } 
    @Override
    public List<PlexPhoto> photos() {
        return filter.apply(section, PlexPhoto.TYPE_ID);
    }

    @Override
    public List<PlexClip> clips() {
        return filter.apply(section, PlexClip.TYPE_ID);
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
