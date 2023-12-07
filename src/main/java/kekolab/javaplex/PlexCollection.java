package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class PlexCollection<M extends PlexMediatag<S>, S extends PlexSection<?, ?>>
		extends PlexSectionItem<S> {
	public static final int TYPE_ID = 18;
	public static final String TYPE_DESCRIPTION = "collection";
	private Integer childCount;
	private String contentRating;
	private Integer index;
	private Integer maxYear;
	private Integer minYear;
	private Integer ratingCount;
	private String subtype;
	private UriProvider art;
	private UriProvider thumb;

	@JsonIgnore
	private FieldEditor<String> contentRatingEditor;
	@JsonIgnore
	private FieldEditor<Boolean> contentRatingLockEditor;

	public PlexCollection() {
		art = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
		contentRatingEditor = new StringFieldEditor("contentRating.value", this::getContentRating, true);
		contentRatingLockEditor = new BooleanFieldEditor("contentRating.locked", this::isContentRatingLocked);
	}

	@Override
	protected void clear() {
		super.clear();
		art.setValue(null);
		childCount = null;
		contentRating = null;
		index = null;
		maxYear = null;
		minYear = null;
		ratingCount = null;
		subtype = null;
		thumb.setValue(null);
	}

	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexCollection collection) {
			art.setValue(collection.art.getValue());
			childCount = collection.childCount;
			contentRating = collection.contentRating;
			index = collection.index;
			maxYear = collection.maxYear;
			minYear = collection.minYear;
			ratingCount = collection.ratingCount;
			subtype = collection.subtype;
			thumb.setValue(collection.thumb.getValue());
		} else
			throw new ClassCastException("Cannot cast item to PlexCollection");
	}

	public void add(M mediatag) {
		if (!mediatag.getLibrarySectionID().equals(getLibrarySectionID()))
			throw new RuntimeException(
					"The item to be added and the receiving collection must belong to the same section"); // TODO Maybe
																											// a better
																											// exception?
		new GenericCollectionsHelper(this).add(mediatag);
	}

	public Integer getChildCount() {
		fetchDetailedIfNullOrEmpty(childCount);
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	public String getContentRating() {
		fetchDetailedIfNullOrEmpty(contentRating);
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public Integer getIndex() {
		fetchDetailedIfNullOrEmpty(index);
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getMaxYear() {
		fetchDetailedIfNullOrEmpty(maxYear);
		return maxYear;
	}

	public void setMaxYear(Integer maxYear) {
		this.maxYear = maxYear;
	}

	public Integer getMinYear() {
		fetchDetailedIfNullOrEmpty(minYear);
		return minYear;
	}

	public void setMinYear(Integer minYear) {
		this.minYear = minYear;
	}

	public Integer getRatingCount() {
		fetchDetailedIfNullOrEmpty(ratingCount);
		return ratingCount;
	}

	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}

	public String getSubtype() {
		fetchDetailedIfNullOrEmpty(subtype);
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public List<M> children() {
		return new MetadataContainer<M, PlexDirectory>(key(), getClient(), getToken(), server()).getMetadata();
	}

	@Override
	public URI ratingKey() {
		if (getRatingKey() != null)
			try {
				return new URIBuilder(server().uri())
						.appendPathSegments("library", "collections", Integer.toString(getRatingKey())).build();
			} catch (URISyntaxException e) {
				throw new PlexException(e);
			}
		return null;
	}

	public void remove(M mediatag) {
		URI uri;
		try {
			uri = new URIBuilder(key()).appendPath(Integer.toString(mediatag.getRatingKey()))
					.addParameter("excludeAllLeaves", "1").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		new GenericCollectionsHelper(this).remove(uri);
	}

	public String getArt() {
		fetchDetailedIfNullOrEmpty(art.getValue());
		return (String) art.getValue();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public URI art() {
		fetchDetailedIfNullOrEmpty(art.getValue());
		return art.uri();
	}

	public String getThumb() {
		fetchDetailedIfNullOrEmpty(thumb.getValue());
		return (String) thumb.getValue();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	public URI thumb() {
		fetchDetailedIfNullOrEmpty(thumb.getValue());
		return thumb.uri();
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	public boolean isContentRatingLocked() {
		return isLocked("contentRating");
	}

	public void editContentRating(String contentRating) {
		contentRatingEditor.setValue(contentRating);
	}

	public void editContentRatingLock(boolean locked) {
		contentRatingLockEditor.setValue(locked);
	}

	@Override
	protected List<FieldEditor<?>> fieldEditors() {
		List<FieldEditor<?>> fieldEditors = super.fieldEditors();
		fieldEditors.addAll(Arrays.asList(
				contentRatingEditor, contentRatingLockEditor));
		return fieldEditors;
	}
}
