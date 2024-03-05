package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.hc.core5.net.URIBuilder;

public class PlexServers extends ServerMediaContainer
{
	String friendlyName;
	String identifier;
	String machineIdentifier;
	int size;
	@JsonProperty("Server")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexServer> plexServersServers;

	public List<PlexServer> getServers()
	{
		fetch();
		plexServersServers.stream().filter(PlexServers.class::isInstance).map(PlexServers.class::cast);
		return plexServersServers;
	}

	public PlexServers(PlexMediaServer server, PlexHTTPClient client, String token) throws URISyntaxException
	{
		super(new URIBuilder("https://plex.tv/api/servers").build(), client, token, server);
	}

	@Override
	protected void clear()
	{
		super.clear();
		friendlyName = null;
		identifier = null;
		machineIdentifier = null;
		size = 0;
		plexServersServers.clear();
	}

	@Override
	protected void update(BaseItem source)
	{
		super.update(source);
		if (source instanceof PlexServers plexServers)
		{
			plexServersServers.clear();
			plexServersServers.addAll(plexServers.plexServersServers);
		}
		else
		{
			throw new ClassCastException("Cannot cast source to PlexServers");
		}
	}

	public String getFriendlyName()
	{
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName)
	{
		this.friendlyName = friendlyName;
	}

	public String getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getMachineIdentifier()
	{
		return machineIdentifier;
	}

	public void setMachineIdentifier(String machineIdentifier)
	{
		this.machineIdentifier = machineIdentifier;
	}

	public Integer getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}
}