package kekolab.javaplex.model;

import java.util.List;

public interface PlexMusicSection extends PlexSection<PlexArtist, PlexAlbum>, WithCollections<PlexMusicCollections, PlexMusicSection> {

	String TYPE_DESCRIPTION = "artist";

    List<PlexArtist> all(PlexCondition filter);
    List<PlexAlbum> albums();
    List<PlexAlbum> albums(PlexCondition filter);
    List<PlexTrack> tracks();    
    List<PlexTrack> tracks(PlexCondition filter);

    List<PlexArtistOrAlbumFilter> byGenre();
    List<PlexArtistOrAlbumOrTrackFilter> byMood();
    List<PlexArtistOrAlbumFilter> byStyle();
    List<PlexArtistFilter> byCountry();    
    List<PlexArtistOrAlbumFilter> byCollection();

    List<PlexAlbumFilter> byYear();
    List<PlexAlbumFilter> byDecade();
    List<PlexAlbumFilter> byStudio();
    List<PlexAlbumFilter> byFormat();
    List<PlexAlbumFilter> bySubformat();
    List<PlexAlbumOrTrackFilter> bySource();
    List<PlexAlbumFilter> byLabel();

    List<PlexTrackFilter> byUserRating();    
}
