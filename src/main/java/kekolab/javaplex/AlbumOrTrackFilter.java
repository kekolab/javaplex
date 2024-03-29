package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexAlbumOrTrackFilter;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;

class AlbumOrTrackFilter extends AlbumFilter implements PlexAlbumOrTrackFilter {
    private final TrackFilter trackFilter;

    AlbumOrTrackFilter(Filter delegate, PlexMusicSection section) {
        super(delegate, section);
        this.trackFilter = new TrackFilter(delegate, section);
    }

   @Override
   public List<PlexTrack> tracks() {
       return trackFilter.tracks();    
   }
}
