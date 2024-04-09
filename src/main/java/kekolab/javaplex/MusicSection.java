package kekolab.javaplex;

import java.util.List;

import org.apache.hc.core5.http.message.BasicNameValuePair;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexAlbumSecondaryDirectory;
import kekolab.javaplex.model.PlexAlbumOrTrackSecondaryDirectory;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistSecondaryDirectory;
import kekolab.javaplex.model.PlexArtistOrAlbumSecondaryDirectory;
import kekolab.javaplex.model.PlexArtistOrAlbumOrTrackSecondaryDirectory;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexSectionQueryBuilder;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackSecondaryDirectory;

public class MusicSection extends Section implements PlexMusicSection {

	@Override
	public PlexSectionQueryBuilder<PlexArtist> all() {
				return new SectionQueryBuilder<PlexArtist>()
				.withSection(this)
				.withPath("all");
	}

	@Override
	public List<PlexAlbum> recentlyAdded() {
		return new SectionQueryBuilder<PlexAlbum>()
				.withSection(this)
				.withPath("recentlyAdded")
				.execute();
	}

	@Override
	public PlexSectionQueryBuilder<PlexAlbum> albums() {
		return new SectionQueryBuilder<PlexAlbum>()
				.withSection(this)
				.withPath("all")
				.addParameter(new BasicNameValuePair("type", Integer.toString(PlexAlbum.TYPE_ID)));
	}

	@Override
	public PlexSectionQueryBuilder<PlexTrack> tracks() {
		return new SectionQueryBuilder<PlexTrack>()
				.withSection(this)
				.withPath("all")
				.addParameter(new BasicNameValuePair("type", Integer.toString(PlexTrack.TYPE_ID)));
	}

	@Override
	public MusicCollections collections() {
		return new MusicCollections(this);
	}

	@Override
	public List<PlexArtistOrAlbumSecondaryDirectory> byGenre() {
		return byFeature("genre", f -> new ArtistOrAlbumSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexArtistOrAlbumOrTrackSecondaryDirectory> byMood() {
		return byFeature("mood", f -> new ArtistOrAlbumOrTrackSecondaryDirectory(f, this));

	}

	@Override
	public List<PlexArtistOrAlbumSecondaryDirectory> byStyle() {
		return byFeature("style", f -> new ArtistOrAlbumSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexArtistSecondaryDirectory> byCountry() {
		return byFeature("country", f -> new ArtistFilter(f, this));
	}

	@Override
	public List<PlexArtistOrAlbumSecondaryDirectory> byCollection() {
		return byFeature("collection", f -> new ArtistOrAlbumSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexAlbumSecondaryDirectory> byYear() {
		return byFeature("year", f -> new AlbumSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexAlbumSecondaryDirectory> byDecade() {
		return byFeature("decade", f -> new AlbumSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexAlbumSecondaryDirectory> byStudio() {
		return byFeature("studio", f -> new AlbumSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexAlbumSecondaryDirectory> byFormat() {
		return byFeature("format", f -> new AlbumSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexAlbumSecondaryDirectory> bySubformat() {
		return byFeature("subformat", f -> new AlbumSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexAlbumOrTrackSecondaryDirectory> bySource() {
		return byFeature("subformat", f -> new AlbumOrTrackSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexAlbumSecondaryDirectory> byLabel() {
		return byFeature("label", f -> new AlbumSecondaryDirectory(f, this));
	}

	@Override
	public List<PlexTrackSecondaryDirectory> byUserRating() {
		return byFeature("userRating", f -> new TrackSecondaryDirectory(f, this));
	}
}