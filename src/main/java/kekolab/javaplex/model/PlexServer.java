package kekolab.javaplex.model;

import java.util.Date;
import java.util.List;

public interface PlexServer {

    List<PlexServer.Section> getSections();

    PlexServerShares serverShares();

    String getAccessToken();

    String getName();

    Integer getPort();

    String getVersion();

    String getScheme();

    String getHost();

    String getLocalAddresses();

    String getMachineIdentifier();

    Date getCreatedAt();

    Date getUpdatedAt();

    Boolean getOwned();

    Boolean getSynced();

    String getAddress();

    public static interface Section  {


		public Integer getId();
		
		public String getKey();

		public String getTitle(); 

		public String getType();

		public Boolean getShared();
	}

}