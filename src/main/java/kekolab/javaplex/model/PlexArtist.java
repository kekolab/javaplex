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

	boolean isCountriesLocked();

	boolean isGenresLocked();

	boolean isSimilarsLocked();

	boolean isMoodsLocked();

	boolean isStylesLocked();

	void editCountries(List<PlexTag> countries);

	void editCountriesLock(boolean locked);

	void editMoods(List<PlexTag> moods);

	void editMoodsLock(boolean locked);

	void editSimilars(List<PlexTag> similars);

	void editSimilarsLock(boolean locked);

	void editStyles(List<PlexTag> styles);

	void editStylesLock(boolean locked);

	void editGenres(List<PlexTag> genres);

	void editGenresLock(boolean locked);
}
