package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistSecondaryDirectory;
import kekolab.javaplex.model.PlexConnection;
import kekolab.javaplex.model.PlexDevice;
import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexFilterBuilder;
import kekolab.javaplex.model.PlexGrandchild;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexSmartAudioPlaylist;
import kekolab.javaplex.model.PlexSmartPlaylist;
import kekolab.javaplex.model.PlexTrack;

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
		PlexArtistSecondaryDirectory country = section.byCountry().stream().filter(f -> f.getTitle().toLowerCase().contains("canada"))
				.findAny().get();
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.COUNTRY).is(country);
		PlexSmartPlaylist playlist = server.playlists().createSmart("Canadian artists", section, filter);
		assertTrue(playlist instanceof PlexSmartAudioPlaylist);
		assertTrue(playlist.children().stream().map(PlexTrack.class::cast).map(PlexGrandchild::grandparent)
				.allMatch(f -> f.getTitle().toLowerCase().contains("alanis") ||  f.getTitle().toLowerCase().contains("avril")));
	}

	@Test
	public void alterSmartPlaylist() {
		PlexSmartAudioPlaylist playlist = (PlexSmartAudioPlaylist) server.playlists().list().stream().filter(p -> p.getTitle().equalsIgnoreCase("canadian singers")).findAny().get();
		PlexArtistSecondaryDirectory france = server.library().musicSections().get(0).byCountry().stream().filter(c -> c.getTitle().equalsIgnoreCase("france")).findAny().get();
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.COUNTRY).is(france);
		playlist = (PlexSmartAudioPlaylist) server.playlists().alter(playlist, filter);
		
		assertTrue(playlist.children().stream().noneMatch(c -> c.grandparent().getTitle().toLowerCase().contains("alanis")));
		assertTrue(playlist.children().stream().anyMatch(c -> c.grandparent().getTitle().toLowerCase().contains("zarra")));
	}
}
