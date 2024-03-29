package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexArtistOrAlbumOrTrackFilter;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;

class ArtistOrAlbumOrTrackFilter extends ArtistOrAlbumFilter implements PlexArtistOrAlbumOrTrackFilter {
    private final TrackFilter trackFilter;

    ArtistOrAlbumOrTrackFilter(Filter delegate, PlexMusicSection section) {
        super(delegate, section);
        this.trackFilter = new TrackFilter(delegate, section);
    }

   @Override
   public List<PlexTrack> tracks() {
       return trackFilter.tracks();
    
   }
}
