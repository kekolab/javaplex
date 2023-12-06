package kekolab.javaplex;

public class PlexVideoPlaylist extends PlexPlaylist<PlexVideo<?>> {

	public static final String SUBTYPE_DESCRIPTION = "video";

    public void add(PlexShow show) {
		new GenericCollectionsHelper(this).add(show);
	}

	public void add(PlexSeason season) {
		new GenericCollectionsHelper(this).add(season);
	}
}
