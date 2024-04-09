package kekolab.javaplex;

import java.util.List;

import kekolab.javaplex.model.PlexClassicVideoPlaylist;

public class ClassicVideoPlaylist extends Playlist implements PlexClassicVideoPlaylist {
    @Override
    public List<Video> children() {
        return super.children().stream().map(Video.class::cast).toList();
    }
}
