package kekolab.javaplex.model;

public interface PlexPhotoPlaylist extends PlexPlaylist<PlexMediatag<PlexPhotoSection>> {

	String SUBTYPE_DESCRIPTION = "photo";

	void add(PlexPhotoalbum item);
}
