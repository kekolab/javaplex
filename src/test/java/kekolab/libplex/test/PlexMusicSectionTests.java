package kekolab.libplex.test;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistOrAlbumSecondaryDirectory;
import kekolab.javaplex.model.PlexConnection;
import kekolab.javaplex.model.PlexDevice;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexMusicSection;

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
		List<PlexArtist> artists = section.byCountry().get(0).artists();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
	}

	@Test
	public void byGenres() {
		PlexArtistOrAlbumSecondaryDirectory plexMusicGenreFilter = section.byGenre().get(0);
		List<PlexArtist> artists = plexMusicGenreFilter.artists();
		artists.stream().map(PlexMediatag::getTitle).forEach(System.out::println);
		List<PlexAlbum> albums = plexMusicGenreFilter.albums();
		albums.stream().map(PlexMediatag::getTitle).forEach(System.out::println);
	}
}
