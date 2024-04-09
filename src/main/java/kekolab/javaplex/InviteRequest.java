package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;

import kekolab.javaplex.model.PlexInviteRequest;
import kekolab.javaplex.model.PlexSharedServer;
import kekolab.javaplex.model.PlexSharingSettings;

public class InviteRequest extends BaseItem implements PlexInviteRequest {
    @JsonProperty("server_id")
    private String serverId;
    @JsonProperty("shared_server")
    private PlexSharedServer sharedServer;
    @JsonProperty("sharing_settings")
    private PlexSharingSettings sharingSettings;

    @Override
    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public PlexSharedServer getSharedServer() {
        return sharedServer;
    }

    public void setSharedServer(PlexSharedServer sharedServer) {
        this.sharedServer = sharedServer;
    }

    @Override
    public PlexSharingSettings getSharingSettings() {
        return sharingSettings;
    }

    public void setSharingSettings(PlexSharingSettings sharingSettings) {
        this.sharingSettings = sharingSettings;
    }
}