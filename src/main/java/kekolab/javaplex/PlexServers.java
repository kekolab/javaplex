package kekolab.javaplex;

import java.net.URISyntaxException;
import java.util.List;
import java.util.ArrayList;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class PlexServers extends PlexMediaContainer {
	String friendlyName;
	String identifier;
	String machineIdentifier;
	@JsonProperty("Server")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexServer> servers;

	public List<PlexServer> getServers() {
		fetch();
		return servers;
	}

	public PlexServers(PlexHTTPClient client, String token) throws URISyntaxException {
		super(new URIBuilder("https://plex.tv/api/servers").build(), client, token);
		servers = new ArrayList<>();
	}

	@Override
	protected void clear() {
		super.clear();
		friendlyName = null;
		identifier = null;
		machineIdentifier = null;
		servers.clear();
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexServers plexServers) {
			friendlyName = plexServers.friendlyName;
			identifier = plexServers.identifier;
			machineIdentifier = plexServers.machineIdentifier;
			servers.addAll(plexServers.servers);
		} else {
			throw new ClassCastException("Cannot cast source to PlexServers");
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