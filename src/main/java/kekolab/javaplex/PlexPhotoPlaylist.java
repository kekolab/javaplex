package kekolab.javaplex;

public class PlexPhotoPlaylist extends PlexPlaylist<PlexMediatag<PlexPhotoSection>> {

	public static final String SUBTYPE_DESCRIPTION = "photo";

    public void add(PlexPhotoalbum item) {
		new GenericCollectionsHelper(this).add(item);
	}
}
