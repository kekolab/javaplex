package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import static kekolab.javaplex.PlexHTTPClient.PARAMETER_X_PLEX_TOKEN;
import org.apache.hc.core5.net.URIBuilder;

public class PlexServer extends PlexMediaContainer
{
	@JsonIgnore
	private static URI uri;
	private static String plexServerToken;
	String friendlyName;
	String identifier;
	String machineIdentifier;
	int size;
	@JsonProperty("Server")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexServersServer> plexServersServers;

	public List<PlexServersServer> getServers()
	{
		fetch();
		plexServersServers.stream().filter(PlexServer.class::isInstance).map(PlexServer.class::cast);
		return plexServersServers;
	}

	public PlexServer(PlexHTTPClient client, String token)
	{
		super(buildUri(), client, token);
		plexServerToken = token;
		plexServersServers = new ArrayList<>();
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
		if (source instanceof PlexServer plexServer)
		{
			plexServersServers.clear();
			plexServersServers.addAll(plexServer.plexServersServers);
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

	private static URI buildUri()
	{
		if (uri == null)
		{
			try
			{
				uri = new URIBuilder("https://plex.tv/api/servers/")
					.addParameter(PARAMETER_X_PLEX_TOKEN, plexServerToken)
					.build();
			}
			catch (URISyntaxException e)
			{
				throw new PlexException(e);
			}
		}
		return uri;
	}
}