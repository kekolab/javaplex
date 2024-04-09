package kekolab.javaplex.model;

public interface PlexInviteRequest {

    String getServerId();

    PlexSharedServer getSharedServer();

    PlexSharingSettings getSharingSettings();

}