package kekolab.javaplex.model;

import java.util.Date;
import java.util.List;

public interface PlexTrack extends PlexGrandchild<PlexArtist, PlexAlbum, PlexMusicSection> {
	int TYPE_ID = 10;
	String TYPE_DESCRIPTION = "track";

	List<PlexMedia> getMedia();

	Integer getRatingCount();

	List<PlexTag> getMoods();

	List<String> getCreatedAtAccuracy();

	String getCreatedAtTZOffset();

	String getOriginalTitle();

	Long getDuration();

	Date getOriginallyAvailableAt();


	Boolean getMoodsLocked();

	default int typeId() {
		return TYPE_ID;
	}

	@Override
	PlexTrackEditor editor();
}
