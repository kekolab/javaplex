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
import kekolab.javaplex.model.PlexAudioPlaylist;
import kekolab.javaplex.model.PlexCollection;
import kekolab.javaplex.model.PlexConnection;
import kekolab.javaplex.model.PlexDevice;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMetadata;
import kekolab.javaplex.model.PlexMusicSection;
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
		PlexAudioPlaylist audioPlaylist = getServer().playlists().stream().filter(PlexAudioPlaylist.class::isInstance)
				.map(PlexAudioPlaylist.class::cast).findAny().get();
		assertFalse(audioPlaylist.children().stream().anyMatch(t -> {
			return t.getGrandparentTitle().equals(artist.getTitle());
		}));
		audioPlaylist.add(artist);
		List<PlexTrack> tracks = audioPlaylist.children().stream().filter(t -> {
			return t.getGrandparentTitle().equals(artist.getTitle());
		}).toList();
		assertEquals(1, tracks.size());
		audioPlaylist.remove(tracks.get(0));
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
		assertTrue(getServer().playlists().stream().noneMatch(p -> p.getTitle().equals("xuxa")));
		PlexArtist xuxa = (PlexArtist) getServer().library().search("xuxa").get(0).getItem();
		PlexAudioPlaylist playlist = getServer().createPlaylist("xuxa", xuxa);
		assertTrue(playlist.children().stream().anyMatch(c -> {
			return c.getGrandparentTitle().equals(xuxa.getTitle());
		}));
		playlist.delete();
		assertTrue(getServer().playlists().stream().noneMatch(p -> p.getTitle().equals("xuxa")));
	}

	@Test
	public void collections() {
		for (PlexSection<?, ?> section : getServer().library().sections().stream()
				.filter(s -> s.getType().equals("artist"))
				.toList()) {
			for (PlexArtistCollection collection : section.collections().stream()
					.filter(c -> c instanceof PlexArtistCollection).map(c -> (PlexArtistCollection) c).toList()) {
				collection.add((PlexArtist) getServer().library().search("xuxa").get(0).getItem());
				PlexArtist xuxa = collection.children().stream().filter(c -> c.getTitle().toLowerCase().equals("xuxa"))
						.findAny().get();
				collection.remove(xuxa);
				assertTrue(collection.children().stream().noneMatch(c -> c.getTitle().toLowerCase().equals("xuxa")));
				collection.remove(xuxa);
			}
		}
	}

	@Test
	public void listCollections() {
		getServer().library().sections().forEach(s -> s.collections().forEach(c -> c.getChildCount()));
		/*
		 * for (PlexSection<?, ?> section :
		 * getServer().library().sections().stream().filter(s ->
		 * s.getType().equals("artist"))
		 * .toList()) {
		 * for (ArtistCollection collection : section.collections().stream()
		 * .filter(c -> c instanceof ArtistCollection).map(c -> (ArtistCollection)
		 * c).toList()) {
		 * collection.add((PlexArtist)
		 * getServer().library().search("xuxa").get(0).getItem());
		 * PlexArtist xuxa = collection.children().stream().filter(c ->
		 * c.getTitle().toLowerCase().equals("xuxa"))
		 * .findAny().get();
		 * collection.remove(xuxa);
		 * assertTrue(collection.children().stream().noneMatch(c ->
		 * c.getTitle().toLowerCase().equals("xuxa")));
		 * collection.remove(xuxa);
		 * }
		 * }
		 */
	}

	@Test
	public void createCollection() {
		for (PlexSection<?, ?> section : getServer().library().sections().stream()
				.filter(s -> s.getType().equals("artist"))
				.toList()) {
			PlexArtist xuxa = (PlexArtist) getServer().library().search("xuxa").get(0).getItem();
			PlexCollection<PlexArtist, PlexMusicSection> collection = ((PlexMusicSection) section)
					.createCollection("xuxaCollection", xuxa);
			assertEquals(1, collection.children().size());
			assertTrue(collection.children().get(0).getTitle().equals(xuxa.getTitle()));
			collection.delete();
			assertEquals(0, section.collections().size());
			break;
		}
	}

	@Test
	public void traverse() {
		getServer().library().all().stream().filter(PlexMetadata.class::isInstance).map(PlexMetadata.class::cast)
				.forEach(PlexMetadata::getFields);
	}

	@Test
	public void sections() {
		for (PlexSection<?, ?> section : getServer().library().sections()) {
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
