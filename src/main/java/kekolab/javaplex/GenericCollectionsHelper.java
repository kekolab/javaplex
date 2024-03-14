package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexCollection;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexMetadata;
import kekolab.javaplex.model.PlexPlaylist;

class GenericCollectionsHelper {
	private final PlexMetadata target;
	private final MediaServer server;


	GenericCollectionsHelper(PlexPlaylist<?> target, MediaServer server) {
		this((PlexMetadata) target, server);
	}

	GenericCollectionsHelper(PlexCollection<?, ?> target, MediaServer server) {
		this((PlexMetadata) target, server);
	}

	private GenericCollectionsHelper(PlexMetadata target, MediaServer server) {
		this.target = target;
		this.server = server;
	}

	PlexMetadata add(PlexMediatag<?> mediatag) {
		URI uri;
		try {
			uri = new URIBuilder(target.key()).addParameter("uri", mediatag.serverSchemeUri(server).toString()).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}

		server.getClient().put(uri, server.getToken(), Optional.empty());
		MetadataContainer<PlexMetadata, ?> container = new MetadataContainer<>(target.ratingKey(), server);
		return container.getMetadata().get(0);
	}

	PlexMetadata remove(URI uri) {
		MetadataContainer<PlexMetadata, ?> container = new MetadataContainer<>(uri, server);
		return server.getClient().delete(server.getToken(), container).getMetadata().get(0);
	}
}
