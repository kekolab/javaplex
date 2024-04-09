package kekolab.javaplex.model;

import java.util.List;

public interface PlexArtistSecondaryDirectory extends PlexSectionSecondaryDirectory {
    List<PlexArtist> artists();
}