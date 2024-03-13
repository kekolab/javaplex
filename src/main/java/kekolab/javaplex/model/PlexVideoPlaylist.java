package kekolab.javaplex.model;

public interface PlexVideoPlaylist extends PlexPlaylist<PlexVideo<?>> {

	String SUBTYPE_DESCRIPTION = "video";

	void add(PlexShow show);

	void add(PlexSeason season);
}
