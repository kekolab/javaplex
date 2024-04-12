package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexArtist;
import kekolab.javaplex.PlexClassicPlaylist;
import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMusicSection;
import kekolab.javaplex.PlexPlaylists;
import kekolab.javaplex.PlexSectionSecondaryDirectory;
import kekolab.javaplex.PlexSmartPlaylist;
import kekolab.javaplex.PlexTrack;
import kekolab.javaplex.filtering.PlexFilter;
import kekolab.javaplex.filtering.PlexFilterBuilder;

public class PlexPlaylistsTests extends PlexTests {
	private PlexMediaServer server;
	private PlexPlaylists playlists;

	@BeforeEach
	public void init() {
		PlexDevice server = getApi().getResources().list().stream().filter(d -> d.isServer()).findAny().get();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		this.server = getApi().getMediaServer(connection);
		playlists = this.server.playlists();
	}

	@Test
	public void classicAudioPlaylist() {
		int playlistsCount = playlists.list().size();

		// Creation
		List<PlexTrack> tracks = server.library().sections().musicSections().get(0).tracks().execute();
		PlexTrack aTrack = tracks.get(0);
		PlexTrack anotherTrack = tracks.get(1);
		PlexClassicPlaylist<PlexTrack> audioPlaylist = playlists.create("a test playlist", aTrack);
		assertEquals(1 + playlistsCount, playlists.list().size());
		assertEquals("a test playlist", audioPlaylist.getTitle());
		assertEquals(1, audioPlaylist.items().size());
		assertTrue(audioPlaylist.items().stream().anyMatch(i -> i.getRatingKey().equals(aTrack.getRatingKey())));

		// Adding
		playlists.add(audioPlaylist, anotherTrack);
		assertEquals(2, audioPlaylist.items().size());
		assertTrue(audioPlaylist.items().stream().anyMatch(i -> i.getRatingKey().equals(aTrack.getRatingKey())));
		assertTrue(audioPlaylist.items().stream().anyMatch(i -> i.getRatingKey().equals(anotherTrack.getRatingKey())));

		// Removing
		playlists.remove(audioPlaylist, anotherTrack);
		assertEquals(1, audioPlaylist.items().size());
		assertTrue(audioPlaylist.items().stream().anyMatch(i -> i.getRatingKey().equals(aTrack.getRatingKey())));

		// Delete
		playlists.delete(audioPlaylist);
		assertEquals(playlistsCount, playlists.list().size());
	}

	@Test
	public void smartAudioPlaylist() {
		int playlistsCount = playlists.list().size();

		// Creation
		PlexMusicSection section = server.library().sections().musicSections().get(0);
		List<PlexSectionSecondaryDirectory<PlexArtist>> countries = section.artistCountries();
		PlexSectionSecondaryDirectory<PlexArtist> aCountry = countries.get(0);
		PlexSectionSecondaryDirectory<PlexArtist> anotherCountry = countries.get(1);
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.COUNTRY).is(aCountry);
		PlexSmartPlaylist<PlexMusicSection, PlexTrack> playlist = playlists.createSmart("a smart playlist", section,
				filter);
		assertEquals(1 + playlistsCount, playlists.list().size());
		assertEquals("a smart playlist", playlist.getTitle());
		assertTrue(playlist.items().stream()
				.map(i -> i.grandparent().getCountries().stream().anyMatch(c -> c.getTag().equals(aCountry.getTitle())))
				.reduce(Boolean::logicalAnd).get());

		// Altering
		filter = PlexFilterBuilder.when(PlexArtist.COUNTRY).is(aCountry)
				.or(PlexFilterBuilder.when(PlexArtist.COUNTRY).is(anotherCountry));
		playlists.alter(playlist, filter);
		assertTrue(playlist.items().stream()
				.map(i -> i.grandparent().getCountries().stream().anyMatch(c -> c.getTag().equals(aCountry.getTitle()) || c.getTag().equals(anotherCountry.getTitle())))
				.reduce(Boolean::logicalAnd).get());

		// Delete
		playlists.delete(playlist);
		assertEquals(playlistsCount, playlists.list().size());
	}
}
