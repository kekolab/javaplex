package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

public interface PlexAlbum extends PlexParent<PlexTrack, PlexMusicSection>, PlexChild<PlexArtist, PlexMusicSection> {
	int TYPE_ID = 10;
	String TYPE_DESCRIPTION = "album";

	Double getRating();

	List<PlexTag> getStyles();

	List<PlexTag> getFormats();

	Integer getLoudnessAnalysisVersion();

	List<PlexTag> getSubformats();

	List<PlexTag> getDirectors();

	Integer getLeafCount();

	List<PlexTag> getMoods();

	String getStudio();

	Integer getViewedLeafCount();

	List<PlexTag> getGenres();

	Date getOriginallyAvailableAt();

	Integer getYear();

	String getArt();

	URI art();

	String getThumb();

	URI thumb();

	boolean isGenresLocked();

	boolean isMoodsLocked();

	boolean isStylesLocked();

	@Override
	default int typeId() {
		return TYPE_ID;
	}

	void editMoods(List<PlexTag> moods);

	void editMoodsLock(boolean locked);

	void editStyles(List<PlexTag> styles);

	void editStylesLock(boolean locked);

	void editGenres(List<PlexTag> genres);

	void editGenresLock(boolean locked);

}
