package kekolab.javaplex;

import java.net.URI;

import kekolab.javaplex.model.PlexDirectory;
import kekolab.javaplex.model.PlexGrandchild;
import kekolab.javaplex.model.PlexGrandparent;
import kekolab.javaplex.model.PlexParent;
import kekolab.javaplex.model.PlexSection;

abstract class Grandchild<G extends PlexGrandparent<?, ?, S>, P extends PlexParent<?, S>, S extends PlexSection<?, ?>>
        extends Child<P, S> implements PlexGrandchild<G, P, S> {
    private UriProvider grandparentArt, grandparentKey, grandparentRatingKey, grandparentTheme, grandparentThumb;
    private String grandparentGuid;
    private String grandparentTitle;
    private Integer grandparentYear;

    Grandchild() {
        grandparentArt = new UriProvider(() -> getServer().getUri());
        grandparentKey = new UriProvider(() -> getServer().getUri());
        grandparentRatingKey = new UriProvider(() -> getServer().getUri());
        grandparentTheme = new UriProvider(() -> getServer().getUri());
        grandparentThumb = new UriProvider(() -> getServer().getUri());
    }

    @Override
    void update(Metadata source) {
        super.update(source);
        Grandchild<?, ?, ?> g = (Grandchild<?, ?, ?>) source;
        setGrandparentArt(g.getGrandparentArt());  
        setGrandparentGuid(g.getGrandparentGuid());
        setGrandparentKey(g.getGrandparentKey());
        setGrandparentRatingKey(g.getGrandparentRatingKey());
        setGrandparentTheme(g.getGrandparentTheme());
        setGrandparentThumb(g.getGrandparentThumb()); 
        setGrandparentTitle(g.getGrandparentTitle());
        setGrandparentYear(g.getGrandparentYear());
    }

    @Override
    public G grandparent() {
        URI uri = grandparentKey() != null ? grandparentKey()
                : grandparentRatingKey() != null ? grandparentRatingKey() : null;
        if (uri != null)
            return new MetadataContainer<G, PlexDirectory>(uri, getClient(), getToken(), getServer()).getMetadata().get(0);
        return null;
    }

    @Override
    public String getGrandparentArt() {
        ensureDetailed(grandparentArt.getValue());
        return (String) grandparentArt.getValue();
    }

    @Override
    public URI grandparentArt() {
        ensureDetailed(grandparentArt.getValue());
        return grandparentArt.uri();
    }

    @Override
    public String getGrandparentGuid() {
        ensureDetailed(grandparentGuid);
        return grandparentGuid;
    }

    @Override
    public String getGrandparentKey() {
        ensureDetailed(grandparentKey.getValue());
        return (String) grandparentKey.getValue();
    }

    @Override
    public URI grandparentKey() {
        ensureDetailed(grandparentKey.getValue());
        return grandparentKey.uri();
    }

    @Override
    public Integer getGrandparentRatingKey() {
        ensureDetailed(grandparentRatingKey.getValue());
        return (Integer) grandparentRatingKey.getValue();
    }

    @Override
    public URI grandparentRatingKey() {
        ensureDetailed(grandparentRatingKey.getValue());
        return grandparentRatingKey.uri();
    }

    @Override
    public String getGrandparentTheme() {
        ensureDetailed(grandparentTheme.getValue());
        return (String) grandparentTheme.getValue();
    }

    @Override
    public URI grandparentTheme() {
        ensureDetailed(grandparentTheme.getValue());
        return grandparentTheme.uri();
    }

    @Override
    public String getGrandparentThumb() {
        ensureDetailed(grandparentThumb.getValue());
        return (String) grandparentThumb.getValue();
    }

    @Override
    public URI grandparentThumb() {
        ensureDetailed(grandparentThumb.getValue());
        return grandparentThumb.uri();
    }

    @Override
    public String getGrandparentTitle() {
        ensureDetailed(grandparentTitle);
        return grandparentTitle;
    }

    @Override
    public Integer getGrandparentYear() {
        ensureDetailed(grandparentYear);
        return grandparentYear;
    }

    public void setGrandparentGuid(String grandParentGuid) {
        this.grandparentGuid = grandParentGuid;
    }

    public void setGrandparentTitle(String grandparentTitle) {
        this.grandparentTitle = grandparentTitle;
    }

    public void setGrandparentYear(Integer grandparentYear) {
        this.grandparentYear = grandparentYear;
    }

    public void setGrandparentArt(String art) {
        this.grandparentArt.setValue(art);
    }

    public void setGrandparentKey(String key) {
        this.grandparentKey.setValue(key);
    }

    public void setGrandparentRatingKey(Integer ratingKey) {
        this.grandparentKey.setValue(ratingKey);
    }

    public void setGrandparentTheme(String theme) {
        this.grandparentKey.setValue(theme);
    }

    public void setGrandparentThumb(String thumb) {
        this.grandparentKey.setValue(thumb);
    }
}
