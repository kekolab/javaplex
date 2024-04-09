package kekolab.javaplex.model;

import java.util.List;

public interface PlexTranscode {

    List<PlexTranscodeSession> sessions();

    void killSession(PlexTranscodeSession session);

}