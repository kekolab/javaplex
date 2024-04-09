package kekolab.javaplex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import kekolab.javaplex.model.PlexSharedServer;

public class SharedServer implements PlexSharedServer {
    @JsonProperty("library_section_ids")
    private List<Integer> librarySectionIds;
    @JsonProperty("invited_email")
    private String invitedEmail;

    @Override
    public List<Integer> getLibrarySectionIds() {
        return librarySectionIds;
    }

    public void setLibrarySectionIds(List<Integer> librarySectionIds) {
        this.librarySectionIds = librarySectionIds;
    }

    @Override
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