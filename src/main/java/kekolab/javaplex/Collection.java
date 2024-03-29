package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexCollection;
import kekolab.javaplex.model.PlexCollectionEditor;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexSection;

class Collection<M extends PlexMediatag<S>, S extends PlexSection<?, ?>>
		extends SectionItem<S> implements PlexCollection<M, S> {
	private Integer childCount;
	private String contentRating;
	private Integer index;
	private Integer maxYear;
	private Integer minYear;
	private Integer ratingCount;
	private String subtype;
	private UriProvider art;
	private UriProvider thumb;



	public Collection() {
		art = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		Collection<?, ?> collection = (Collection<?, ?>) source;
		setChildCount(collection.getChildCount());
		setContentRating(collection.getContentRating());
		setIndex(collection.getIndex());
		setMaxYear(collection.getMaxYear());
		setMinYear(collection.getMinYear());
		setRatingCount(collection.getRatingCount());
		setSubtype(collection.getSubtype());
		setArt(collection.getArt());
		setThumb(collection.getThumb());
	}
	
	public Integer getChildCount() {
		ensureDetailed(childCount);
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	public String getContentRating() {
		ensureDetailed(contentRating);
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public Integer getIndex() {
		ensureDetailed(index);
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getMaxYear() {
		ensureDetailed(maxYear);
		return maxYear;
	}

	public void setMaxYear(Integer maxYear) {
		this.maxYear = maxYear;
	}

	public Integer getMinYear() {
		ensureDetailed(minYear);
		return minYear;
	}

	public void setMinYear(Integer minYear) {
		this.minYear = minYear;
	}

	public Integer getRatingCount() {
		ensureDetailed(ratingCount);
		return ratingCount;
	}

	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}

	public String getSubtype() {
		ensureDetailed(subtype);
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public List<M> children() {
		return new MetadataContainer<M, Directory>(key(), getServer()).getMetadata();
	}

	@Override
	public URI ratingKey() {
		if (getRatingKey() != null)
			try {
				return new URIBuilder(getServer().getUri())
						.appendPathSegments("library", "collections", Integer.toString(getRatingKey())).build();
			} catch (URISyntaxException e) {
				throw new PlexException(e);
			}
		return null;
	}

	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public URI art() {
		ensureDetailed(art.getValue());
		return art.uri();
	}

	public String getThumb() {
		ensureDetailed(thumb.getValue());
		return (String) thumb.getValue();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	public URI thumb() {
		ensureDetailed(thumb.getValue());
		return thumb.uri();
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	public Boolean getContentRatingLocked() {
		return getFieldLocked("contentRating");
	}

	@Override
	public PlexCollectionEditor editor() {
		return new CollectionEditor(this);
	}
}
