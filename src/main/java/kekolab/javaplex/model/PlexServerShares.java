package kekolab.javaplex.model;

import java.util.List;

public interface PlexServerShares {

    List<PlexServerShare> getServerShares();

    List<PlexServerShare> list();

    PlexServerShare inviteFriend(String usernameOrEmail, List<PlexServer.Section> sections,
            PlexSharingSettings sharingSettings);

    void deleteServerShare(PlexServerShare serverShare);

    /**
     * invites a friend with default settings.
     * The default implementation calls
     * <code>inviteFriend(usernameOrEmail, sections, PlexSharingSettings.DEFAULT)</code>
     * 
     * @see PlexSharingSettings#DEFAULT
     * @param usernameOrEmail
     * @param server
     * @param sections
     * @return
     */
    PlexServerShare inviteFriend(String usernameOrEmail, List<PlexServer.Section> sections);

}