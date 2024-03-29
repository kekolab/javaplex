package kekolab.libplex.test;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.model.PlexConnection;
import kekolab.javaplex.model.PlexDevice;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieFilter;
import kekolab.javaplex.model.PlexMovieSection;

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
		PlexMovieFilter filter = section.byCountry().get(1);
		List<PlexMovie> movies = filter.movies();
		System.out.println("Selected: " + filter.getTitle());
		movies.stream().map(PlexMediatag::getTitle).forEach(System.out::println);
	}

}
