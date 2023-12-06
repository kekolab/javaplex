package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;

public class PlexConnection extends BaseItem {
	private String protocol;
	private String address;
	private Integer port;
	private String uri;
	private Integer local;

	@Override
	protected void clear() {
		super.clear();
		address = null;
		local = null;
		port = null;
		protocol = null;
		uri = null;
	}

	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexConnection connection) {
			address = connection.address;
			local = connection.local;
			port = connection.port;
			protocol = connection.protocol;
			uri = connection.uri;
		} else
			throw new ClassCastException("Cannot cast source to PlexConnection");
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getLocal() {
		return local;
	}

	public void setLocal(Integer local) {
		this.local = local;
	}

	public URI uri() {
		if (uri != null)
			try {
				return new URI(uri);
			} catch (URISyntaxException e) {
				throw new PlexException(e);
			}
		return null;
	}
}