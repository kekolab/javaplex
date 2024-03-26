package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;

public interface PlexArtist extends PlexGrandparent<PlexAlbum, PlexTrack, PlexMusicSection> {
	int TYPE_ID = 8;
	String TYPE_DESCRIPTION = "artist";

	List<PlexTag> getStyles();

	Integer getAlbumSort();

	List<PlexTag> getLocations();

	List<PlexTag> getCountries();

	List<PlexTag> getMoods();

	List<PlexTag> getSimilars();

	List<PlexTag> getGenres();

	Integer getChildCount(); // TODO Move in Plexparent?

	String getArt();

	URI art();

	String getThumb();

	URI thumb();

	default int typeId() {
		return TYPE_ID;
	}

	Boolean getCountriesLocked();

	Boolean getGenresLocked();

	Boolean getSimilarsLocked();

	Boolean getMoodsLocked();

	Boolean getStylesLocked();

	@Override
	PlexArtistEditor editor();
}
