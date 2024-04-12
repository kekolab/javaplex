package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMediatag;
import kekolab.javaplex.PlexPlayQueue;
import kekolab.javaplex.PlexPlayQueues;

public class PlexPlayQueuesTests extends PlexMediaServerTests {
    private final PlexMediaServer server;

    public PlexPlayQueuesTests() {
        this.server = getServer();
    }    

    @Test
	public void test() {
		PlexPlayQueues playQueues = getServer().playQueues();
		PlexMediatag<?> aTrack = server.library().sections().musicSections().get(0).tracks().execute().get(0);
		PlexMediatag<?> anotherTrack = server.library().sections().musicSections().get(0).tracks().execute().get(1);
		PlexMediatag<?> aMovie = server.library().sections().movieSections().get(0).all().execute().get(1);
		PlexPlayQueue playQueue = playQueues.create(aTrack, false);
		assertEquals(1, playQueue.getItems().size());
		assertEquals(aTrack.getRatingKey(), playQueue.getItems().get(0).getRatingKey());

		playQueues.add(playQueue, aMovie);
		playQueues.add(playQueue, anotherTrack);
		assertEquals(3, playQueue.getItems().size());
		assertTrue(playQueue.getItems().stream().anyMatch(i -> i.getRatingKey().equals(aTrack.getRatingKey())));
		assertTrue(playQueue.getItems().stream().anyMatch(i -> i.getRatingKey().equals(anotherTrack.getRatingKey())));
		assertTrue(playQueue.getItems().stream().anyMatch(i -> i.getRatingKey().equals(aMovie.getRatingKey())));

		playQueues.remove(playQueue, aMovie);
		assertEquals(2, playQueue.getItems().size());
		assertTrue(playQueue.getItems().stream().anyMatch(i -> i.getRatingKey().equals(aTrack.getRatingKey())));
		assertTrue(playQueue.getItems().stream().anyMatch(i -> i.getRatingKey().equals(anotherTrack.getRatingKey())));
		assertTrue(playQueue.getItems().stream().noneMatch(i -> i.getRatingKey().equals(aMovie.getRatingKey())));
	}
    
}
