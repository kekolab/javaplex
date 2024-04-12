package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMovieSection;

public class PlexCollectionsTest extends PlexTests {
    private static PlexMovieSection section;

    @BeforeAll
    public static void init() {
        PlexDevice server = getApi().getResources().list().stream().filter(d -> d.isServer()).findAny().get();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		PlexMediaServer mediaServer = getApi().getMediaServer(connection);
        section = mediaServer.library().sections().movieSections().get(0);
    }

    
	@Test
	public void collections() {
		// Listing
		var movieCollections = section.collections().list();
		assertNotNull(movieCollections);
		int originalSize = movieCollections.size();

		// Creating
		var aMovie = section.all().execute().get(0);
		var movieCollection = section.collections().create("a test movie collection", aMovie);
		assertNotNull(movieCollection);
		assertEquals(1 + originalSize, section.collections().list().size());
		assertEquals(1, movieCollection.items().size());
		assertTrue(movieCollection.items().stream().anyMatch(i -> i.getRatingKey().equals(aMovie.getRatingKey())));
		
		// Adding
		var anotherMovie = section.all().execute().get(1);
		section.collections().add(movieCollection, anotherMovie);
		assertEquals(2, movieCollection.items().size());
		assertTrue(movieCollection.items().stream().anyMatch(i -> i.getRatingKey().equals(aMovie.getRatingKey())));
		assertTrue(movieCollection.items().stream().anyMatch(i -> i.getRatingKey().equals(anotherMovie.getRatingKey())));

		// Removing
		section.collections().remove(movieCollection, aMovie);
		assertEquals(1, movieCollection.items().size());
		assertTrue(movieCollection.items().stream().anyMatch(i -> i.getRatingKey().equals(anotherMovie.getRatingKey())));

		// Deleting
		section.collections().delete(movieCollection);
		var collections = section.collections().list();
		assertEquals(originalSize, collections.size());
		assertTrue(collections.stream().noneMatch(c -> c.getRatingKey().equals(movieCollection.getRatingKey())));
	}

    
}
