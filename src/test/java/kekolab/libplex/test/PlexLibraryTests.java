package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexLibrary;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMediatag;
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
	public void libraryTests() {
		// Properties
		assertDoesNotThrow(() -> library.getTitle1());

		assertNotNull(library.all());
		assertNotNull(library.sections());
		assertNotNull(library.onDeck());
		assertNotNull(library.recentlyAdded());
		
		int aSectionId = Integer.parseInt(library.sections().get(0).getKey());
		assertNotNull(library.section(aSectionId));

		// Searching
		PlexMediatag<?> aMediatag = library.all().stream().filter(PlexMediatag.class::isInstance).map(PlexMediatag.class::cast).findAny().get();
		var results = library.search(aMediatag.getTitle()).stream().map(PlexSearchResult::getItem);
		assertTrue(results.anyMatch(r -> r.getRatingKey().equals(aMediatag.getRatingKey())));

		results = library.search("dfkjsnvdfkjsnvk").stream().map(PlexSearchResult::getItem);
		assertEquals(0, results.collect(Collectors.counting()));
	}
}
