package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexArtist;
import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexGrandchild;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMusicSection;
import kekolab.javaplex.PlexSectionSecondaryDirectory;
import kekolab.javaplex.PlexSmartPlaylist;
import kekolab.javaplex.PlexTrack;
import kekolab.javaplex.filtering.PlexFilter;
import kekolab.javaplex.filtering.PlexFilterBuilder;

public class PlexPlaylistsTests extends PlexTests {
	private PlexMediaServer server;

	@BeforeEach
	public void init() {
		PlexDevice server = getApi().getResources().list().stream().filter(d -> d.isServer()).findAny().get();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		this.server = getApi().getMediaServer(connection);
	}

	@Test
	public void searchExistentArtist() {
		List<PlexSmartPlaylist> playlists = server.playlists().list().stream()
				.filter(PlexSmartPlaylist.class::isInstance).map(PlexSmartPlaylist.class::cast).toList();
		playlists.get(0).getFilter();
	}

	@Test
	public void createSmartPlaylist() {
		PlexMusicSection section = server.library().musicSections().get(0);
		PlexSectionSecondaryDirectory<PlexArtist> country = section.artistCountries().stream().filter(f -> f.getTitle().toLowerCase().contains("canada"))
				.findAny().get();
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.COUNTRY).is(country);
		PlexSmartPlaylist<PlexMusicSection, PlexTrack> playlist = (PlexSmartPlaylist<PlexMusicSection, PlexTrack>) server.playlists().createSmart("Canadian artists", section, filter);
		assertTrue(playlist.items().stream().map(PlexGrandchild::grandparent)
				.allMatch(f -> f.getTitle().toLowerCase().contains("alanis") ||  f.getTitle().toLowerCase().contains("avril")));
	}

	@Test
	public void alterSmartPlaylist() {
		PlexSmartPlaylist<PlexMusicSection, PlexTrack> playlist = (PlexSmartPlaylist<PlexMusicSection, PlexTrack>) server.playlists().list().stream().filter(p -> p.getTitle().equalsIgnoreCase("canadian singers")).findAny().get();
		PlexSectionSecondaryDirectory<PlexArtist> france = server.library().musicSections().get(0).artistCountries().stream().filter(c -> c.getTitle().equalsIgnoreCase("france")).findAny().get();
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.COUNTRY).is(france);
		playlist = server.playlists().alter(playlist, filter);
		
		assertTrue(playlist.items().stream().noneMatch(c -> c.grandparent().getTitle().toLowerCase().contains("alanis")));
		assertTrue(playlist.items().stream().anyMatch(c -> c.grandparent().getTitle().toLowerCase().contains("zarra")));
	}
}
