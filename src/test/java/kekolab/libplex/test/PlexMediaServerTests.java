package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexException;
import kekolab.javaplex.PlexMediaServer;

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
	public void props() {
		// Properties
		assertNotNull(getServer().getMachineIdentifier());

		// Services
		assertNotNull(getServer().library());
		assertNotNull(getServer().playlists());
		assertNotNull(server.serverShares());
		assertNotNull(server.status());
		assertNotNull(server.transcode());

		// Other
		assertNotNull(server.toPlexServer());
	}
}
