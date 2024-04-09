package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexClassicAudioPlaylist;
import kekolab.javaplex.model.PlexTrack;

public class ClassicAudioPlaylist extends Playlist implements PlexClassicAudioPlaylist {
    @Override
    public List<PlexTrack> children() {
        return super.children().stream().map(PlexTrack.class::cast).toList();
    }
    

}
