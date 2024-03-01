package kekolab.javaplex.mappers;

import java.io.IOException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import kekolab.javaplex.PlexAlbum;
import kekolab.javaplex.PlexAlbumCollection;
import kekolab.javaplex.PlexArtist;
import kekolab.javaplex.PlexArtistCollection;
import kekolab.javaplex.PlexAudioPlaylist;
import kekolab.javaplex.PlexClip;
import kekolab.javaplex.PlexCollection;
import kekolab.javaplex.PlexEpisode;
import kekolab.javaplex.PlexEpisodeCollection;
import kekolab.javaplex.PlexMediatag;
import kekolab.javaplex.PlexMetadata;
import kekolab.javaplex.PlexMovie;
import kekolab.javaplex.PlexMovieCollection;
import kekolab.javaplex.PlexPhoto;
import kekolab.javaplex.PlexPhotoPlaylist;
import kekolab.javaplex.PlexPhotoalbum;
import kekolab.javaplex.PlexPlaylist;
import kekolab.javaplex.PlexSeason;
import kekolab.javaplex.PlexSeasonCollection;
import kekolab.javaplex.PlexShow;
import kekolab.javaplex.PlexShowCollection;
import kekolab.javaplex.PlexTrack;
import kekolab.javaplex.PlexTrackCollection;
import kekolab.javaplex.PlexVideoPlaylist;

public class MetadataDeserializer extends ObjectNodeDeserializer<PlexMetadata> {
	private static final long serialVersionUID = 7550593827443213344L;

	public MetadataDeserializer() {
		super(PlexMetadata.class);
	}

	protected Class<? extends PlexMetadata> chooseDeserializingClass(ObjectNode node) throws IOException {
		if (node.has("type")) {
			String type = extractTextFieldValueFromObjectNode(node, "type");
			if (type.equals(PlexArtist.TYPE_DESCRIPTION))
				return PlexArtist.class;
			if (type.equals(PlexAlbum.TYPE_DESCRIPTION))
				return PlexAlbum.class;
			if (type.equals(PlexTrack.TYPE_DESCRIPTION))
				return PlexTrack.class;
			if (type.equals(PlexShow.TYPE_DESCRIPTION))
				return PlexShow.class;
			if (type.equals(PlexSeason.TYPE_DESCRIPTION))
				return PlexSeason.class;
			if (type.equals(PlexEpisode.TYPE_DESCRIPTION))
				return PlexEpisode.class;
			if (type.equals(PlexMovie.TYPE_DESCRIPTION))
				return PlexMovie.class;
			if (type.equals(PlexClip.TYPE_DESCRIPTION))
				return PlexClip.class;
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
			return PlexPhotoalbum.class;
		return PlexPhoto.class;
	}

	private Class<? extends PlexPlaylist<?>> chooseDeserializingClassForPlaylist(ObjectNode node) throws IOException {
		String subtype = extractTextFieldValueFromObjectNode(node, "playlistType");
		if (subtype.equals(PlexAudioPlaylist.SUBTYPE_DESCRIPTION))
			return PlexAudioPlaylist.class;
		if (subtype.equals(PlexVideoPlaylist.SUBTYPE_DESCRIPTION))
			return PlexVideoPlaylist.class;
		if (subtype.equals(PlexPhotoPlaylist.SUBTYPE_DESCRIPTION))
			return PlexPhotoPlaylist.class;
		throw new IOException(
				"Cannot determine the right class to deserialize playlist with subtype " + subtype);
	}

	private Class<? extends PlexCollection<?, ?>> chooseDeserializingClassForCollection(ObjectNode node)
			throws IOException {
		String subtype = extractTextFieldValueFromObjectNode(node, "subtype");
		if (subtype.equals(PlexMovieCollection.SUBTYPE_DESCRIPTION))
			return PlexMovieCollection.class;
		if (subtype.equals(PlexArtistCollection.SUBTYPE_DESCRIPTION))
			return PlexArtistCollection.class;
		if (subtype.equals(PlexAlbumCollection.SUBTYPE_DESCRIPTION))
			return PlexAlbumCollection.class;
		if (subtype.equals(PlexTrackCollection.SUBTYPE_DESCRIPTION))
			return PlexTrackCollection.class;
		if (subtype.equals(PlexShowCollection.SUBTYPE_DESCRIPTION))
			return PlexShowCollection.class;
		if (subtype.equals(PlexSeasonCollection.SUBTYPE_DESCRIPTION))
			return PlexSeasonCollection.class;
		if (subtype.equals(PlexEpisodeCollection.SUBTYPE_DESCRIPTION))
			return PlexEpisodeCollection.class;
		throw new IOException(
				"Cannot determine the right class to deserialize collection with subtype " + subtype);
	}
}
