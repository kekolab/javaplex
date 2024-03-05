package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import static kekolab.javaplex.PlexHTTPClient.PARAMETER_X_PLEX_TOKEN;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

public class PlexServersSharedServers extends ServerMediaContainer
{
	@JsonProperty("SharedServer")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexSharedServer> plexSharedServers;

	public void setMachineIdentifier(String machineIdentifier)
	{
		this.machineIdentifier = machineIdentifier;
	}

	private String friendlyName;
	private String identifier;
	private String machineIdentifier;
	private int size;

	public List<PlexSharedServer> getServers()
	{
		fetch();
		plexSharedServers.stream().filter(PlexSharedServer.class::isInstance).map(PlexSharedServer.class::cast);
		return plexSharedServers;
	}

	// todo wrap this up some how
	public void sendInvite(PlexSharedServer sharedServer)
	{
		fetch();
//		ClassicHttpRequest request = ClassicRequestBuilder
//			.post(uri()).addParameter(sharedServer.friendRequestBuilder(sharedServer.getPlexServersSharedServersSections(), ))
//			.build();
	}

	public PlexServersSharedServers(PlexMediaServer server, PlexHTTPClient client, String token) throws URISyntaxException
	{
		super(new URIBuilder("https://plex.tv/api/servers").appendPath(server.getMachineIdentifier()).appendPath("shared_servers").addParameter(PARAMETER_X_PLEX_TOKEN, token).build(), client, token, server);
	}

	@Override
	protected void clear()
	{
		super.clear();
		friendlyName = null;
		identifier = null;
		machineIdentifier = null;
		size = 0;
		plexSharedServers.clear();
	}

	@Override
	protected void update(BaseItem source)
	{
		super.update(source);
		if (source instanceof PlexServersSharedServers plexServersSharedServers)
		{
			plexServersSharedServers.clear();
			plexSharedServers.addAll(plexServersSharedServers.plexSharedServers);
		}
		else
		{
			throw new ClassCastException("Cannot cast source to PlexResources");
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

	public Integer getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}
}
