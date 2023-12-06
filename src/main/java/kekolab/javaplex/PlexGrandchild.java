package kekolab.javaplex;

import java.net.URI;

public interface PlexGrandchild<P extends PlexMediatag<?>, GP extends PlexMediatag<?>> extends PlexChild<P> {
    GP grandparent();

    String getGrandparentArt();

    URI grandparentArt();

    String getGrandparentGuid();

    String getGrandparentKey();

    URI grandparentKey();

    Integer getGrandparentRatingKey();

    URI grandparentRatingKey();

    String getGrandparentTheme();

    URI grandparentTheme();

    String getGrandparentThumb();

    URI grandparentThumb();

    String getGrandparentTitle();

    Integer getGrandparentYear();
}