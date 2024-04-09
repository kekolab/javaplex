package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexException;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistCollection;
import kekolab.javaplex.model.PlexClassicAudioPlaylist;
import kekolab.javaplex.model.PlexClassicPlaylist;
import kekolab.javaplex.model.PlexConnection;
import kekolab.javaplex.model.PlexDevice;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMusicCollections;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexPlaylists;
import kekolab.javaplex.model.PlexSection;
import kekolab.javaplex.model.PlexTrack;

public class PlexMediaServerTests extends PlexTests {
	private static PlexMediaServer server;

	static PlexMediaServer getServer() {
		return server;
	}

	@BeforeAll
	public static void findAPublicServer() {
		List<PlexDevice> serverDevices = getApi().getResources().list().stream().filter(PlexDevice::isServer).toList();
		for (PlexDevice serverDevice : serverDevices) {
			for (PlexConnection connection : serverDevice.getConnections())
				if (connection.getLocal() == 0)
					try {
						server = getApi().getMediaServer(connection);
						return;
					} catch (PlexException e) {
						e.printStackTrace();
					}
		}
		throw new PlexException("Cannot find a publicly available media server");
	}

	@Test
	public void refresh() {
		PlexArtist artist = (PlexArtist) getServer().library().search("xuxa").get(0).getItem();
		PlexPlaylists playlists = getServer().playlists();
		PlexClassicAudioPlaylist audioPlaylist = playlists.list().stream().filter(PlexClassicAudioPlaylist.class::isInstance)
				.map(PlexClassicAudioPlaylist.class::cast).findAny().get();
		assertFalse(audioPlaylist.children().stream().anyMatch(t -> {
			return t.getGrandparentTitle().equals(artist.getTitle());
		}));
		playlists.add(audioPlaylist, artist);
		List<PlexTrack> tracks = audioPlaylist.children().stream().filter(t -> {
			return t.getGrandparentTitle().equals(artist.getTitle());
		}).toList();
		assertEquals(1, tracks.size());
		playlists.remove(audioPlaylist, tracks.get(0));
		tracks = audioPlaylist.children().stream().filter(t -> {
			return t.getGrandparentTitle().equals(artist.getTitle());
		}).toList();
		assertEquals(0, tracks.size());
	}

	@Test
	public void props() {
		assertNotNull(getServer().getAllowCameraUpload());
	}

	@Test
	public void getServerProperty() {
		assertNotNull(getServer().getAllowCameraUpload());
	}

	@Test
	public void library() {
		getServer().library();
		getServer().library().all().stream().filter(m -> m instanceof PlexTrack).map(m -> (PlexTrack) m).map(t -> {
			return t.getMedia().get(0).getParts().get(0).getStreams().get(0).getClass();
		}).findAny().ifPresentOrElse(System.out::println, () -> {
			throw new RuntimeException();
		});
	}

	@Test
	public void playlists() {
		PlexPlaylists playlists = getServer().playlists();
		assertTrue(playlists.list().stream().noneMatch(p -> p.getTitle().equals("xuxa")));
		PlexArtist xuxa = (PlexArtist) getServer().library().search("xuxa").get(0).getItem();
		PlexClassicPlaylist playlist = playlists.create("xuxa", xuxa);
		assertTrue(playlist instanceof PlexClassicAudioPlaylist);
		PlexClassicAudioPlaylist audioPlaylist = (PlexClassicAudioPlaylist) playlist;
		assertTrue(audioPlaylist.children().stream().anyMatch(c -> {
			return c.getGrandparentTitle().equals(xuxa.getTitle());
		}));
		playlists.delete(playlist);
		assertTrue(playlists.list().stream().noneMatch(p -> p.getTitle().equals("xuxa")));
	}

	@Test
	public void collections() {
		for (PlexMusicSection section : getServer().library().sections().stream()
				.filter(s -> s.getType().equals("artist"))
				.map(PlexMusicSection.class::cast)
				.toList()) {
			PlexMusicCollections collections = section.collections();
			for (PlexArtistCollection collection : collections.list().stream()
					.filter(PlexArtistCollection.class::isInstance).map(PlexArtistCollection.class::cast).toList()) {
				collections.add(collection, (PlexArtist) getServer().library().search("xuxa").get(0).getItem());
				PlexArtist xuxa = collection.children().stream().filter(c -> c.getTitle().toLowerCase().equals("xuxa"))
						.findAny().get();
				collections.remove(collection, xuxa);
				assertTrue(collection.children().stream().noneMatch(c -> c.getTitle().toLowerCase().equals("xuxa")));
				collections.remove(collection, xuxa);
			}
		}
	}

	@Test
	public void listCollections() {
		for (PlexMusicSection section : getServer().library().musicSections()) {
			section.collections().list()
					.forEach(collection -> System.out.println(collection.getClass() + " - " + collection.getTitle()));
		}
	}

	@Test
	public void createCollection() {
		for (PlexSection section : getServer().library().sections().stream()
				.filter(s -> s.getType().equals("artist"))
				.toList()) {
			PlexArtist xuxa = (PlexArtist) getServer().library().search("xuxa").get(0).getItem();
			PlexMusicCollections collections = ((PlexMusicSection) section).collections();
			PlexArtistCollection collection = collections
					.create("xuxaCollection", xuxa);
			assertEquals(1, collection.children().size());
			assertTrue(collection.children().get(0).getTitle().equals(xuxa.getTitle()));
			collections.delete(collection);
			assertEquals(0, collections.list().size());
			break;
		}
	}

	@Test
	public void sections() {
		for (PlexSection section : getServer().library().sections()) {
			System.out.println(section.getClass());

			/*
			 * for (PlexArtistCollection collection :
			 * section.contents().collections().stream() .filter(c -> c instanceof
			 * PlexArtistCollection).map(c -> (PlexArtistCollection) c).toList()) {
			 * collection.add((PlexArtist)
			 * getServer().library().search("xuxa").get(0).getItem());
			 * PlexArtist xuxa = collection.children().stream().filter(c ->
			 * c.getTitle().toLowerCase().equals("xuxa")) .findAny().get();
			 * collection.remove(xuxa);
			 * assertTrue(collection.children().stream().noneMatch(c ->
			 * c.getTitle().toLowerCase().equals("xuxa"))); collection.remove(xuxa); }
			 */
		}
	}

}
