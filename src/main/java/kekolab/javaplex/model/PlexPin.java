package kekolab.javaplex.model;

import java.util.Date;

public interface PlexPin {

    /**
     * 
     * @return the id of this pin
     */

    Integer getId();

    /**
     * 
     * @return the code that has to be authorized on
     *         <code>https://plex.tv/link</code>
     */

    String getCode();

    /**
     * 
     * @return the expiration date of this pin
     */

    Date getExpiresAt();

    /**
     * 
     * @return the client identifier of this pin
     */

    String getClientIdentifier();

    /**
     * 
     * @return the trusted attribute of this pin
     */

    Boolean getTrusted();

    /**
     * 
     * @return the user id of this pin
     */

    Integer getUserId();

    /**
     * 
     * @return the authentication token associated with this pin
     */

    String getAuthToken();

    /**
     * 
     * @return the authentication token associated with this pin
     */

    String getAuth_Token();

}