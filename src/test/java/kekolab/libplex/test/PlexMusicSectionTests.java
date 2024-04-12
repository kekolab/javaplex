package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexAlbum;
import kekolab.javaplex.PlexArtist;
import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMusicSection;
import kekolab.javaplex.PlexSectionSecondaryDirectory;

public class PlexMusicSectionTests extends PlexTests {
	private PlexMusicSection section;

	@BeforeEach
	public void init() {
		PlexDevice server = getApi().getResources().list().stream().filter(d -> d.isServer()).findAny().get();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		PlexMediaServer mediaServer = getApi().getMediaServer(connection);
		section = mediaServer.library().sections().musicSections().get(0);
	}

	@Test
	public void byCountries() {
		PlexSectionSecondaryDirectory<PlexArtist> aCountry = section.artistCountries().get(0);
		List<PlexArtist> artists = aCountry.list();
		assertTrue(artists.size() > 0);
		assertTrue(artists.stream()
				.allMatch(m -> m.getCountries().stream().anyMatch(c -> c.getTag().equals(aCountry.getTitle()))));

	}

	@Test
	public void byGenres() {
		PlexSectionSecondaryDirectory<PlexArtist> anArtistGenre = section.artistGenres().get(0);
		List<PlexArtist> artists = anArtistGenre.list();
		assertTrue(artists.size() > 0);
		assertTrue(artists.stream()
				.allMatch(m -> m.getGenres().stream().anyMatch(c -> c.getTag().equals(anArtistGenre.getTitle()))));
		PlexSectionSecondaryDirectory<PlexAlbum> anAlbumGenre = section.albumGenres().get(0);
		List<PlexAlbum> albums = anAlbumGenre.list();
		assertTrue(albums.size() > 0);
		assertTrue(albums.stream()
				.allMatch(m -> m.getGenres().stream().anyMatch(c -> c.getTag().equals(anAlbumGenre.getTitle()))));
	}
}
