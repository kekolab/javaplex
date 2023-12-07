package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Consumer;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

public class GenericCollectionsHelper {
	private PlexMetadata target;
	private String token;
	private PlexHTTPClient client;
	private Consumer<BaseItem> updateCallback;
	private PlexMediaServer server;

	protected GenericCollectionsHelper(PlexPlaylist<?> target) {
		this.target = target;
		this.client = target.getClient();
		this.server = target.server();
		this.token = target.getToken();
		this.updateCallback = target::update;
	}

	protected GenericCollectionsHelper(PlexCollection<?, ?> target) {
		this.target = target;
		this.client = target.getClient();
		this.server = target.server();
		this.token = target.getToken();
		this.updateCallback = target::update;
	}

	protected void add(PlexMediatag<?> mediatag) {
		URI uri;
		try {
			uri = new URIBuilder(target.key()).addParameter("uri", mediatag.serverSchemeUri().toString()).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		ClassicHttpRequest request = ClassicRequestBuilder.put(uri).build();
		MetadataContainer<PlexMetadata, ?> container = new MetadataContainer<>(target.ratingKey(), client, token, server);
		client.executeAndUpdateFromResponse(request, container, token);
		PlexMetadata collection = container.getMetadata().get(0);
		updateCallback.accept(collection);
	}

	protected void remove(URI uri) {
		MetadataContainer<PlexMetadata, ?> container = new MetadataContainer<>(uri, client, token, server);
		ClassicHttpRequest request = ClassicRequestBuilder.delete(uri).build();
		client.executeAndUpdateFromResponse(request, container, token);
		container.fetched(true);
		PlexMetadata collection = container.getMetadata().get(0);
		updateCallback.accept(collection);
	}
}
