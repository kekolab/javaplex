package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

public interface PlexAlbum extends PlexParent<PlexTrack, PlexMusicSection>, PlexChild<PlexArtist, PlexMusicSection> {
	int TYPE_ID = 9;
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

	Boolean getGenresLocked();

	Boolean getMoodsLocked();

	Boolean getStylesLocked();

	@Override
	default int typeId() {
		return TYPE_ID;
	}

	@Override
	PlexAlbumEditor editor();
}
