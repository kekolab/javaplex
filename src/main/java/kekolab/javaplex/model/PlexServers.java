package kekolab.javaplex.model;

import java.util.List;

public interface PlexServers {
    List<PlexServer> list();

    PlexServer getFromMachineIdentifier(String machineIdentifier);
}