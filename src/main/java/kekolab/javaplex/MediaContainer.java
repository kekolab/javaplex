package kekolab.javaplex;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("MediaContainer")
class MediaContainer extends BaseItem {
	@JsonIgnore
	private boolean fetched;
	@JsonIgnore
	private final PlexHTTPClient client;
	@JsonIgnore
	private final Optional<String> token;
	@JsonIgnore
	private final URI uri;

	private Integer size;

	MediaContainer(URI uri, PlexHTTPClient client, Optional<String> token) {
		this.uri = uri;
		this.client = client;
		this.token = token;
		this.fetched = false;
	}

	void ensureFetched(Object field) {
		final boolean fieldIsNullOrEmpty = field == null || (field instanceof Collection collection && collection.isEmpty());
		if (!fetched && fieldIsNullOrEmpty) {
			// I set fetched to true here because Jackson will call the getters when deserializing
			// and the getters will call fetch, thus causing a StackOverflowException
			fetched = true; 
			try {
				client.get(token, this);
			} catch (RuntimeException e) {
				fetched = false;
				throw e;
			}
		}
	}

	@Deprecated
	protected void ensureFetched() {
		ensureFetched(null);
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getSize() {
		ensureFetched(size);
		return size;
	}

	@Deprecated
	public URI uri() {
		return uri;
	}

	URI getUri() {
		return uri;
	}

	@Deprecated
	protected PlexHTTPClient client() {
		return client;
	}

	PlexHTTPClient getClient() {
		return client;
	}

	@Deprecated
	protected String token() {
		return token.get();
	}

	Optional<String> getToken() {
		return token;
	}

	@Deprecated
	void fetched(boolean fetched) {
		this.fetched = fetched;
	}
}
