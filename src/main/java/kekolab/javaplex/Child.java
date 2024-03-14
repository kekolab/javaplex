package kekolab.javaplex;

import java.net.URI;

import kekolab.javaplex.model.PlexChild;
import kekolab.javaplex.model.PlexParent;
import kekolab.javaplex.model.PlexSection;

abstract class Child<P extends PlexParent<?, S>, S extends PlexSection<?, ?>> extends Mediatag<S>
        implements PlexChild<P, S> {

    private UriProvider parentKey, parentRatingKey, parentTheme, parentThumb;
    private String parentGuid;
    private Integer parentIndex;
    private String parentStudio;
    private String parentTitle;
    private Integer parentYear;

    Child() {
        parentKey = new UriProvider(() -> getServer().getUri());
        parentRatingKey = new UriProvider(() -> getServer().getUri());
        parentTheme = new UriProvider(() -> getServer().getUri());
        parentThumb = new UriProvider(() -> getServer().getUri());
    }

    @Override
    void update(Metadata source) {
        super.update(source);
        Child<?, ?> c = (Child<?, ?>) source;
        setParentGuid(c.getParentGuid());
        setParentIndex(c.getParentIndex());
        setParentKey(c.getParentKey());
        setParentRatingKey(c.getParentRatingKey());
        setParentStudio(c.getParentStudio());
        setParentTheme(c.getParentTheme());
        setParentThumb(c.getParentThumb());
        setParentTitle(c.getParentTitle());
        setParentYear(c.getParentYear());
    }

    @Override
    public P parent() {
        URI uri = parentKey() != null ? parentKey() : parentRatingKey() != null ? parentRatingKey() : null;
        if (uri != null)
            return new MetadataContainer<P, Directory>(uri, getServer()).getMetadata().get(0);
        return null;
    }

    @Override
    public String getParentGuid() {
        ensureDetailed(parentGuid);
        return parentGuid;
    }

    @Override
    public Integer getParentIndex() {
        ensureDetailed(parentIndex);
        return parentIndex;
    }

    @Override
    public String getParentKey() {
        ensureDetailed(parentKey.getValue());
        return (String) parentKey.getValue();
    }

    @Override
    public URI parentKey() {
        ensureDetailed(parentKey.getValue());
        return parentKey.uri();
    }

    @Override
    public Integer getParentRatingKey() {
        ensureDetailed(parentRatingKey.getValue());
        return (Integer) parentRatingKey.getValue();
    }

    @Override
    public URI parentRatingKey() {
        ensureDetailed(parentRatingKey.getValue());
        return parentRatingKey.uri();
    }

    @Override
    public String getParentStudio() {
        ensureDetailed(parentStudio);
        return parentStudio;
    }

    @Override
    public String getParentTheme() {
        ensureDetailed(parentTheme.getValue());
        return (String) parentTheme.getValue();
    }

    @Override
    public URI parentTheme() {
        ensureDetailed(parentTheme.getValue());
        return parentTheme.uri();
    }

    @Override
    public String getParentThumb() {
        ensureDetailed(parentThumb.getValue());
        return (String) parentThumb.getValue();
    }

    @Override
    public URI parentThumb() {
        ensureDetailed(parentThumb.getValue());
        return parentThumb.uri();
    }

    @Override
    public String getParentTitle() {
        ensureDetailed(parentTitle);
        return parentTitle;
    }

    @Override
    public Integer getParentYear() {
        ensureDetailed(parentYear);
        return parentYear;
    }

    public void setParentGuid(String guid) {
        this.parentGuid = guid;
    }

    public void setParentIndex(Integer index) {
        this.parentIndex = index;
    }

    public void setParentStudio(String studio) {
        this.parentStudio = studio;
    }

    public void setParentTitle(String title) {
        this.parentTitle = title;
    }

    public void setParentYear(Integer year) {
        this.parentYear = year;
    }

    public void setParentKey(String key) {
        this.parentKey.setValue(key);
    }

    public void setParentRatingKey(Integer ratingKey) {
        this.parentRatingKey.setValue(ratingKey);
    }

    public void setParentThumb(String thumb) {
        this.parentThumb.setValue(thumb);
    }

    public void setParentTheme(String theme) {
        this.parentTheme.setValue(theme);
    }

}
