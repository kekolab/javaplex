package kekolab.javaplex.model;

import java.net.URI;



public interface PlexPhotoalbum extends PlexMediatag, PlexParent {
    int TYPE_ID = 11;
    String TYPE_DESCRIPTION = "photo";

    String getComposite();

    URI composite();

    String getArt();

    URI art();

    String getThumb();

    URI thumb();

    int typeId();

    PlexPhotoalbumEditor editor();

    PlexPhotoSection section();

}