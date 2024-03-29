package kekolab.javaplex.model;

import java.util.List;

public interface PlexPhotoSectionItemFilter extends PlexFilter {
    List<PlexPhoto> photos();
    List<PlexClip> clips();
}