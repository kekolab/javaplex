package kekolab.javaplex.model;

public interface PlexPlayer {
    String getAddress();

    String getDevice();

    String getMachineIdentifier();

    String getModel();

    String getPlatform();

    String getPlatformVersion();

    String getProduct();

    String getProfile();

    String getRemotePublicAddress();

    String getState();

    String getTitle();

    String getVendor();

    String getVersion();

    Boolean getLocal();

    Boolean getRelayed();

    Boolean getSecure();

    Integer getUserID();
}
