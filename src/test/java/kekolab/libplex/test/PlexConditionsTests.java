package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexAlbum;
import kekolab.javaplex.PlexArtist;
import kekolab.javaplex.PlexConnection;
import kekolab.javaplex.PlexDevice;
import kekolab.javaplex.PlexLibrary;
import kekolab.javaplex.PlexMediaServer;
import kekolab.javaplex.PlexMusicSection;
import kekolab.javaplex.PlexSectionSecondaryDirectory;
import kekolab.javaplex.PlexTrack;
import kekolab.javaplex.filtering.PlexFilter;
import kekolab.javaplex.filtering.PlexFilterBuilder;

public class PlexConditionsTests extends PlexTests {
	private PlexLibrary library;
	private PlexMusicSection section;

	@BeforeEach
	public void init() {
		PlexDevice server = getApi().getResources().list().stream().filter(d -> d.isServer()).findAny().get();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		PlexMediaServer mediaServer = getApi().getMediaServer(connection);
		library = mediaServer.library();
		section = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
	}

	@Test
	public void listArtistWithArtistTitleCondition() {
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.TITLE).contains("Angelina");
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(1, artists.size());
	}

	@Test
	public void listAlbumsWithArtistTitleCondition() {
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.TITLE).contains("Alanis");
		List<PlexAlbum> albums = section.albums().filtered(condition).execute();
		albums.stream().map(PlexAlbum::getTitle).forEach(System.out::println);
	}

	@Test
	public void listTracksWithArtistTitleCondition() {
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.TITLE).contains("Alanis");
		List<PlexTrack> albums = section.tracks().filtered(condition).execute();
		albums.stream().map(PlexTrack::getTitle).forEach(System.out::println);
	}

	@Test
	public void artistUnmatchedCondition() {
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.UNMATCHED).isTrue();
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistGenreCondition() {
		PlexSectionSecondaryDirectory<PlexArtist> filter = section.artistGenres().get(0);
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.GENRE).is(filter);
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		System.out.println("Genre selected: " + filter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistCountryCondition() {
		PlexSectionSecondaryDirectory<PlexArtist> filter = section.artistCountries().get(0);
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.COUNTRY).is(filter);
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		System.out.println("Country selected: " + filter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistMoodCondition() {
		PlexSectionSecondaryDirectory<PlexArtist> filter = section.artistMoods().get(1);
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.MOOD).is(filter);
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		System.out.println("Mood selected: " + filter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistStyleCondition() {
		PlexSectionSecondaryDirectory<PlexArtist> filter = section.artistStyles().get(1);
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.STYLE).is(filter);
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		System.out.println("Style selected: " + filter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistCollectionCondition() {
		PlexSectionSecondaryDirectory<PlexArtist> filter = section.artistCollections().get(0);
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.COLLECTION).is(filter);
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		System.out.println("Collection selected: " + filter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void orCondition() {
		PlexFilter condition = PlexFilterBuilder.or(PlexFilterBuilder.when(PlexArtist.TITLE).contains("Angelina"),
				PlexFilterBuilder.when(PlexArtist.TITLE).contains("Alanis"),
				PlexFilterBuilder.when(PlexArtist.TITLE).contains("Posse"));
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(3, artists.size());
	}

	@Test
	public void andCondition() {
		PlexFilter filter = PlexFilterBuilder.and(PlexFilterBuilder.when(PlexArtist.TITLE).contains("l"),
				PlexFilterBuilder.when(PlexArtist.TITLE).contains("m"));
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(2, artists.size());
	}

	@Test
	public void compositeCondition() {
		PlexFilter filter = PlexFilterBuilder.or(
				PlexFilterBuilder.or(PlexFilterBuilder.when(PlexArtist.TITLE).contains("Angelina"),
						PlexFilterBuilder.when(PlexArtist.TITLE).contains("Alanis"),
						PlexFilterBuilder.when(PlexArtist.TITLE).contains("Posse")),
				PlexFilterBuilder.and(PlexFilterBuilder.when(PlexArtist.TITLE).contains("l"),
						PlexFilterBuilder.when(PlexArtist.TITLE).contains("m")));
		List<PlexArtist> artists = section.all().filtered(filter).execute();
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(5, artists.size());
	}
}
