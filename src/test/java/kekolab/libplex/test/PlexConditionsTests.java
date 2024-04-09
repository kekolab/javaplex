package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexConnection;
import kekolab.javaplex.model.PlexDevice;
import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexFilterBuilder;
import kekolab.javaplex.model.PlexLibrary;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexSectionSecondaryDirectory;
import kekolab.javaplex.model.PlexTrack;

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
		PlexSectionSecondaryDirectory filter = section.byGenre().get(0);
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.GENRE).is(filter);
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		System.out.println("Genre selected: " + filter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistCountryCondition() {
		PlexSectionSecondaryDirectory filter = section.byCountry().get(0);
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.COUNTRY).is(filter);
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		System.out.println("Country selected: " + filter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistMoodCondition() {
		PlexSectionSecondaryDirectory filter = section.byMood().get(1);
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.MOOD).is(filter);
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		System.out.println("Mood selected: " + filter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistStyleCondition() {
		PlexSectionSecondaryDirectory filter = section.byStyle().get(1);
		PlexFilter condition = PlexFilterBuilder.when(PlexArtist.STYLE).is(filter);
		List<PlexArtist> artists = section.all().filtered(condition).execute();
		System.out.println("Style selected: " + filter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistCollectionCondition() {
		PlexSectionSecondaryDirectory filter = section.byCollection().get(0);
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
