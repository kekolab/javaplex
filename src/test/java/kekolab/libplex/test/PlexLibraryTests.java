package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexArtist;
import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexLibrary;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMetadata;
import kekolab.javaplex.PlexSearchResult;

public class PlexLibraryTests extends PlexTests {
	private PlexLibrary library;

	@BeforeEach
	public void init() {
		PlexDevice server = getApi().getResources().list().stream().filter(d -> d.isServer()).findAny().get();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		PlexMediaServer mediaServer = getApi().getMediaServer(connection);
		library = mediaServer.library();
	}

	@Test
	public void searchExistentArtist() {
		List<PlexSearchResult> results = library.search("alanis");
		assertNotNull(results);
		assertTrue(results.size() > 0);
		PlexMetadata result = results.get(0).getItem();
		assertTrue(result instanceof PlexArtist);
		assertEquals("Alanis Morissette", result.getTitle());
	}
}
