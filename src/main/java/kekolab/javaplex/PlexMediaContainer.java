package kekolab.javaplex;

import java.net.URI;

import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("MediaContainer")
public class PlexMediaContainer extends BaseItem {
	@JsonIgnore
	private boolean fetched;
	@JsonIgnore
	private PlexHTTPClient client;
	@JsonIgnore
	private String token;
	@JsonIgnore
	private URI uri;

	private Integer size;

	protected void initialise(URI uri, PlexHTTPClient client, String token) {
		this.uri = uri;
		this.client = client;
		this.token = token;
	}

	public PlexMediaContainer(URI uri, PlexHTTPClient client, String token) {
		this.uri = uri;
		this.client = client;
		this.token = token;
		this.fetched = false;
	}

	@Override
	protected void clear() {
		super.clear();
		size = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexMediaContainer mediaContainer) {
			size = mediaContainer.size;
		} else
			throw new ClassCastException("Cannot cast source to PlexMediaContainer");
	}

	protected void fetch() {
		if (!fetched) {
			fetched = true;
			try {
				client.executeAndUpdateFromResponse(ClassicRequestBuilder.get(uri).build(), this, token);
			} catch (Exception e) {
				fetched = false;
				throw new PlexException(e);
			}
		}
	}

	public void refresh() {
		clear();
		fetched = false;
		fetch();
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getSize() {
		fetch();
		return size;
	}

	public URI uri() {
		return uri;
	}

	protected PlexHTTPClient client() {
		return client;
	}

	protected String token() {
		return token;
	}

	void fetched(boolean fetched) {
		this.fetched = fetched;
	}
}
