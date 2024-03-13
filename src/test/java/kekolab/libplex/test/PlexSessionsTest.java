package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexTranscode;
import kekolab.javaplex.model.PlexTranscodeSession;

public class PlexSessionsTest extends PlexMediaServerTests {

    @Test
    public void sessions() {
        List<PlexMediatag<?>> mediatags = getServer().status().sessions();
        assertNotNull(mediatags);

        // The following assertions need to have a session ongoing
        PlexMediatag<?> mediatag = mediatags.get(0);
        assertNotNull(mediatag.getSession());
        assertNotNull(mediatag.getSessionKey());
        assertNotNull(mediatag.getPlayer());

        // The following assertions need to have an active transcoding session
        PlexTranscodeSession transcodeSession = mediatags.stream().map(PlexMediatag::getTranscodeSession).findAny()
                .get();
        assertNotNull(transcodeSession);
        assertNotNull(transcodeSession.getKey());
    }

    @Test
    public void listTranscodeSessions() {
        List<PlexTranscodeSession> transcodeSessions = getServer().transcode().sessions();
        assertNotNull(transcodeSessions);

        // The following assertions need to have an active transcoding session
        PlexTranscodeSession transcodeSession = transcodeSessions.get(0);
        assertNotNull(transcodeSession);
        assertNotNull(transcodeSession.getKey());
    }

    @Test
    public void killTranscodeSession() {
        PlexTranscode transcode = getServer().transcode();
        List<PlexTranscodeSession> transcodeSessions = transcode.sessions();

        // The following assertions need to have an active transcoding session
        transcodeSessions.forEach(transcode::killSession);
        assertTrue(transcode.sessions().isEmpty());
    }
}
