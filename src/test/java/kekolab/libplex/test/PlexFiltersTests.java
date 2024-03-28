package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexFilterBuilder;
import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexConnection;
import kekolab.javaplex.model.PlexDevice;
import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexFilteringTag;
import kekolab.javaplex.model.PlexLibrary;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;

public class PlexFiltersTests extends PlexTests {
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
	public void listArtistWithArtistTitleFilter() {
		PlexFilter filter = PlexFilterBuilder.whereArtistTitle().contains("Angelina");
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(1, artists.size());
	}

	@Test
	public void listAlbumsWithArtistTitleFilter() {
		PlexFilter filter = PlexFilterBuilder.whereArtistTitle().contains("Alanis");
		List<PlexAlbum> albums = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().albums(filter);
		albums.stream().map(PlexAlbum::getTitle).forEach(System.out::println);
	}

	@Test
	public void listTracksWithArtistTitleFilter() {
		PlexFilter filter = PlexFilterBuilder.whereArtistTitle().contains("Alanis");
		List<PlexTrack> albums = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().tracks(filter);
		albums.stream().map(PlexTrack::getTitle).forEach(System.out::println);
	}

	@Test
	public void artistUnmatchedFilter() {
		PlexFilter filter = PlexFilterBuilder.whereArtistUnmatched().isTrue();
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistGenreFilter() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilteringTag genreFilter = musicSection.genres().get(0);
		PlexFilter filter = PlexFilterBuilder.whereArtistGenre().is(genreFilter);
		System.out.println("Genre selected: " + genreFilter.getTitle());
		List<PlexArtist> artists = musicSection.all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistCountryFilter() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilteringTag tagFilter = musicSection.countries().get(0);
		PlexFilter filter = PlexFilterBuilder.whereArtistCountry().is(tagFilter);
		System.out.println("Country selected: " + tagFilter.getTitle());
		List<PlexArtist> artists = musicSection.all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistMoodFilter() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilteringTag tagFilter = musicSection.moods().get(1);
		PlexFilter filter = PlexFilterBuilder.whereArtistMood().is(tagFilter);
		List<PlexArtist> artists = musicSection.all(filter);
		System.out.println("Mood selected: " + tagFilter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistStyleFilter() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilteringTag tagFilter = musicSection.styles().get(0);
		PlexFilter filter = PlexFilterBuilder.whereArtistStyle().is(tagFilter);
		List<PlexArtist> artists = musicSection.all(filter);
		System.out.println("Style selected: " + tagFilter.getTitle());
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void artistCollectionFilter() {
		PlexMusicSection musicSection = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get();
		PlexFilteringTag tagFilter = musicSection.collectionsFilteringTags().get(0);
		PlexFilter filter = PlexFilterBuilder.whereArtistCollection().is(tagFilter);
		List<PlexTrack> artists = musicSection.tracks(filter);
		System.out.println("Collection selected: " + tagFilter.getTitle());
		artists.stream().map(PlexTrack::getTitle).forEach(System.out::println);
		assertTrue(artists.size() > 0);
	}

	@Test
	public void orFilter() {
		PlexFilter filter = PlexFilterBuilder.or(PlexFilterBuilder.whereArtistTitle().contains("Angelina"),
				PlexFilterBuilder.whereArtistTitle().contains("Alanis"),
				PlexFilterBuilder.whereArtistTitle().contains("Posse"));
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(3, artists.size());
	}

	@Test
	public void andFilter() {
		PlexFilter filter = PlexFilterBuilder.and(PlexFilterBuilder.whereArtistTitle().contains("l"),
				PlexFilterBuilder.whereArtistTitle().contains("m"));
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(2, artists.size());
	}

	@Test
	public void compoundFilter() {
		PlexFilter filter = PlexFilterBuilder.or(
				PlexFilterBuilder.and(PlexFilterBuilder.whereArtistTitle().contains("l"),
						PlexFilterBuilder.whereArtistTitle().contains("m")),
				PlexFilterBuilder.or(PlexFilterBuilder.whereArtistTitle().contains("Angelina"),
						PlexFilterBuilder.whereArtistTitle().contains("Alanis"),
						PlexFilterBuilder.whereArtistTitle().contains("Posse")));
		List<PlexArtist> artists = library.sections().stream().filter(PlexMusicSection.class::isInstance)
				.map(PlexMusicSection.class::cast).findAny().get().all(filter);
		artists.stream().map(PlexArtist::getTitle).forEach(System.out::println);
		assertEquals(5, artists.size());
	}
}
