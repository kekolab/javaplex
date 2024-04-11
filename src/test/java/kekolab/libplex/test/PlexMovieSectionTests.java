package kekolab.libplex.test;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMediatag;
import kekolab.javaplex.PlexMovie;
import kekolab.javaplex.PlexMovieSection;
import kekolab.javaplex.PlexSectionSecondaryDirectory;

public class PlexMovieSectionTests extends PlexTests {
	private PlexMovieSection section;

	@BeforeEach
	public void init() {
		PlexDevice server = getApi().getResources().list().stream().filter(d -> d.isServer()).findAny().get();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		PlexMediaServer mediaServer = getApi().getMediaServer(connection);
		section = mediaServer.library().sections().stream().filter(PlexMovieSection.class::isInstance)
				.map(PlexMovieSection.class::cast).findAny().get();
	}

	@Test
	public void byCountries() {
		PlexSectionSecondaryDirectory<PlexMovie> filter = section.movieCountries().get(1);
		List<PlexMovie> movies = filter.list();
		System.out.println("Selected: " + filter.getTitle());
		movies.stream().map(PlexMediatag::getTitle).forEach(System.out::println);
	}

}
