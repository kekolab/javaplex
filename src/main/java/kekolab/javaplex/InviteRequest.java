package kekolab.javaplex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import kekolab.javaplex.mappers.BooleanSerializer;
import kekolab.javaplex.mappers.IntegerListSerializer;

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
		@JsonSerialize(using = IntegerListSerializer.class) 
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
		// @JsonSerialize(using = StringListSerializer.class) // TODO How is this supposed to be serialized? --> Python api
		private List<String> filterMovies; 
		// @JsonSerialize(using = StringListSerializer.class) // TODO How is this supposed to be serialized? --> Python api
		private List<String> filterTelevision; 
		// @JsonSerialize(using = StringListSerializer.class) // TODO How is this supposed to be serialized? --> Python api
		private List<String> filterMusic; 

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

        public List<String> getFilterMovies() {
            return filterMovies;
        }

        public void setFilterMovies(List<String> filterMovies) {
            this.filterMovies = filterMovies;
        }

        public List<String> getFilterTelevision() {
            return filterTelevision;
        }

        public void setFilterTelevision(List<String> filterTelevision) {
            this.filterTelevision = filterTelevision;
        }

        public List<String> getFilterMusic() {
            return filterMusic;
        }

        public void setFilterMusic(List<String> filterMusic) {
            this.filterMusic = filterMusic;
        }

        public SharingSettings() {
			filterMovies = new ArrayList<>();
			filterTelevision = new ArrayList<>();
			filterMusic = new ArrayList<>();
		}
	}
}