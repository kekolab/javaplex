package kekolab.javaplex.model;

import java.util.List;

public interface PlexPlaylists {
        List<? extends PlexPlaylist> list();

        void delete(PlexPlaylist target);

        // Generic Classic Playlists
        PlexClassicPlaylist create(String title, PlexMediatag tag);

        PlexClassicPlaylist create(String title, PlexSection section, PlexFilter filter);

        PlexClassicPlaylist create(String title, PlexSection section, PlexFilter filter, String sort);

        PlexClassicPlaylist add(PlexClassicPlaylist playlist, PlexMediatag mediatag);

        PlexClassicPlaylist remove(PlexClassicPlaylist playlist, PlexMediatag mediatag);

        // Smart Playlists

        PlexSmartPlaylist createSmart(String title, PlexSection section, PlexFilter filter);

        PlexSmartPlaylist createSmart(String title, PlexSection section, PlexFilter filter, String sort);

        PlexSmartPlaylist alter(PlexSmartPlaylist playlist, PlexFilter filter);

        PlexSmartPlaylist alter(PlexSmartPlaylist playlist, PlexFilter filter, String sort);
}