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

    Integer getHttpsRequired(); // TODO Integer?

    Integer getRelay();// TODO Integer?

    Integer getDnsRebindingProtection();

    Integer getNatLoopbackSupported(); // TODO Integer?

    Integer getPublicAddressMatches();

    Integer getPresence();

    List<PlexConnection> getConnections();

    String getName();

    Integer getSynced(); // TODO Integer?

    default boolean isServer() {
        return getProvides().stream().anyMatch(p -> p.equalsIgnoreCase("server"));
    }

    /*
     * TODO
     * public PlexMediaServer toServer(PlexConnection connection) {
     * if (!isServer())
     * throw new PlexException("the device is not a server");
     * if (client == null)
     * throw new PlexException("client not set");
     * Objects.requireNonNull(connection, "connection cannot be null");
     * if (!getConnections().contains(connection))
     * throw new
     * PlexException("the given connection is not a connection for this device");
     * return new PlexMediaServer(connection.uri(), client,
     * Optional.of(getAccessToken()));
     * }
     */
}
