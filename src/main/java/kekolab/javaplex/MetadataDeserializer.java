package kekolab.javaplex;

import java.io.IOException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexAlbumCollection;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexArtistCollection;
import kekolab.javaplex.model.PlexAudioPlaylist;
import kekolab.javaplex.model.PlexClip;
import kekolab.javaplex.model.PlexCollection;
import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexEpisodeCollection;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexMetadata;
import kekolab.javaplex.model.PlexMovie;
import kekolab.javaplex.model.PlexMovieCollection;
import kekolab.javaplex.model.PlexPhoto;
import kekolab.javaplex.model.PlexPhotoPlaylist;
import kekolab.javaplex.model.PlexPhotoalbum;
import kekolab.javaplex.model.PlexPlaylist;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexSeasonCollection;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowCollection;
import kekolab.javaplex.model.PlexTrack;
import kekolab.javaplex.model.PlexTrackCollection;
import kekolab.javaplex.model.PlexVideoPlaylist;

public class MetadataDeserializer extends ObjectNodeDeserializer<PlexMetadata> {
	private static final long serialVersionUID = 7550593827443213344L;

	public MetadataDeserializer() {
		super(PlexMetadata.class);
	}

	protected Class<? extends PlexMetadata> chooseDeserializingClass(ObjectNode node) throws IOException {
		if (node.has("type")) {
			String type = extractTextFieldValueFromObjectNode(node, "type");
			if (type.equals(PlexArtist.TYPE_DESCRIPTION))
				return Artist.class;
			if (type.equals(PlexAlbum.TYPE_DESCRIPTION))
				return Album.class;
			if (type.equals(PlexTrack.TYPE_DESCRIPTION))
				return Track.class;
			if (type.equals(PlexShow.TYPE_DESCRIPTION))
				return Show.class;
			if (type.equals(PlexSeason.TYPE_DESCRIPTION))
				return Season.class;
			if (type.equals(PlexEpisode.TYPE_DESCRIPTION))
				return Episode.class;
			if (type.equals(PlexMovie.TYPE_DESCRIPTION))
				return Movie.class;
			if (type.equals(PlexClip.TYPE_DESCRIPTION))
				return Clip.class;
			if (type.equals(PlexPhoto.TYPE_DESCRIPTION) || (type.equals(PlexPhotoalbum.TYPE_DESCRIPTION))) // They're
																											// actually
																											// the
																											// same
				return chooseDeserializingClassForPhotoMetadataType(node);
			if (type.equals(PlexPlaylist.TYPE_DESCRIPTION))
				return chooseDeserializingClassForPlaylist(node);
			if (type.equals(PlexCollection.TYPE_DESCRIPTION))
				return chooseDeserializingClassForCollection(node);
			// TODO Log that it was impossible to deserialize the PlexMetadata with this
			// type
			throw new IOException("Cannot determine the right class to deserialize metadata with type " + type);
		}
		throw new IOException(
				"Cannot determine the right class to deserialize metadata. PlexMetadata has no `type` attribute");
		/*
		 * TODO Should we think about a default implementation for PlexMetadata (just
		 * like with PlexDirectory)? Right now PlexMetadata is abstract
		 */
	}

	private Class<? extends PlexMediatag<?>> chooseDeserializingClassForPhotoMetadataType(ObjectNode node) {
		if (node.has("composite"))
			return Photoalbum.class;
		return Photo.class;
	}

	private Class<? extends PlexPlaylist<?>> chooseDeserializingClassForPlaylist(ObjectNode node) throws IOException {
		String subtype = extractTextFieldValueFromObjectNode(node, "playlistType");
		if (subtype.equals(PlexAudioPlaylist.SUBTYPE_DESCRIPTION))
			return AudioPlaylist.class;
		if (subtype.equals(PlexVideoPlaylist.SUBTYPE_DESCRIPTION))
			return VideoPlaylist.class;
		if (subtype.equals(PlexPhotoPlaylist.SUBTYPE_DESCRIPTION))
			return PhotoPlaylist.class;
		throw new IOException(
				"Cannot determine the right class to deserialize playlist with subtype " + subtype);
	}

	private Class<? extends PlexCollection<?, ?>> chooseDeserializingClassForCollection(ObjectNode node)
			throws IOException {
		String subtype = extractTextFieldValueFromObjectNode(node, "subtype");
		if (subtype.equals(PlexMovieCollection.SUBTYPE_DESCRIPTION))
			return MovieCollection.class;
		if (subtype.equals(PlexArtistCollection.SUBTYPE_DESCRIPTION))
			return ArtistCollection.class;
		if (subtype.equals(PlexAlbumCollection.SUBTYPE_DESCRIPTION))
			return AlbumCollection.class;
		if (subtype.equals(PlexTrackCollection.SUBTYPE_DESCRIPTION))
			return TrackCollection.class;
		if (subtype.equals(PlexShowCollection.SUBTYPE_DESCRIPTION))
			return ShowCollection.class;
		if (subtype.equals(PlexSeasonCollection.SUBTYPE_DESCRIPTION))
			return SeasonCollection.class;
		if (subtype.equals(PlexEpisodeCollection.SUBTYPE_DESCRIPTION))
			return EpisodeCollection.class;
		throw new IOException(
				"Cannot determine the right class to deserialize collection with subtype " + subtype);
	}
}
