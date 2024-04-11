package kekolab.libplex.test;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexAlbum;
import kekolab.javaplex.PlexArtist;
import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMediatag;
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
		section = mediaServer.library().sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
	}

	@Test
	public void byCountries() {
		List<PlexArtist> artists = section.artistCountries().get(0).list();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
	}

	@Test
	public void byGenres() {
		PlexSectionSecondaryDirectory<PlexArtist> artistGenre = section.artistGenres().get(0);
		List<PlexArtist> artists = artistGenre.list();
		artists.stream().map(PlexMediatag::getTitle).forEach(System.out::println);
		PlexSectionSecondaryDirectory<PlexAlbum> albumGenre = section.albumGenres().get(0);;
		List<PlexAlbum> albums = albumGenre.list();
		albums.stream().map(PlexMediatag::getTitle).forEach(System.out::println);
	}
}
