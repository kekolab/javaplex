package kekolab.javaplex;

import java.net.URI;
import java.util.List;

public class PlexPhotoalbum extends PlexMediatag<PlexPhotoSection> {
	public static final int TYPE_ID = 11;
	public static final String TYPE_DESCRIPTION = "photo";
	private UriProvider art;
	private UriProvider composite;
	private UriProvider thumb;

	public PlexPhotoalbum() {
		art = new UriProvider(this::uri);
		composite = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
	}

	@Override
	protected void clear() {
		super.clear();
		art.setValue(null);
		composite.setValue(null);
		thumb.setValue(null);
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexPhotoalbum photoalbum) {
			art.setValue(photoalbum.art.getValue());
			composite.setValue(photoalbum.composite.getValue());
			thumb.setValue(photoalbum.thumb.getValue());
		} else
			throw new ClassCastException("Cannot cast item to PlexPhotoalbum");
	}

	public List<PlexMediatag<PlexPhotoSection>> children() {
		return new MetadataContainer<PlexMediatag<PlexPhotoSection>, PlexDirectory>(key(), getClient(), getToken(),
				server()).getMetadata();
	}

	public String getComposite() {
		fetchDetailedIfNullOrEmpty(composite.getValue());
		return (String) composite.getValue();
	}

	public URI composite() {
		fetchDetailedIfNullOrEmpty(composite.uri());
		return composite.uri();
	}

	public void setComposite(String composite) {
		this.composite.setValue(composite);
	}

	public String getArt() {
		fetchDetailedIfNullOrEmpty(art.getValue());
		return (String) art.getValue();
	}

	public URI art() {
		fetchDetailedIfNullOrEmpty(art.uri());
		return art.uri();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public String getThumb() {
		fetchDetailedIfNullOrEmpty(thumb.getValue());
		return (String) thumb.getValue();
	}

	public URI thumb() {
		fetchDetailedIfNullOrEmpty(thumb.uri());
		return thumb.uri();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}
}
