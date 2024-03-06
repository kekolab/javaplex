package kekolab.javaplex;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import kekolab.javaplex.mappers.BooleanDeserializer;
import kekolab.javaplex.mappers.TimestampDeserializer;

public class PlexServer extends BaseItem {
	private String accessToken;
	private String name;
	private String address;
	private String port;
	private String version;
	private String scheme;
	private String host;
	private String localAddresses;
	private String machineIdentifier;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date createdAt;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date updatedAt;
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean owned;
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean synced;
	@JsonProperty("Section")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexServer.Section> sections;

	@Override
	protected void clear() {
		super.clear();
		accessToken = null;
		address = null;
		createdAt = null;
		port = null;
		version = null;
		scheme = null;
		host = null;
		name = null;
		localAddresses = null;
		owned = null;
		machineIdentifier = null;
		updatedAt = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexServer plexServersServer) {
			accessToken = plexServersServer.accessToken;
			address = plexServersServer.address;
			createdAt = plexServersServer.createdAt;
			port = plexServersServer.port;
			version = plexServersServer.version;
			scheme = plexServersServer.scheme;
			host = plexServersServer.host;
			name = plexServersServer.name;
			localAddresses = plexServersServer.localAddresses;
			owned = plexServersServer.owned;
			machineIdentifier = plexServersServer.machineIdentifier;
			updatedAt = plexServersServer.updatedAt;
		} else {
			throw new ClassCastException("Cannot cast source to PlexServersServer");
		}
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getLocalAddresses() {
		return localAddresses;
	}

	public void setLocalAddresses(String localAddresses) {
		this.localAddresses = localAddresses;
	}

	public String getMachineIdentifier() {
		return machineIdentifier;
	}

	public void setMachineIdentifier(String machineIdentifier) {
		this.machineIdentifier = machineIdentifier;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getOwned() {
		return owned;
	}

	public void setOwned(Boolean owned) {
		this.owned = owned;
	}

	public Boolean getSynced() {
		return synced;
	}

	public void setSynced(Boolean synced) {
		this.synced = synced;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static class Section extends BaseItem {
		private Integer id;
		private String key;
		private String title;
		private String type;
		@JsonDeserialize(using = BooleanDeserializer.class)
		private Boolean shared;

		@Override
		protected void clear() {
			super.clear();
			id = null;
			key = null;
			title = null;
			type = null;
			shared = null;
		}

		@Override
		protected void update(BaseItem source) {
			super.update(source);
			if (source instanceof Section section) {
				id = section.id;
				key = section.key;
				title = section.title;
				type = section.title;
				shared = section.shared;
			}
		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Boolean getShared() {
			return shared;
		}
		public void setShared(Boolean shared) {
			this.shared = shared;
		}
	}
}
