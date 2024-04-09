package kekolab.javaplex.model;

import java.net.URI;

public interface PlexAccount {

    String getEmail();

    Integer getId();

    String getUuid();

    String getMailingListStatus();

    String getUsername();

    String getTitle();

    String getCloudSyncDevice();

    String getLocale();

    String getAuthenticationToken();

    String getAuthToken();

    String getScrobbleTypes();

    Boolean getRestricted();

    Boolean getHome();

    Boolean getGuest();

    String getQueueEmail();

    Boolean getHasPassword();

    Integer getHomeSize();

    Integer getMaxHomeSize();

    Boolean getSecure();

    Integer getCertificateVersion();

    String getAuthentication_Token();

    String getQueueUid();

    String getThumb();

    URI thumb();

}