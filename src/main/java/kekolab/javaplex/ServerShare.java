package kekolab.javaplex;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import kekolab.javaplex.mappers.BooleanDeserializer;
import kekolab.javaplex.mappers.TimestampDeserializer;
import kekolab.javaplex.model.PlexServer;
import kekolab.javaplex.model.PlexServerShare;

public class ServerShare extends BaseItem implements PlexServerShare {
	// TODO Delete a PlexServerShare. To do so, send a DELETE to the endpoint
    // https://clients.plex.tv/api/v2/shared_servers/{id}

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
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean allowSync;
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean allowCameraUpload;
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean allowChannels;
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean allowTuners;
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean allowSubtitleAdmin;
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean owned;
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean allLibraries;
	private String filterAll;
	private String filterMovies;
	private String filterMusic;
	private String filterPhotos;
	private String filterTelevision;
	@JsonProperty("Section")
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonDeserialize(contentAs = Server.Section.class)
	private List<PlexServer.Section> sections;

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	@Override
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Date getAcceptedAt() {
		return acceptedAt;
	}

	public void setAcceptedAt(Date acceptedAt) {
		this.acceptedAt = acceptedAt;
	}

	@Override
	public Date getInvitedAt() {
		return invitedAt;
	}

	public void setInvitedAt(Date invitedAt) {
		this.invitedAt = invitedAt;
	}

	@Override
	public Boolean getAllowSync() {
		return allowSync;
	}

	public void setAllowSync(Boolean allowSync) {
		this.allowSync = allowSync;
	}

	@Override
	public Boolean getAllowCameraUpload() {
		return allowCameraUpload;
	}

	public void setAllowCameraUpload(Boolean allowCameraUpload) {
		this.allowCameraUpload = allowCameraUpload;
	}

	@Override
	public Boolean getAllowChannels() {
		return allowChannels;
	}

	public void setAllowChannels(Boolean allowChannels) {
		this.allowChannels = allowChannels;
	}

	@Override
	public Boolean getAllowTuners() {
		return allowTuners;
	}

	public void setAllowTuners(Boolean allowTuners) {
		this.allowTuners = allowTuners;
	}

	@Override
	public Boolean getAllowSubtitleAdmin() {
		return allowSubtitleAdmin;
	}

	public void setAllowSubtitleAdmin(Boolean allowSubtitleAdmin) {
		this.allowSubtitleAdmin = allowSubtitleAdmin;
	}

	@Override
	public Boolean getOwned() {
		return owned;
	}

	public void setOwned(Boolean owned) {
		this.owned = owned;
	}

	@Override
	public Boolean getAllLibraries() {
		return allLibraries;
	}

	public void setAllLibraries(Boolean allLibraries) {
		this.allLibraries = allLibraries;
	}

	@Override
	public String getFilterAll() {
		return filterAll;
	}

	public void setFilterAll(String filterAll) {
		this.filterAll = filterAll;
	}

	@Override
	public String getFilterMovies() {
		return filterMovies;
	}

	public void setFilterMovies(String filterMovies) {
		this.filterMovies = filterMovies;
	}

	@Override
	public String getFilterMusic() {
		return filterMusic;
	}

	public void setFilterMusic(String filterMusic) {
		this.filterMusic = filterMusic;
	}

	@Override
	public String getFilterPhotos() {
		return filterPhotos;
	}

	public void setFilterPhotos(String filterPhotos) {
		this.filterPhotos = filterPhotos;
	}

	@Override
	public String getFilterTelevision() {
		return filterTelevision;
	}

	public void setFilterTelevision(String filterTelevision) {
		this.filterTelevision = filterTelevision;
	}

	@Override
	public List<PlexServer.Section> getSections() {
		return sections;
	}

	public void setSections(List<PlexServer.Section> sections) {
		this.sections = sections;
	}
}
