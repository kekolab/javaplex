package kekolab.javaplex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import kekolab.javaplex.mappers.BooleanSerializer;

public class InviteRequest extends BaseItem {
    @JsonProperty("server_id")
    private String serverId;
    @JsonProperty("shared_server")
    private InviteRequest.SharedServer sharedServer;
    @JsonProperty("sharing_settings")
    private InviteRequest.SharingSettings sharingSettings;

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

    public InviteRequest.SharingSettings getSharingSettings() {
        return sharingSettings;
    }

    public void setSharingSettings(InviteRequest.SharingSettings sharingSettings) {
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

    public static class SharingSettings {
        @JsonSerialize(using = BooleanSerializer.class)
        private Boolean allowSync;
        @JsonSerialize(using = BooleanSerializer.class)
        private Boolean allowCameraUpload;
        @JsonSerialize(using = BooleanSerializer.class)
        private Boolean allowChannels;
        @JsonSerialize(using = FilterMapSerializer.class)
        private Map<String, List<String>> filterMovies;
        @JsonSerialize(using = FilterMapSerializer.class)
        private Map<String, List<String>> filterTelevision;
        @JsonSerialize(using = FilterMapSerializer.class)
        private Map<String, List<String>> filterMusic;

        public Map<String, List<String>> getFilterMovies() {
            return filterMovies;
        }

        public void setFilterMovies(Map<String, List<String>> filterMovies) {
            this.filterMovies = filterMovies;
        }

        public Map<String, List<String>> getFilterTelevision() {
            return filterTelevision;
        }

        public void setFilterTelevision(Map<String, List<String>> filterTelevision) {
            this.filterTelevision = filterTelevision;
        }

        public Map<String, List<String>> getFilterMusic() {
            return filterMusic;
        }

        public void setFilterMusic(Map<String, List<String>> filterMusic) {
            this.filterMusic = filterMusic;
        }

        public Boolean getAllowSync() {
            return allowSync;
        }

        public void setAllowSync(Boolean allowSync) {
            this.allowSync = allowSync;
        }

        public Boolean getAllowCameraUpload() {
            return allowCameraUpload;
        }

        public void setAllowCameraUpload(Boolean allowCameraUpload) {
            this.allowCameraUpload = allowCameraUpload;
        }

        public Boolean getAllowChannels() {
            return allowChannels;
        }

        public void setAllowChannels(Boolean allowChannels) {
            this.allowChannels = allowChannels;
        }

        public SharingSettings() {
            filterMovies = new HashMap<>();
            filterTelevision = new HashMap<>();
            filterMusic = new HashMap<>();
        }

        public static class FilterMapSerializer extends StdSerializer<Map<String, List<String>>> {
            public FilterMapSerializer() {
                super((Class<Map<String, List<String>>>) null);
            }

            @Override
            public void serialize(Map<String, List<String>> filterMap, JsonGenerator gen, SerializerProvider provider)
                    throws IOException {
                List<String> values = new ArrayList<>();
                for (String key : filterMap.keySet())
                    values.add(key + "=" + String.join(",", filterMap.get(key)));
                gen.writeString(String.join("|", values));
            }
        }
    }
}