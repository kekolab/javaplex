package kekolab.javaplex.model;

import java.util.Date;
import java.util.List;

public interface PlexMediaServer {
    Boolean getAllowCameraUpload();

    Boolean getAllowChannelAccess();

    Boolean getAllowMediaDeletion();

    Boolean getAllowSharing();

    Boolean getAllowSync();

    Boolean getAllowTuners();

    Boolean getBackgroundProcessing();

    Boolean getCertificate();

    Boolean getCompanionProxy();

    String getCountryCode();

    List<String> getDiagnostics();

    Boolean getEventStream();

    String getFriendlyName();

    Boolean getHubSearch();

    Boolean getItemClusters();

    Integer getLivetv();

    String getMachineIdentifier();

    Boolean getMediaProviders();

    Boolean getMultiuser();

    Boolean getMyPlex();

    String getMyPlexMappingState();

    String getMyPlexSigninState();

    Boolean getMyPlexSubscription();

    String getMyPlexUsername();

    Integer getOfflineTranscode();

    List<String> getOwnerFeatures();

    Boolean getPhotoAutoTag();

    String getPlatform();

    String getPlatformVersion();

    Boolean getPluginHost();

    Boolean getPushNotifications();

    Boolean getReadOnlyLibraries();

    Integer getRequestParametersInCookie();

    Integer getStreamingBrainABRVersion();

    Integer getStreamingBrainVersion();

    Boolean getSync();

    Integer getTranscoderActiveVideoSessions();

    Boolean getTranscoderAudio();

    Boolean getTranscoderLyrics();

    Boolean getTranscoderPhoto();

    Boolean getTranscoderSubtitles();

    Boolean getTranscoderVideo();

    List<Integer> getTranscoderVideoBitrates();

    List<Integer> getTranscoderVideoQualities();

    List<Integer> getTranscoderVideoResolutions();

    Date getUpdatedAt();

    Boolean getUpdater();

    String getVersion();

    Boolean getVoiceSearch();

    PlexLibrary library();

    PlexStatus status();

    PlexServer toPlexServer();

    PlexServerShares serverShares();

    PlexTranscode transcode();

    PlexPlaylists playlists();
}
