package kekolab.javaplex.model;

import java.util.List;

public interface PlexMusicSection extends PlexSection<PlexArtist, PlexAlbum>, WithCollections<PlexMusicCollections, PlexMusicSection> {

	String TYPE_DESCRIPTION = "artist";

    List<PlexArtist> all(PlexFilter filter);
    List<PlexAlbum> albums();
    List<PlexAlbum> albums(PlexFilter filter);
    List<PlexTrack> tracks();    
    List<PlexTrack> tracks(PlexFilter filter);

    List<PlexFilteringTag> genres();
    List<PlexFilteringTag> countries();
    List<PlexFilteringTag> moods();
    List<PlexFilteringTag> styles();
    List<PlexFilteringTag> collectionsFilteringTags();
    List<PlexFilteringTag> formats();
    List<PlexFilteringTag> subformats();
    List<PlexFilteringTag> sources();
    List<PlexFilteringTag> labels();
    
}
