package kekolab.javaplex;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class PlexSharedServers extends PlexMediaContainer {
	@JsonProperty("SharedServer")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexSharedServer> sharedServers; // TODO Is it always one (we call it woth the machineIdentifier) or is it a list depending on the shares?
	private String friendlyName;
	private String identifier;
	private String machineIdentifier;

	public List<PlexSharedServer> getSharedServers() {
		fetch();
		return sharedServers;
	}

		// TODO What is this call supposed to return?
	public BaseItem inviteFriend(String email, List<PlexServer.Section> sections, InviteRequest.SharingSettings sharingSettings) {
		InviteRequest inviteRequestEntity = new InviteRequest();
		inviteRequestEntity.setServerId(getMachineIdentifier());
		
		InviteRequest.SharedServer sharedServer = new InviteRequest.SharedServer();
		sharedServer.setInvitedEmail(email);
		sharedServer.setLibrarySectionIds(sections.stream().map(PlexServer.Section::getId).toList());
		inviteRequestEntity.setSharedServer(sharedServer);

		inviteRequestEntity.setSharingSettings(sharingSettings);

		return client().executeAndCreateFromResponse(ClassicRequestBuilder.post(uri()), inviteRequestEntity, "application/json", BaseItem.class, token());
	}

	public PlexSharedServers(String machineIdentifier, PlexHTTPClient client, String token) throws URISyntaxException {
		super(new URIBuilder("https://plex.tv/api/servers").appendPath(machineIdentifier).appendPath("shared_servers").build(), client, token);
		sharedServers = new ArrayList<>();
	}

	public PlexSharedServers(PlexServer server, PlexHTTPClient client, String token) throws URISyntaxException {
		this(server.getMachineIdentifier(), client, token);
	}

	public PlexSharedServers(PlexMediaServer server, PlexHTTPClient client, String token) throws URISyntaxException {
		this(server.getMachineIdentifier(), client, token);
	}

	@Override
	protected void clear() {
		super.clear();
		friendlyName = null;
		identifier = null;
		machineIdentifier = null;
		sharedServers.clear();
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexSharedServers plexSharedServers) {
			friendlyName = plexSharedServers.friendlyName;
			identifier = plexSharedServers.identifier;
			machineIdentifier = plexSharedServers.machineIdentifier;
			sharedServers.addAll(plexSharedServers.sharedServers);
		} else {
			throw new ClassCastException("Cannot cast source to PlexSharedServers");
		}
	}

	public String getFriendlyName() {
		fetch();
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getIdentifier() {
		fetch();
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getMachineIdentifier() {
		fetch();
		return machineIdentifier;
	}

	public void setMachineIdentifier(String machineIdentifier) {
		this.machineIdentifier = machineIdentifier;
	}
}
