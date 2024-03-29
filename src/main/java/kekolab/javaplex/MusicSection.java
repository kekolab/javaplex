package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Function;

import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexAlbumFilter;
import kekolab.javaplex.model.PlexAlbumOrTrackFilter;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistFilter;
import kekolab.javaplex.model.PlexArtistOrAlbumFilter;
import kekolab.javaplex.model.PlexArtistOrAlbumOrTrackFilter;
import kekolab.javaplex.model.PlexCondition;
import kekolab.javaplex.model.PlexMetadata;
import kekolab.javaplex.model.PlexMusicCollections;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackFilter;

class MusicSection extends Section<PlexArtist, PlexAlbum> implements PlexMusicSection {

	public List<PlexAlbum> albums() {
		return executeRequestAndCastMetadata("albums", PlexAlbum.class);
	}

	@Override
	public PlexMusicCollections collections() {
		return new MusicCollections(this);
	}

	@Override
	public List<PlexTrack> tracks() {
		return executeRequestAndCastMetadata("allLeaves", PlexTrack.class);
	}

	@Override
	public List<PlexArtist> all(PlexCondition filter) {
		URIBuilder builder = new URIBuilder(key()).appendPath("all");
		for (String queryParameter : filter.getConditionQuery().split("&")) {
			String[] keyValuePair = queryParameter.split("=");
			builder.addParameter(new BasicNameValuePair(keyValuePair[0], keyValuePair[1]));
		}

		try {
			MetadataContainer<PlexArtist, ?> metadataContainer = new MetadataContainer<>(builder.build(), getServer());
			return metadataContainer.getMetadata();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexAlbum> albums(PlexCondition filter) {
		URIBuilder builder = new URIBuilder(key()).appendPath("all").addParameter("type",
				Integer.toString(PlexAlbum.TYPE_ID));
		for (String queryParameter : filter.getConditionQuery().split("&")) {
			String[] keyValuePair = queryParameter.split("=");
			builder.addParameter(new BasicNameValuePair(keyValuePair[0], keyValuePair[1]));
		}

		try {
			MetadataContainer<PlexAlbum, ?> metadataContainer = new MetadataContainer<>(builder.build(), getServer());
			return metadataContainer.getMetadata();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexTrack> tracks(PlexCondition filter) {
		URIBuilder builder = new URIBuilder(key()).appendPath("all").addParameter("type",
				Integer.toString(PlexTrack.TYPE_ID));
		for (String queryParameter : filter.getConditionQuery().split("&")) {
			String[] keyValuePair = queryParameter.split("=");
			builder.addParameter(new BasicNameValuePair(keyValuePair[0], keyValuePair[1]));
		}

		try {
			MetadataContainer<PlexTrack, ?> metadataContainer = new MetadataContainer<>(builder.build(), getServer());
			return metadataContainer.getMetadata();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	private <T> List<T> bySomething(String by, Function<Filter, T> function) {
		try {
			URI uri = new URIBuilder(key()).appendPath(by).build();
			return new MetadataContainer<PlexMetadata, Filter>(uri, getServer()).getDirectories().stream()
					.map(function).toList();
		} catch (URISyntaxException e) {
			throw new PlexException(e); // TODO
		}
	}

	@Override
	public List<PlexArtistOrAlbumFilter> byGenre() {
		return bySomething("genre", f -> new ArtistOrAlbumFilter(f, this));
	}

	@Override
	public List<PlexArtistOrAlbumOrTrackFilter> byMood() {
		return bySomething("mood", f -> new ArtistOrAlbumOrTrackFilter(f, this));

	}

	@Override
	public List<PlexArtistOrAlbumFilter> byStyle() {
		return bySomething("style", f -> new ArtistOrAlbumFilter(f, this));
	}

	@Override
	public List<PlexArtistFilter> byCountry() {
		return bySomething("country", f -> new ArtistFilter(f, this));
	}

	@Override
	public List<PlexArtistOrAlbumFilter> byCollection() {
		return bySomething("collection", f -> new ArtistOrAlbumFilter(f, this));
	}

	@Override
	public List<PlexAlbumFilter> byYear() {
		return bySomething("year", f -> new AlbumFilter(f, this));
	}

	@Override
	public List<PlexAlbumFilter> byDecade() {
		return bySomething("decade", f -> new AlbumFilter(f, this));
	}

	@Override
	public List<PlexAlbumFilter> byStudio() {
		return bySomething("studio", f -> new AlbumFilter(f, this));
	}

	@Override
	public List<PlexAlbumFilter> byFormat() {
		return bySomething("format", f -> new AlbumFilter(f, this));
	}

	@Override
	public List<PlexAlbumFilter> bySubformat() {
		return bySomething("subformat", f -> new AlbumFilter(f, this));
	}

	@Override
	public List<PlexAlbumOrTrackFilter> bySource() {
		return bySomething("subformat", f -> new AlbumOrTrackFilter(f, this));
	}

	@Override
	public List<PlexAlbumFilter> byLabel() {
		return bySomething("label", f -> new AlbumFilter(f, this));
	}

	@Override
	public List<PlexTrackFilter> byUserRating() {
		return bySomething("userRating", f -> new TrackFilter(f, this));
	}
}
