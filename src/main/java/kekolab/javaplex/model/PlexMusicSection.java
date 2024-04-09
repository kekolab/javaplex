package kekolab.javaplex.model;

import java.util.List;

public interface PlexMusicSection extends PlexSection {

    String TYPE_DESCRIPTION = "artist";

    PlexSectionQueryBuilder<PlexArtist> all();

    List<PlexAlbum> recentlyAdded();

    PlexSectionQueryBuilder<PlexAlbum> albums();

    PlexSectionQueryBuilder<PlexTrack> tracks();

    PlexMusicCollections collections();

    List<PlexArtistOrAlbumSecondaryDirectory> byGenre();

    List<PlexArtistOrAlbumOrTrackSecondaryDirectory> byMood();

    List<PlexArtistOrAlbumSecondaryDirectory> byStyle();

    List<PlexArtistSecondaryDirectory> byCountry();

    List<PlexArtistOrAlbumSecondaryDirectory> byCollection();

    List<PlexAlbumSecondaryDirectory> byYear();

    List<PlexAlbumSecondaryDirectory> byDecade();

    List<PlexAlbumSecondaryDirectory> byStudio();

    List<PlexAlbumSecondaryDirectory> byFormat();

    List<PlexAlbumSecondaryDirectory> bySubformat();

    List<PlexAlbumOrTrackSecondaryDirectory> bySource();

    List<PlexAlbumSecondaryDirectory> byLabel();

    List<PlexTrackSecondaryDirectory> byUserRating();

}