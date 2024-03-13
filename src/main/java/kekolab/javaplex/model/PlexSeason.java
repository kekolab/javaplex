package kekolab.javaplex.model;

import java.net.URI;


public interface PlexSeason extends PlexChild<PlexShow, PlexShowSection>, PlexParent<PlexEpisode, PlexShowSection> {
	int TYPE_ID = 3;
	String TYPE_DESCRIPTION = "season";

	Integer getLeafCount();

	Integer getViewedLeafCount();

	Integer getYear();

	String getArt();

	URI art();

	String getThumb();

	URI thumb();

	default int typeId() {
		return TYPE_ID;
	}
}
