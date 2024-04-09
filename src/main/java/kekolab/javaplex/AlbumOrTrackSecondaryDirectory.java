package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexAlbumOrTrackSecondaryDirectory;
import kekolab.javaplex.model.PlexTrack;

public class AlbumOrTrackSecondaryDirectory extends AlbumSecondaryDirectory implements PlexAlbumOrTrackSecondaryDirectory {
    private final TrackSecondaryDirectory trackFilter;

    AlbumOrTrackSecondaryDirectory(SectionSecondaryDirectory delegate, MusicSection section) {
        super(delegate, section);
        this.trackFilter = new TrackSecondaryDirectory(delegate, section);
    }

   
   public List<PlexTrack> tracks() {
       return trackFilter.tracks();    
   }
}
