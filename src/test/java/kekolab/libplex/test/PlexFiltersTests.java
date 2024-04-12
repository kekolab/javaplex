package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexArtist;
import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexLibrary;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMusicSection;
import kekolab.javaplex.PlexSectionSecondaryDirectory;
import kekolab.javaplex.filtering.PlexFilter;
import kekolab.javaplex.filtering.PlexFilterBuilder;

public class PlexFiltersTests extends PlexTests {
	private PlexLibrary library;
	private PlexMusicSection section;

	@BeforeEach
	public void init() {
		PlexDevice server = getApi().getResources().list().stream().filter(d -> d.isServer()).findAny().get();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		PlexMediaServer mediaServer = getApi().getMediaServer(connection);
		library = mediaServer.library();
		section = library.sections().musicSections().get(0);
	}

	@Test
	public void listByArtistTitleFilter() {
		PlexArtist anArtist = section.all().execute().get(0);
		String aTitle = anArtist.getTitle();
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.TITLE).equals(aTitle);
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		assertTrue(artists.stream().filter(a -> a.getTitle().equals(aTitle)).collect(Collectors.counting()) > 0);
		var albums = section.albums().filtered(filter).execute();
		assertTrue(albums.stream().allMatch(a -> a.parent().getRatingKey().equals(anArtist.getRatingKey())));
		var tracks = section.tracks().filtered(filter).execute();
		assertTrue(tracks.stream().allMatch(a -> a.grandparent().getRatingKey().equals(anArtist.getRatingKey())));
	}

	@Test
	public void artistUnmatchedFilter() {
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.UNMATCHED).isTrue();
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		assertNotNull(artists);
	}

	@Test
	public void artistGenreFilter() {
		PlexSectionSecondaryDirectory<PlexArtist> genre = section.artistGenres().get(0);
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.GENRE).is(genre);
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
		assertTrue(artists.stream()
				.allMatch(a -> a.getGenres().stream().anyMatch(g -> g.getTag().equals(genre.getKey()))));
	}

	@Test
	public void artistCountryFilter() {
		PlexSectionSecondaryDirectory<PlexArtist> country = section.artistCountries().get(0);
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.COUNTRY).is(country);
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
		assertTrue(artists.stream()
				.allMatch(a -> a.getCountries().stream().anyMatch(g -> g.getTag().equals(country.getKey()))));
	}

	@Test
	public void artistMoodFilter() {
		PlexSectionSecondaryDirectory<PlexArtist> mood = section.artistMoods().get(0);
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.MOOD).is(mood);
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
		assertTrue(artists.stream()
				.allMatch(a -> a.getMoods().stream().anyMatch(g -> g.getTag().equals(mood.getKey()))));
	}

	@Test
	public void artistStyleFilter() {
		PlexSectionSecondaryDirectory<PlexArtist> style = section.artistStyles().get(0);
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.STYLE).is(style);
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
		assertTrue(artists.stream()
				.allMatch(a -> a.getMoods().stream().anyMatch(g -> g.getTag().equals(style.getKey()))));
	}

	@Test
	public void artistCollectionFilter() {
		PlexSectionSecondaryDirectory<PlexArtist> collection = section.artistCollections().get(0);
		PlexFilter filter = PlexFilterBuilder.when(PlexArtist.COLLECTION).is(collection);
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
		assertTrue(artists.stream()
				.allMatch(a -> a.getMoods().stream().anyMatch(g -> g.getTag().equals(collection.getKey()))));
	}

	@Test
	public PlexFilter orFilter() {
		var artists = section.all().execute();
		PlexFilter filter = PlexFilterBuilder.or(
				PlexFilterBuilder.when(PlexArtist.TITLE).equals(artists.get(0).getTitle()),
				PlexFilterBuilder.when(PlexArtist.TITLE).equals(artists.get(1).getTitle()),
				PlexFilterBuilder.when(PlexArtist.TITLE).equals(artists.get(2).getTitle()));
		var results = section.all().filtered(filter).execute();
		assertEquals(3, results.size());
		assertTrue(results.stream().anyMatch(r -> r.getRatingKey().equals(artists.get(0).getRatingKey())));
		assertTrue(results.stream().anyMatch(r -> r.getRatingKey().equals(artists.get(1).getRatingKey())));
		assertTrue(results.stream().anyMatch(r -> r.getRatingKey().equals(artists.get(2).getRatingKey())));
		return filter;
	}

	@Test
	public PlexFilter andFilter() {
		PlexArtist anArtistWithASpaceInTheTitle = section.all().execute().stream()
				.filter(a -> a.getTitle().contains(" ")).findAny().get();
		String[] words = anArtistWithASpaceInTheTitle.getTitle().split(" ");
		PlexFilter filter = Arrays.stream(words).map(w -> PlexFilterBuilder.when(PlexArtist.TITLE).contains(w))
				.reduce(PlexFilterBuilder::and).get();
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		assertTrue(
				artists.stream().anyMatch(a -> a.getRatingKey().equals(anArtistWithASpaceInTheTitle.getRatingKey())));
		return filter;
	}

	@Test
	public void compositeFilter() {
		PlexFilter filter = PlexFilterBuilder.or(orFilter(), andFilter());
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		assertTrue(artists.size() > 0);
	}
}
