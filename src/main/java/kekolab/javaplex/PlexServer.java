package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import kekolab.javaplex.mappers.BooleanDeserializer;
import kekolab.javaplex.mappers.SharingSettings;
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

	@JsonIgnore
	private PlexHTTPClient client;
	@JsonIgnore
	private String token;
	@JsonIgnore
	private boolean detailed;

	public PlexServer() {
		detailed = false;
		sections = new ArrayList<>();
	}

	void setToken(String token) {
		this.token = token;
	}

	void setClient(PlexHTTPClient client) {
		this.client = client;
	}

	private boolean isDetailed() {
		return detailed;
	}

	private void setDetailed(boolean detailed) {
		this.detailed = detailed;
	}

	public List<PlexServer.Section> getSections() throws URISyntaxException {
		if (!isDetailed() && sections.size() == 0) {
			update(JunkMediaContainer.forPlexServer(client, token, getMachineIdentifier()).getServers().get(0));
			setDetailed(true);
		}
		return sections;
	}

	public List<PlexServerShare> serverShares() throws URISyntaxException {
		return JunkMediaContainer.forPlexServerShares(client, token, machineIdentifier).getServerShares();
	}

	/**
	 * Invites a friend using default settings. <br />
	 * <br />
	 * {@code SharingSettings.allowCameraUpload = false} <br />
	 * <br />
	 * {@code SharingSettings.allowChannels = false} <br />
	 * <br />
	 * {@code SharingSettings.allowSync = false} <br />
	 * <br />
	 * and with no filters
	 * 
	 * @param usernameOrEmail
	 * @param sections
	 * @return
	 * @throws URISyntaxException
	 */
	public PlexServerShare inviteFriend(String usernameOrEmail, List<PlexServer.Section> sections)
			throws URISyntaxException {
		SharingSettings defaults = new SharingSettings();
		defaults.setAllowCameraUpload(false);
		defaults.setAllowChannels(false);
		defaults.setAllowSync(false);
		return inviteFriend(usernameOrEmail, sections, defaults);
	}

	public PlexServerShare inviteFriend(String usernameOrEmail, List<PlexServer.Section> sections,
			SharingSettings sharingSettings) throws URISyntaxException {
		Objects.requireNonNull(usernameOrEmail);
		Objects.requireNonNull(sections);
		Objects.requireNonNull(sharingSettings);

		InviteRequest inviteRequest = new InviteRequest();
		inviteRequest.setServerId(getMachineIdentifier());
		InviteRequest.SharedServer sharedServer = new InviteRequest.SharedServer();
		sharedServer.setInvitedEmail(usernameOrEmail);
		sharedServer.setLibrarySectionIds(sections.stream().map(PlexServer.Section::getId).toList());
		inviteRequest.setSharedServer(sharedServer);

		inviteRequest.setSharingSettings(sharingSettings);

		URI uri = new URIBuilder(JunkMediaContainer.PLEX_SERVER_SHARES_URI_TEMPLATE.replace("{machineIdentifier}",
				getMachineIdentifier())).build();
		ClassicRequestBuilder requestBuilder = ClassicRequestBuilder.post(uri).setHeader("Content-Type",
				"application/json");
		return client.executeAndCreateFromResponse(requestBuilder, inviteRequest, "application/json",
				JunkMediaContainer.class, token).getServerShares().get(0);
	}
	public void setSections(List<PlexServer.Section> sections) {
		this.sections = sections;
	}

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
		if (source instanceof PlexServer plexServer) {
			accessToken = plexServer.accessToken;
			address = plexServer.address;
			createdAt = plexServer.createdAt;
			port = plexServer.port;
			version = plexServer.version;
			scheme = plexServer.scheme;
			host = plexServer.host;
			name = plexServer.name;
			localAddresses = plexServer.localAddresses;
			owned = plexServer.owned;
			machineIdentifier = plexServer.machineIdentifier;
			updatedAt = plexServer.updatedAt;
			sections.clear();
			sections.addAll(plexServer.sections);
		} else {
			throw new ClassCastException("Cannot cast source to PlexServer");
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
			} else {
				throw new ClassCastException("Cannot case BaseItem to PlexServer.Section");
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
