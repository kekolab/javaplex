package kekolab.javaplex.model;

import java.util.List;

public interface PlexAlbumSecondaryDirectory extends PlexSectionSecondaryDirectory  {
    List<PlexAlbum> albums();
}