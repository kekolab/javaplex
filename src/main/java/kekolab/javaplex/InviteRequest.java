package kekolab.javaplex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import kekolab.javaplex.mappers.SharingSettings;

public class InviteRequest extends BaseItem {
    @JsonProperty("server_id")
    private String serverId;
    @JsonProperty("shared_server")
    private InviteRequest.SharedServer sharedServer;
    @JsonProperty("sharing_settings")
    private SharingSettings sharingSettings;

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public InviteRequest.SharedServer getSharedServer() {
        return sharedServer;
    }

    public void setSharedServer(InviteRequest.SharedServer sharedServer) {
        this.sharedServer = sharedServer;
    }

    public SharingSettings getSharingSettings() {
        return sharingSettings;
    }

    public void setSharingSettings(SharingSettings sharingSettings) {
        this.sharingSettings = sharingSettings;
    }

    public static class SharedServer {
        @JsonProperty("library_section_ids")
        private List<Integer> librarySectionIds;
        @JsonProperty("invited_email")
        private String invitedEmail;

        public List<Integer> getLibrarySectionIds() {
            return librarySectionIds;
        }

        public void setLibrarySectionIds(List<Integer> librarySectionIds) {
            this.librarySectionIds = librarySectionIds;
        }

        public String getInvitedEmail() {
            return invitedEmail;
        }

        public void setInvitedEmail(String invitedEmail) {
            this.invitedEmail = invitedEmail;
        }

        public SharedServer() {
            librarySectionIds = new ArrayList<>();
        }
    }
}