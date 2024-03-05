package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.Date;
import java.util.List;
import kekolab.javaplex.mappers.TimestampDeserializer;

public class PlexSharedServer extends BaseItem
{
	private String id;
	private String username;
	private String email;
	private String userID;
	private String accessToken;
	private String name;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date acceptedAt;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date invitedAt;
	private String allowSync;
	private String allowCameraUpload;
	private String allowChannels;
	private String allowTuners;
	private String allowSubtitleAdmin;
	private String owned;
	private String allLibraries;
	private String filterAll;
	private String filterMovies;
	private String filterMusic;
	private String filterPhotos;
	private String filterTelevision;

	@JsonProperty("Section")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexServersSharedServersSection> plexServersSharedServersSections;

	@Override
	protected void clear()
	{
		super.clear();
		id = null;
		username = null;
		email = null;
		userID = null;
		accessToken = null;
		name = null;
		acceptedAt = null;
		invitedAt = null;
		allowSync = null;
		allowCameraUpload = null;
		allowChannels = null;
		allowTuners = null;
		allowSubtitleAdmin = null;
		owned = null;
		allLibraries = null;
		filterAll = null;
		filterMovies = null;
		filterMusic = null;
		filterPhotos = null;
		filterTelevision = null;
		plexServersSharedServersSections.clear();
	}

	@Override
	protected void update(BaseItem source)
	{
		super.update(source);
		if (source instanceof PlexSharedServer plexServersServer)
		{
			plexServersSharedServersSections.clear();
			plexServersSharedServersSections.addAll(plexServersServer.plexServersSharedServersSections);
			id = plexServersServer.id;
			username = plexServersServer.username;
			email = plexServersServer.email;
			userID = plexServersServer.userID;
			accessToken = plexServersServer.accessToken;
			name = plexServersServer.name;
			acceptedAt = plexServersServer.acceptedAt;
			invitedAt = plexServersServer.invitedAt;
			allowSync = plexServersServer.allowSync;
			allowCameraUpload = plexServersServer.allowCameraUpload;
			allowChannels = plexServersServer.allowChannels;
			allowTuners = plexServersServer.allowTuners;
			allowSubtitleAdmin = plexServersServer.allowSubtitleAdmin;
			owned = plexServersServer.owned;
			allLibraries = plexServersServer.allLibraries;
			filterAll = plexServersServer.filterAll;
			filterMovies = plexServersServer.filterMovies;
			filterMusic = plexServersServer.filterMusic;
			filterPhotos = plexServersServer.filterPhotos;
			filterTelevision = plexServersServer.filterTelevision;
		}
		else
		{
			throw new ClassCastException("Cannot cast source to PlexSharedServer");
		}
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUserID()
	{
		return userID;
	}

	public void setUserID(String userID)
	{
		this.userID = userID;
	}

	public String getAccessToken()
	{
		return accessToken;
	}

	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getAcceptedAt()
	{
		return acceptedAt;
	}

	public void setAcceptedAt(Date acceptedAt)
	{
		this.acceptedAt = acceptedAt;
	}

	public Date getInvitedAt()
	{
		return invitedAt;
	}

	public void setInvitedAt(Date invitedAt)
	{
		this.invitedAt = invitedAt;
	}

	public String getAllowSync()
	{
		return allowSync;
	}

	public void setAllowSync(String allowSync)
	{
		this.allowSync = allowSync;
	}

	public String getAllowCameraUpload()
	{
		return allowCameraUpload;
	}

	public void setAllowCameraUpload(String allowCameraUpload)
	{
		this.allowCameraUpload = allowCameraUpload;
	}

	public String getAllowChannels()
	{
		return allowChannels;
	}

	public void setAllowChannels(String allowChannels)
	{
		this.allowChannels = allowChannels;
	}

	public String getAllowTuners()
	{
		return allowTuners;
	}

	public void setAllowTuners(String allowTuners)
	{
		this.allowTuners = allowTuners;
	}

	public String getAllowSubtitleAdmin()
	{
		return allowSubtitleAdmin;
	}

	public void setAllowSubtitleAdmin(String allowSubtitleAdmin)
	{
		this.allowSubtitleAdmin = allowSubtitleAdmin;
	}

	public String getOwned()
	{
		return owned;
	}

	public void setOwned(String owned)
	{
		this.owned = owned;
	}

	public String getAllLibraries()
	{
		return allLibraries;
	}

	public void setAllLibraries(String allLibraries)
	{
		this.allLibraries = allLibraries;
	}

	public String getFilterAll()
	{
		return filterAll;
	}

	public void setFilterAll(String filterAll)
	{
		this.filterAll = filterAll;
	}

	public String getFilterMovies()
	{
		return filterMovies;
	}

	public void setFilterMovies(String filterMovies)
	{
		this.filterMovies = filterMovies;
	}

	public String getFilterMusic()
	{
		return filterMusic;
	}

	public void setFilterMusic(String filterMusic)
	{
		this.filterMusic = filterMusic;
	}

	public String getFilterPhotos()
	{
		return filterPhotos;
	}

	public void setFilterPhotos(String filterPhotos)
	{
		this.filterPhotos = filterPhotos;
	}

	public String getFilterTelevision()
	{
		return filterTelevision;
	}

	public void setFilterTelevision(String filterTelevision)
	{
		this.filterTelevision = filterTelevision;
	}

	public List<PlexServersSharedServersSection> getPlexServersSharedServersSections()
	{
		return plexServersSharedServersSections;
	}

	// todo wrap this up some how
	public String friendRequestBuilder(List<String> sections, String email, String allowSync, String allowCameraUpload, String allowChannels, String filterMovies, String filterTelevision, String filterMusic)
	{
		return "{" +
			"  \"server_id\": \"\"," +
			"  \"shared_server\": {\"library_section_ids\" : " + sections.toString() + ", \"invited_email\": \"" + email + "\"}," +
			"  \"sharing_settings\":" +
			"  {" +
			"    \"allowSync\": \"" + allowSync + "\"," +
			"    \"allowCameraUpload\": \"" + allowCameraUpload+ "\"," +
			"    \"allowChannels\": \""+allowChannels+"\"," +
			"    \"filterMovies\": "+filterMovies+"," +
			"    \"filterTelevision\": "+filterTelevision+"," +
			"    \"filterMusic\": "+filterMusic+
			"  }" +
			"}";
	}
}
