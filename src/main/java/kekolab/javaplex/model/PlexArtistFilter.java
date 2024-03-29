package kekolab.javaplex.model;

import java.util.List;

public interface PlexArtistFilter extends PlexFilter {
    List<PlexArtist> artists();
}