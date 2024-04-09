package kekolab.javaplex.model;

import java.util.Date;
import java.util.List;

public interface PlexDevice {

    String getProduct();

    String getProductVersion();

    String getPlatform();

    String getPlatformVersion();

    String getDevice();

    String getClientIdentifier();

    Date getCreatedAt();

    Date getLastSeenAt();

    List<String> getProvides();

    Integer getOwned();

    String getAccessToken();

    String getPublicAddress();

    Integer getHttpsRequired();

    Integer getRelay();

    Integer getDnsRebindingProtection();

    Integer getNatLoopbackSupported();

    Integer getPublicAddressMatches();

    Integer getPresence();

    List<PlexConnection> getConnections();

    String getName();

    Integer getSynced();

    boolean isServer();

}