package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.IntegerListDeserializer;
import kekolab.javaplex.mappers.StringListDeserializer;
import kekolab.javaplex.mappers.TimestampDeserializer;

/**
 * This class represents a Plex Media Server (public or local) and maps the XML
 * that the client receive when a GET to the homepage of the server is executed
 *
 */
public class PlexMediaServer extends PlexMediaContainer {
	private Boolean allowCameraUpload;
	private Boolean allowChannelAccess;
	private Boolean allowMediaDeletion;
	private Boolean allowSharing;
	private Boolean allowSync;
	private Boolean allowTuners;
	private Boolean backgroundProcessing;
	private Boolean certificate;
	private Boolean companionProxy;
	private String countryCode;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> diagnostics = new ArrayList<>();
	private Boolean eventStream;
	private String friendlyName;
	private Boolean hubSearch;
	private Boolean itemClusters;
	private Integer livetv;
	private String machineIdentifier;
	private Boolean mediaProviders;
	private Boolean multiuser;
	private Boolean myPlex;
	private String myPlexMappingState;
	private String myPlexSigninState;
	private Boolean myPlexSubscription;
	private String myPlexUsername;
	private Integer offlineTranscode;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> ownerFeatures = new ArrayList<>();
	private Boolean photoAutoTag;
	private String platform;
	private String platformVersion;
	private Boolean pluginHost;
	private Boolean pushNotifications;
	private Boolean readOnlyLibraries;
	private Integer requestParametersInCookie;
	private Integer streamingBrainABRVersion;
	private Integer streamingBrainVersion;
	private Boolean sync;
	private Integer transcoderActiveVideoSessions;
	private Boolean transcoderAudio;
	private Boolean transcoderLyrics;
	private Boolean transcoderPhoto;
	private Boolean transcoderSubtitles;
	private Boolean transcoderVideo;
	@JsonDeserialize(using = IntegerListDeserializer.class)
	private List<Integer> transcoderVideoBitrates = new ArrayList<>();
	@JsonDeserialize(using = IntegerListDeserializer.class)
	private List<Integer> transcoderVideoQualities = new ArrayList<>();
	@JsonDeserialize(using = IntegerListDeserializer.class)
	private List<Integer> transcoderVideoResolutions = new ArrayList<>();
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date updatedAt;
	private Boolean updater;
	private String version;
	private Boolean voiceSearch;

	public PlexMediaServer(URI uri, PlexHTTPClient client, String token) {
		super(uri, client, token);
	}

	public PlexMediaServer(PlexConnection connection, PlexHTTPClient client, String token) {
		this(connection.uri(), client, token);
	}


	@Override
	protected void clear() {
		super.clear();
		allowCameraUpload = null;
		allowChannelAccess = null;
		allowMediaDeletion = null;
		allowSharing = null;
		allowSync = null;
		allowTuners = null;
		backgroundProcessing = null;
		certificate = null;
		companionProxy = null;
		countryCode = null;
		diagnostics.clear();
		eventStream = null;
		friendlyName = null;
		hubSearch = null;
		itemClusters = null;
		livetv = null;
		machineIdentifier = null;
		mediaProviders = null;
		multiuser = null;
		myPlex = null;
		myPlexMappingState = null;
		myPlexSigninState = null;
		myPlexSubscription = null;
		myPlexUsername = null;
		offlineTranscode = null;
		ownerFeatures.clear();
		photoAutoTag = null;
		platform = null;
		platformVersion = null;
		pluginHost = null;
		pushNotifications = null;
		readOnlyLibraries = null;
		requestParametersInCookie = null;
		streamingBrainABRVersion = null;
		streamingBrainABRVersion = null;
		sync = null;
		transcoderActiveVideoSessions = null;
		transcoderAudio = null;
		transcoderLyrics = null;
		transcoderPhoto = null;
		transcoderSubtitles = null;
		transcoderVideo = null;
		transcoderVideoBitrates.clear();
		transcoderVideoQualities.clear();
		transcoderVideoResolutions.clear();
		updatedAt = null;
		updater = null;
		version = null;
		voiceSearch = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexMediaServer mediaServer) {
			allowCameraUpload = mediaServer.allowCameraUpload;
			allowChannelAccess = mediaServer.allowChannelAccess;
			allowMediaDeletion = mediaServer.allowMediaDeletion;
			allowSharing = mediaServer.allowSharing;
			allowSync = mediaServer.allowSync;
			allowTuners = mediaServer.allowTuners;
			backgroundProcessing = mediaServer.backgroundProcessing;
			certificate = mediaServer.certificate;
			companionProxy = mediaServer.companionProxy;
			countryCode = mediaServer.countryCode;
			diagnostics = mediaServer.diagnostics;
			eventStream = mediaServer.eventStream;
			friendlyName = mediaServer.friendlyName;
			hubSearch = mediaServer.hubSearch;
			itemClusters = mediaServer.itemClusters;
			livetv = mediaServer.livetv;
			machineIdentifier = mediaServer.machineIdentifier;
			mediaProviders = mediaServer.mediaProviders;
			multiuser = mediaServer.multiuser;
			myPlex = mediaServer.myPlex;
			myPlexMappingState = mediaServer.myPlexMappingState;
			myPlexSigninState = mediaServer.myPlexSigninState;
			myPlexSubscription = mediaServer.myPlexSubscription;
			myPlexUsername = mediaServer.myPlexUsername;
			offlineTranscode = mediaServer.offlineTranscode;
			ownerFeatures = mediaServer.ownerFeatures;
			photoAutoTag = mediaServer.photoAutoTag;
			platform = mediaServer.platform;
			platformVersion = mediaServer.platformVersion;
			pluginHost = mediaServer.pluginHost;
			pushNotifications = mediaServer.pushNotifications;
			readOnlyLibraries = mediaServer.readOnlyLibraries;
			requestParametersInCookie = mediaServer.requestParametersInCookie;
			streamingBrainABRVersion = mediaServer.streamingBrainABRVersion;
			streamingBrainVersion = mediaServer.streamingBrainVersion;
			sync = mediaServer.sync;
			transcoderActiveVideoSessions = mediaServer.transcoderActiveVideoSessions;
			transcoderAudio = mediaServer.transcoderAudio;
			transcoderLyrics = mediaServer.transcoderLyrics;
			transcoderPhoto = mediaServer.transcoderPhoto;
			transcoderSubtitles = mediaServer.transcoderSubtitles;
			transcoderVideo = mediaServer.transcoderVideo;
			transcoderVideoBitrates = mediaServer.transcoderVideoBitrates;
			transcoderVideoQualities = mediaServer.transcoderVideoQualities;
			transcoderVideoResolutions = mediaServer.transcoderVideoResolutions;
			updatedAt = mediaServer.updatedAt;
			updater = mediaServer.updater;
			version = mediaServer.version;
			voiceSearch = mediaServer.voiceSearch;
		} else
			throw new ClassCastException("Cannot cast source to PlexMediaServer");
	}

	/**
	 * 
	 * @return the allowCameraUpload attribute of the Plex Media Server
	 * @
	 */

	public Boolean getAllowCameraUpload() {
		fetch();
		return allowCameraUpload;
	}

	/**
	 * 
	 * @return the allowChannelAccess attribute of the Plex Media Server
	 */

	public Boolean getAllowChannelAccess() {
		fetch();
		return allowChannelAccess;
	}

	/**
	 * 
	 * @return the allowMediaDeletion attribute of the Plex Media Server
	 */

	public Boolean getAllowMediaDeletion() {
		fetch();
		return allowMediaDeletion;
	}

	/**
	 * 
	 * @return the allowSharing attribute of the Plex Media Server
	 */

	public Boolean getAllowSharing() {
		fetch();
		return allowSharing;
	}

	/**
	 * 
	 * @return the allowSync attribute of the Plex Media Server
	 */

	public Boolean getAllowSync() {
		fetch();
		return allowSync;
	}

	/**
	 * 
	 * @return the allowTuners attribute of the Plex Media Server
	 */

	public Boolean getAllowTuners() {
		fetch();
		return allowTuners;
	}

	/**
	 * 
	 * @return the backgroundProcessing attribute of the Plex Media Server
	 */

	public Boolean getBackgroundProcessing() {
		fetch();
		return backgroundProcessing;
	}

	/**
	 * 
	 * @return the certificate attribute of the Plex Media Server
	 */

	public Boolean getCertificate() {
		fetch();
		return certificate;
	}

	/**
	 * 
	 * @return the companionProxy attribute of the Plex Media Server
	 */

	public Boolean getCompanionProxy() {
		fetch();
		return companionProxy;
	}

	/**
	 * 
	 * @return the countryCode attribute of the Plex Media Server
	 */

	public String getCountryCode() {
		fetch();
		return countryCode;
	}

	/**
	 * 
	 * @return the diagnostics attribute of the Plex Media Server
	 */

	public List<String> getDiagnostics() {
		fetch();
		return diagnostics;
	}

	/**
	 * 
	 * @return the eventStream attribute of the Plex Media Server
	 */

	public Boolean getEventStream() {
		fetch();
		return eventStream;
	}

	/**
	 * 
	 * @return the friendlyName attribute of the Plex Media Server
	 */

	public String getFriendlyName() {
		fetch();
		return friendlyName;
	}

	/**
	 * 
	 * @return the hubSearch attribute of the Plex Media Server
	 */

	public Boolean getHubSearch() {
		fetch();
		return hubSearch;
	}

	/**
	 * 
	 * @return the itemClusters attribute of the Plex Media Server
	 */

	public Boolean getItemClusters() {
		fetch();
		return itemClusters;
	}

	/**
	 * 
	 * @return the liveTv attribute of the Plex Media Server
	 */

	public Integer getLivetv() {
		fetch();
		return livetv;
	}

	/**
	 * 
	 * @return the machineIdentifier attribute of the Plex Media Server
	 */

	public String getMachineIdentifier() {
		fetch();
		return machineIdentifier;
	}

	/**
	 * 
	 * @return the mediaProviders attribute of the Plex Media Server
	 */

	public Boolean getMediaProviders() {
		fetch();
		return mediaProviders;
	}

	/**
	 * 
	 * @return the multiuser attribute of the Plex Media Server
	 */

	public Boolean getMultiuser() {
		fetch();
		return multiuser;
	}

	/**
	 * 
	 * @return the myPlex attribute of the Plex Media Server
	 */

	public Boolean getMyPlex() {
		fetch();
		return myPlex;
	}

	/**
	 * 
	 * @return the myPlexMappingState attribute of the Plex Media Server
	 */

	public String getMyPlexMappingState() {
		fetch();
		return myPlexMappingState;
	}

	/**
	 * 
	 * @return the myPlexSigninState attribute of the Plex Media Server
	 */

	public String getMyPlexSigninState() {
		fetch();
		return myPlexSigninState;
	}

	/**
	 * 
	 * @return the myPlexSubscription attribute of the Plex Media Server
	 */

	public Boolean getMyPlexSubscription() {
		fetch();
		return myPlexSubscription;
	}

	/**
	 * 
	 * @return the myPlexUsername attribute of the Plex Media Server
	 */

	public String getMyPlexUsername() {
		fetch();
		return myPlexUsername;
	}

	/**
	 * 
	 * @return the offlineTranscode attribute of the Plex Media Server
	 */

	public Integer getOfflineTranscode() {
		fetch();
		return offlineTranscode;
	}

	/**
	 * 
	 * @return the ownerFeatures attribute of the Plex Media Server
	 */

	public List<String> getOwnerFeatures() {
		fetch();
		return ownerFeatures;
	}

	/**
	 * 
	 * @return the photoAutoTag attribute of the Plex Media Server
	 */

	public Boolean getPhotoAutoTag() {
		fetch();
		return photoAutoTag;
	}

	/**
	 * 
	 * @return the platform attribute of the Plex Media Server
	 */

	public String getPlatform() {
		fetch();
		return platform;
	}

	/**
	 * 
	 * @return the platformVersion attribute of the Plex Media Server
	 */

	public String getPlatformVersion() {
		fetch();
		return platformVersion;
	}

	/**
	 * 
	 * @return the pluginHost attribute of the Plex Media Server
	 */

	public Boolean getPluginHost() {
		fetch();
		return pluginHost;
	}

	/**
	 * 
	 * @return the pushNotifications attribute of the Plex Media Server
	 */

	public Boolean getPushNotifications() {
		fetch();
		return pushNotifications;
	}

	/**
	 * 
	 * @return the readOnlyLibraries attribute of the Plex Media Server
	 */

	public Boolean getReadOnlyLibraries() {
		fetch();
		return readOnlyLibraries;
	}

	/**
	 * 
	 * @return the requestParametersInCookie attribute of the Plex Media Server
	 */

	public Integer getRequestParametersInCookie() {
		fetch();
		return requestParametersInCookie;
	}

	/**
	 * 
	 * @return the streamingBrainABRVersion attribute of the Plex Media Server
	 */

	public Integer getStreamingBrainABRVersion() {
		fetch();
		return streamingBrainABRVersion;
	}

	/**
	 * 
	 * @return the streamingBrainVersion attribute of the Plex Media Server
	 */

	public Integer getStreamingBrainVersion() {
		fetch();
		return streamingBrainVersion;
	}

	/**
	 * 
	 * @return the sync attribute of the Plex Media Server
	 */

	public Boolean getSync() {
		fetch();
		return sync;
	}

	/**
	 * 
	 * @return the transcoderActiveVideoSessions attribute of the Plex Media Server
	 */

	public Integer getTranscoderActiveVideoSessions() {
		fetch();
		return transcoderActiveVideoSessions;
	}

	/**
	 * 
	 * @return the transcoderAudio attribute of the Plex Media Server
	 */

	public Boolean getTranscoderAudio() {
		fetch();
		return transcoderAudio;
	}

	/**
	 * 
	 * @return the transcoderLyrics attribute of the Plex Media Server
	 */

	public Boolean getTranscoderLyrics() {
		fetch();
		return transcoderLyrics;
	}

	/**
	 * 
	 * @return the transcoderPhoto attribute of the Plex Media Server
	 */

	public Boolean getTranscoderPhoto() {
		fetch();
		return transcoderPhoto;
	}

	/**
	 * 
	 * @return the transcoderSubtitles attribute of the Plex Media Server
	 */

	public Boolean getTranscoderSubtitles() {
		fetch();
		return transcoderSubtitles;
	}

	/**
	 * 
	 * @return the transcoderVideo attribute of the Plex Media Server
	 */

	public Boolean getTranscoderVideo() {
		fetch();
		return transcoderVideo;
	}

	/**
	 * 
	 * @return the transcoderVideoBitrates attribute of the Plex Media Server
	 */

	public List<Integer> getTranscoderVideoBitrates() {
		fetch();
		return transcoderVideoBitrates;
	}

	/**
	 * 
	 * @return the transcoderVideoQualities attribute of the Plex Media Server
	 */

	public List<Integer> getTranscoderVideoQualities() {
		fetch();
		return transcoderVideoQualities;
	}

	/**
	 * 
	 * @return the transcoderVideoResolutions attribute of the Plex Media Server
	 */

	public List<Integer> getTranscoderVideoResolutions() {
		fetch();
		return transcoderVideoResolutions;
	}

	/**
	 * 
	 * @return the updatedAt attribute of the Plex Media Server
	 */

	public Date getUpdatedAt() {
		fetch();
		return updatedAt;
	}

	/**
	 * 
	 * @return the updater attribute of the Plex Media Server
	 */

	public Boolean getUpdater() {
		fetch();
		return updater;
	}

	/**
	 * 
	 * @return the version attribute of the Plex Media Server
	 */

	public String getVersion() {
		fetch();
		return version;
	}

	/**
	 * 
	 * @return the voiceSearch attribute of the Plex Media Server
	 */

	public Boolean getVoiceSearch() {
		fetch();
		return voiceSearch;
	}

	public void setAllowCameraUpload(Boolean allowCameraUpload) {
		this.allowCameraUpload = allowCameraUpload;
	}

	public void setAllowChannelAccess(Boolean allowChannelAccess) {
		this.allowChannelAccess = allowChannelAccess;
	}

	public void setAllowMediaDeletion(Boolean allowMediaDeletion) {
		this.allowMediaDeletion = allowMediaDeletion;
	}

	public void setAllowSharing(Boolean allowSharing) {
		this.allowSharing = allowSharing;
	}

	public void setAllowSync(Boolean allowSync) {
		this.allowSync = allowSync;
	}

	public void setAllowTuners(Boolean allowTuners) {
		this.allowTuners = allowTuners;
	}

	public void setBackgroundProcessing(Boolean backgroundProcessing) {
		this.backgroundProcessing = backgroundProcessing;
	}

	public void setCertificate(Boolean certificate) {
		this.certificate = certificate;
	}

	public void setCompanionProxy(Boolean companionProxy) {
		this.companionProxy = companionProxy;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setDiagnostics(List<String> diagnostics) {
		this.diagnostics = diagnostics;
	}

	public void setEventStream(Boolean eventStream) {
		this.eventStream = eventStream;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public void setHubSearch(Boolean hubSearch) {
		this.hubSearch = hubSearch;
	}

	public void setItemClusters(Boolean itemClusters) {
		this.itemClusters = itemClusters;
	}

	public void setLivetv(Integer liveTv) {
		this.livetv = liveTv;
	}

	public void setMachineIdentifier(String machineIdentifier) {
		this.machineIdentifier = machineIdentifier;
	}

	public void setMediaProviders(Boolean mediaProviders) {
		this.mediaProviders = mediaProviders;
	}

	public void setMultiuser(Boolean multiuser) {
		this.multiuser = multiuser;
	}

	public void setMyPlex(Boolean myPlex) {
		this.myPlex = myPlex;
	}

	public void setMyPlexMappingState(String myPlexMappingState) {
		this.myPlexMappingState = myPlexMappingState;
	}

	public void setMyPlexSigninState(String myPlexSigninState) {
		this.myPlexSigninState = myPlexSigninState;
	}

	public void setMyPlexSubscription(Boolean myPlexSubscription) {
		this.myPlexSubscription = myPlexSubscription;
	}

	public void setMyPlexUsername(String myPlexUsername) {
		this.myPlexUsername = myPlexUsername;
	}

	public void setOfflineTranscode(Integer offlineTranscode) {
		this.offlineTranscode = offlineTranscode;
	}

	public void setOwnerFeatures(List<String> ownerFeatures) {
		this.ownerFeatures = ownerFeatures;
	}

	public void setPhotoAutoTag(Boolean photoAutoTag) {
		this.photoAutoTag = photoAutoTag;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public void setPluginHost(Boolean pluginHost) {
		this.pluginHost = pluginHost;
	}

	public void setPushNotifications(Boolean pushNotifications) {
		this.pushNotifications = pushNotifications;
	}

	public void setReadOnlyLibraries(Boolean readOnlyLibraries) {
		this.readOnlyLibraries = readOnlyLibraries;
	}

	public void setRequestParametersInCookie(Integer requestParametersInCookie) {
		this.requestParametersInCookie = requestParametersInCookie;
	}

	public void setStreamingBrainABRVersion(Integer streamingBrainABRVersion) {
		this.streamingBrainABRVersion = streamingBrainABRVersion;
	}

	public void setStreamingBrainVersion(Integer streamingBrainVersion) {
		this.streamingBrainVersion = streamingBrainVersion;
	}

	public void setSync(Boolean sync) {
		this.sync = sync;
	}

	public void setTranscoderActiveVideoSessions(Integer transcoderActiveVideoSessions) {
		this.transcoderActiveVideoSessions = transcoderActiveVideoSessions;
	}

	public void setTranscoderAudio(Boolean transcoderAudio) {
		this.transcoderAudio = transcoderAudio;
	}

	public void setTranscoderLyrics(Boolean transcoderLyrics) {
		this.transcoderLyrics = transcoderLyrics;
	}

	public void setTranscoderPhoto(Boolean transcoderPhoto) {
		this.transcoderPhoto = transcoderPhoto;
	}

	public void setTranscoderSubtitles(Boolean transcoderSubtitles) {
		this.transcoderSubtitles = transcoderSubtitles;
	}

	public void setTranscoderVideo(Boolean transcoderVideo) {
		this.transcoderVideo = transcoderVideo;
	}

	public void setTranscoderVideoBitrates(List<Integer> transcoderVideoBitrates) {
		this.transcoderVideoBitrates = transcoderVideoBitrates;
	}

	public void setTranscoderVideoQualities(List<Integer> transcoderVideoQualities) {
		this.transcoderVideoQualities = transcoderVideoQualities;
	}

	public void setTranscoderVideoResolutions(List<Integer> transcoderVideoResolutions) {
		this.transcoderVideoResolutions = transcoderVideoResolutions;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUpdater(Boolean updater) {
		this.updater = updater;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setVoiceSearch(Boolean voiceSearch) {
		this.voiceSearch = voiceSearch;
	}

	public PlexLibrary library() {
		try {
			return new PlexLibrary(this, client(), token());
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}

	public PlexStatus status() {
		try {
			return new PlexStatus(this, client(), token());
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}

	public PlexTranscode transcode() {
		try {
			return new PlexTranscode(this, client(), token());
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}

	public PlexServers plexServer() {
		try {
			return new PlexServers(this, client(), token());
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}

	public PlexServersSharedServers plexServersSharedServers() {
		try {
			return new PlexServersSharedServers(this, client(), token());
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}

	public List<PlexPlaylist<?>> playlists() {
		URI uri;
		try {
			uri = new URIBuilder(uri()).appendPath("playlists").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexPlaylist<?>, PlexDirectory>(uri, client(), token(), this).getMetadata();
	}

	// public List<PlexMediatag> search(String query, MediaType type) {
	// if (query == null || query.isBlank())
	// return Collections.emptyList();
	// URIBuilder uri = new
	// URIBuilder(uri()).appendPath("search").addParameter("query", query);
	// if (type != null)
	// uri.addParameter("type", Integer.toString(type.getId()));
	// return new PlexMetadataContainer(uri.build(), getClient(), getToken(),
	// this).getMetadata().stream()
	// .filter(m -> m instanceof PlexMediatag).map(m -> (PlexMediatag) m).toList();
	// }

	public PlexAudioPlaylist createPlaylist(String title, PlexArtist artist) {
		return createPlaylist(title, artist, PlexAudioPlaylist.SUBTYPE_DESCRIPTION);
	}

	public PlexAudioPlaylist createPlaylist(String title, PlexAlbum album) {
		return createPlaylist(title, album, PlexAudioPlaylist.SUBTYPE_DESCRIPTION);
	}

	public PlexAudioPlaylist createPlaylist(String title, PlexTrack track) {
		return createPlaylist(title, track, PlexAudioPlaylist.SUBTYPE_DESCRIPTION);
	}

	public PlexPhotoPlaylist createPlaylist(String title, PlexPhotoalbum photoalbum) {
		return createPlaylist(title, photoalbum, PlexPhotoPlaylist.SUBTYPE_DESCRIPTION);
	}

	public PlexPhotoPlaylist createPlaylist(String title, PlexPhoto photo) {
		return createPlaylist(title, photo, PlexPhotoPlaylist.SUBTYPE_DESCRIPTION);
	}

	public PlexPhotoPlaylist createPlaylist(String title, PlexClip clip) {
		return createPlaylist(title, clip, PlexPhotoPlaylist.SUBTYPE_DESCRIPTION);
	}

	public PlexVideoPlaylist createPlaylist(String title, PlexShow show) {
		return createPlaylist(title, show, PlexVideoPlaylist.SUBTYPE_DESCRIPTION);
	}

	public PlexVideoPlaylist createPlaylist(String title, PlexSeason season) {
		return createPlaylist(title, season, PlexVideoPlaylist.SUBTYPE_DESCRIPTION);
	}

	public PlexVideoPlaylist createPlaylist(String title, PlexEpisode episode) {
		return createPlaylist(title, episode, PlexVideoPlaylist.SUBTYPE_DESCRIPTION);
	}

	public PlexVideoPlaylist createPlaylist(String title, PlexMovie movie) {
		return createPlaylist(title, movie, PlexVideoPlaylist.SUBTYPE_DESCRIPTION);
	}

	private <P extends PlexPlaylist<?>> P createPlaylist(String title, PlexMediatag<?> mediatag, String type) {
		URI uri;
		try {
			uri = new URIBuilder(uri()).appendPath("playlists").addParameter("title", title).addParameter("type", type)
					.addParameter("uri", mediatag.serverSchemeUri().toString()).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		PlexHTTPClient client = client();
		String token = token();
		MetadataContainer<P, PlexDirectory> pmmc = new MetadataContainer<>(uri, client, token, this);
		client.executeAndUpdateFromResponse(ClassicRequestBuilder.post(uri).build(), pmmc, token);
		pmmc.fetched(true);
		return pmmc.getMetadata().get(0);
	}
}
