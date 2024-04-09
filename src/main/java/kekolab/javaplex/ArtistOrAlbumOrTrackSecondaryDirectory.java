package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexArtistOrAlbumOrTrackSecondaryDirectory;
import kekolab.javaplex.model.PlexTrack;

public class ArtistOrAlbumOrTrackSecondaryDirectory extends ArtistOrAlbumSecondaryDirectory implements PlexArtistOrAlbumOrTrackSecondaryDirectory {
    private final TrackSecondaryDirectory trackFilter;

    ArtistOrAlbumOrTrackSecondaryDirectory(SectionSecondaryDirectory delegate, MusicSection section) {
        super(delegate, section);
        this.trackFilter = new TrackSecondaryDirectory(delegate, section);
    }

    @Override
    public List<PlexTrack> tracks() {
        return trackFilter.tracks();
    }
}
