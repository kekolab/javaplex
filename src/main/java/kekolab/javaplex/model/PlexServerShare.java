package kekolab.javaplex.model;

import java.util.Date;
import java.util.List;

public interface PlexServerShare {
    // TODO Delete a PlexServerShare. To do so, send a DELETE to the endpoint
    // https://clients.plex.tv/api/v2/shared_servers/{id}
    String getId();

    String getUsername();

    String getEmail();

    String getUserID();

    String getAccessToken();

    String getName();

    Date getAcceptedAt();

    Date getInvitedAt();

    Boolean getAllowSync();

    Boolean getAllowCameraUpload();

    Boolean getAllowChannels();

    Boolean getAllowTuners();

    Boolean getAllowSubtitleAdmin();

    Boolean getOwned();

    Boolean getAllLibraries();

    String getFilterAll();

    String getFilterMovies();

    String getFilterMusic();

    String getFilterPhotos();

    String getFilterTelevision();

    List<PlexServer.Section> getSections();
}
