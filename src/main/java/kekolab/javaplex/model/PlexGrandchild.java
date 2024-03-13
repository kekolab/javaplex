package kekolab.javaplex.model;

import java.net.URI;

public interface PlexGrandchild<GP extends PlexGrandparent<?, ?, S>, P extends PlexParent<?, S>, S extends PlexSection<?, ?>> extends PlexChild<P, S> {
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