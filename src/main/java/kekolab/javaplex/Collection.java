package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexCollection;
import kekolab.javaplex.model.PlexMediatag;

public class Collection extends SectionItem implements PlexCollection {
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
		PlexCollection collection = (PlexCollection) source;
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

	@Override
	public Integer getChildCount() {
		ensureDetailed(childCount);
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	@Override
	public String getContentRating() {
		ensureDetailed(contentRating);
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	@Override
	public Integer getIndex() {
		ensureDetailed(index);
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public Integer getMaxYear() {
		ensureDetailed(maxYear);
		return maxYear;
	}

	public void setMaxYear(Integer maxYear) {
		this.maxYear = maxYear;
	}

	@Override
	public Integer getMinYear() {
		ensureDetailed(minYear);
		return minYear;
	}

	public void setMinYear(Integer minYear) {
		this.minYear = minYear;
	}

	@Override
	public Integer getRatingCount() {
		ensureDetailed(ratingCount);
		return ratingCount;
	}

	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}

	@Override
	public String getSubtype() {
		ensureDetailed(subtype);
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	@Override
	public List<? extends PlexMediatag> children() {
		return new MetadataContainer<PlexMediatag, Directory>(key(), getServer()).getMetadata();
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

	@Override
	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	@Override
	public URI art() {
		ensureDetailed(art.getValue());
		return art.uri();
	}

	@Override
	public String getThumb() {
		ensureDetailed(thumb.getValue());
		return (String) thumb.getValue();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	@Override
	public URI thumb() {
		ensureDetailed(thumb.getValue());
		return thumb.uri();
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	@Override
	public Boolean getContentRatingLocked() {
		return getFieldLocked("contentRating");
	}

	@Override
	public CollectionEditor editor() {
		return new CollectionEditor(this);
	}
}
