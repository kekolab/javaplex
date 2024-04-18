package kekolab.libplex.test;

import java.net.URISyntaxException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexClient;
import kekolab.javaplex.PlexClients;
import kekolab.javaplex.PlexClients.MediaType;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexTrack;

public class PlexClientsTests extends PlexMediaServerTests {
	private final PlexMediaServer server;

	public PlexClientsTests() {
		this.server = getServer();
	}

	@Test
	public void setVolumePlayStop() throws URISyntaxException, InterruptedException {
		PlexClients clients = server.clients();
		PlexClient client = clients.list().get(0);
		PlexTrack track = server.library().sections().musicSections().get(0).tracks().execute().get(0);
		clients.setPlaybackParameters(client, Optional.of(10), Optional.empty(), Optional.empty(), MediaType.MUSIC);
		Thread.sleep(500);
		clients.playMedia(client, track, Optional.empty());
		Thread.sleep(500);
		clients.stop(client, Optional.of(MediaType.MUSIC));
	}
}
