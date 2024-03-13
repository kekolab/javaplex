package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.function.Consumer;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexMediatag;

class GenericCollectionsHelper {
	private Metadata target;
	private Optional<String> token;
	private PlexHTTPClient client;
	private Consumer<Playlist<?>> updateCallback;
	private MediaServer server;

	GenericCollectionsHelper(Playlist<?> target) {
		this.target = target;
		this.client = target.getClient();
		this.server = target.getServer();
		this.token = target.getToken();
		this.updateCallback = target::update;
	}

	GenericCollectionsHelper(Collection<?, ?> target) {
		this.target = target;
		this.client = target.getClient();
		this.server = target.getServer();
		this.token = target.getToken();
		this.updateCallback = target::update;
	}

	protected void add(PlexMediatag<?> mediatag) {
		URI uri;
		try {
			uri = new URIBuilder(target.key()).addParameter("uri", mediatag.serverSchemeUri(server).toString()).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}

		client.put(uri, token, Optional.empty());
		MetadataContainer<Playlist<?>, ?> container = new MetadataContainer<>(target.ratingKey(), client, token, server);
		updateCallback.accept(container.getMetadata().get(0));
	}

	protected void remove(URI uri) {
		MetadataContainer<Playlist<?>, ?> container = new MetadataContainer<>(uri, client, token, server);
		updateCallback.accept(client.delete(token, container).getMetadata().get(0));
	}
}
