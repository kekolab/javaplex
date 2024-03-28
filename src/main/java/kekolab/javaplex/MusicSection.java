package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexAlbum;
import kekolab.javaplex.model.PlexArtist;
import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexFilteringTag;
import kekolab.javaplex.model.PlexMusicCollections;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexTrack;

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
	public List<PlexArtist> all(PlexFilter filter) {
		URIBuilder builder = new URIBuilder(key()).appendPath("all");
		for (String queryParameter : filter.getQueryString().split("&")) {
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
	public List<PlexFilteringTag> genres() {
		try {
			URI uri = new URIBuilder(key()).appendPath("genre").build();
			MetadataContainer<?, PlexFilteringTag> metadataContainer = new MetadataContainer<>(uri, getServer());
			return metadataContainer.getDirectories();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexFilteringTag> countries() {
		try {
			URI uri = new URIBuilder(key()).appendPath("country").build();
			MetadataContainer<?, PlexFilteringTag> metadataContainer = new MetadataContainer<>(uri, getServer());
			return metadataContainer.getDirectories();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexFilteringTag> moods() {
		try {
			URI uri = new URIBuilder(key()).appendPath("mood").build();
			MetadataContainer<?, PlexFilteringTag> metadataContainer = new MetadataContainer<>(uri, getServer());
			return metadataContainer.getDirectories();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexFilteringTag> styles() {
		try {
			URI uri = new URIBuilder(key()).appendPath("style").build();
			MetadataContainer<?, PlexFilteringTag> metadataContainer = new MetadataContainer<>(uri, getServer());
			return metadataContainer.getDirectories();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexFilteringTag> collectionsFilteringTags() {
		try {
			URI uri = new URIBuilder(key()).appendPath("collection").build();
			MetadataContainer<?, PlexFilteringTag> metadataContainer = new MetadataContainer<>(uri, getServer());
			return metadataContainer.getDirectories();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexFilteringTag> formats() {
		try {
			URI uri = new URIBuilder(key()).appendPath("format").build();
			MetadataContainer<?, PlexFilteringTag> metadataContainer = new MetadataContainer<>(uri, getServer());
			return metadataContainer.getDirectories();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexFilteringTag> subformats() {
		try {
			URI uri = new URIBuilder(key()).appendPath("subformat").build();
			MetadataContainer<?, PlexFilteringTag> metadataContainer = new MetadataContainer<>(uri, getServer());
			return metadataContainer.getDirectories();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexFilteringTag> sources() {
		try {
			URI uri = new URIBuilder(key()).appendPath("source").build();
			MetadataContainer<?, PlexFilteringTag> metadataContainer = new MetadataContainer<>(uri, getServer());
			return metadataContainer.getDirectories();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexFilteringTag> labels() {
		try {
			URI uri = new URIBuilder(key()).appendPath("label").build();
			MetadataContainer<?, PlexFilteringTag> metadataContainer = new MetadataContainer<>(uri, getServer());
			return metadataContainer.getDirectories();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new PlexException(e);
		}
	}

	@Override
	public List<PlexAlbum> albums(PlexFilter filter) {
		URIBuilder builder = new URIBuilder(key()).appendPath("all").addParameter("type", Integer.toString(PlexAlbum.TYPE_ID));
		for (String queryParameter : filter.getQueryString().split("&")) {
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
	public List<PlexTrack> tracks(PlexFilter filter) {
		URIBuilder builder = new URIBuilder(key()).appendPath("all").addParameter("type", Integer.toString(PlexTrack.TYPE_ID));
		for (String queryParameter : filter.getQueryString().split("&")) {
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
}
