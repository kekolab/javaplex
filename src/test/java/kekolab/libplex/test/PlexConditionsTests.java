package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.Conditions;
import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexCondition;
import kekolab.javaplex.model.PlexConnection;
import kekolab.javaplex.model.PlexDevice;
import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexLibrary;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;

public class PlexConditionsTests extends PlexTests {
	private PlexLibrary library;

	@BeforeEach
	public void init() {
		PlexDevice server = getApi().getResources().list().stream().filter(d -> d.isServer()).findAny().get();
		PlexConnection connection = server.getConnections().stream().filter(c -> c.getLocal() == 0).findAny()
				.orElseThrow();
		PlexMediaServer mediaServer = getApi().getMediaServer(connection);
		library = mediaServer.library();
	}
	
	@Test
	public void listArtistWithArtistTitleCondition() {
		PlexCondition filter = Conditions.ifArtistTitle().contains("Angelina");
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(1, artists.size());
	}

	@Test
	public void listAlbumsWithArtistTitleCondition() {
		PlexCondition filter = Conditions.ifArtistTitle().contains("Alanis");
		List<PlexAlbum> albums = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().albums(filter);
		albums.stream().map(PlexAlbum::getTitle).forEach(System.out::println);
	}

	@Test
	public void listTracksWithArtistTitleCondition() {
		PlexCondition filter = Conditions.ifArtistTitle().contains("Alanis");
		List<PlexTrack> albums = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().tracks(filter);
		albums.stream().map(PlexTrack::getTitle).forEach(System.out::println);
	}

	@Test
	public void artistUnmatchedCondition() {
		PlexCondition filter = Conditions.ifArtistUnmatched().isTrue();
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistGenreCondition() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilter genreFilter = musicSection.byGenre().get(0);
		PlexCondition filter = Conditions.ifArtistGenre().is(genreFilter);
		System.out.println("Genre selected: " + genreFilter.getTitle());
		List<PlexArtist> artists = musicSection.all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistCountryCondition() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilter tagFilter = musicSection.byCountry().get(0);
		PlexCondition filter = Conditions.ifArtistCountry().is(tagFilter);
		System.out.println("Country selected: " + tagFilter.getTitle());
		List<PlexArtist> artists = musicSection.all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistMoodCondition() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilter tagFilter = musicSection.byMood().get(1);
		PlexCondition filter = Conditions.ifArtistMood().is(tagFilter);
		List<PlexArtist> artists = musicSection.all(filter);
		System.out.println("Mood selected: " + tagFilter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistStyleCondition() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilter tagFilter = musicSection.byStyle().get(0);
		PlexCondition filter = Conditions.ifArtistStyle().is(tagFilter);
		List<PlexArtist> artists = musicSection.all(filter);
		System.out.println("Style selected: " + tagFilter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistCollectionCondition() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilter tagFilter = musicSection.byCollection().get(0);
		PlexCondition filter = Conditions.ifArtistCollection().is(tagFilter);
		List<PlexTrack> artists = musicSection.tracks(filter);
		System.out.println("Collection selected: " + tagFilter.getTitle());
		artists.stream().map(PlexTrack::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void orCondition() {
		PlexCondition filter = Conditions.or(Conditions.ifArtistTitle().contains("Angelina"),
				Conditions.ifArtistTitle().contains("Alanis"),
				Conditions.ifArtistTitle().contains("Posse"));
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(3, artists.size());
	}

	@Test
	public void andCondition() {
		PlexCondition filter = Conditions.and(Conditions.ifArtistTitle().contains("l"),
				Conditions.ifArtistTitle().contains("m"));
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(2, artists.size());
	}

	@Test
	public void compoundCondition() {
		PlexCondition filter = Conditions.or(
				Conditions.and(Conditions.ifArtistTitle().contains("l"),
						Conditions.ifArtistTitle().contains("m")),
				Conditions.or(Conditions.ifArtistTitle().contains("Angelina"),
						Conditions.ifArtistTitle().contains("Alanis"),
						Conditions.ifArtistTitle().contains("Posse")));
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(5, artists.size());
	}
}
