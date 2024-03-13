package kekolab.javaplex.model;

import java.util.Date;

public interface PlexPin {
	Integer getId();

	String getCode();

	Date getExpiresAt();

	String getClientIdentifier();

	Boolean getTrusted();

	Integer getUserId();

	String getAuthToken();

	String getAuth_Token();
}
