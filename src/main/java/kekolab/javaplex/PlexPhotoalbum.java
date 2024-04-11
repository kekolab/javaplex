package kekolab.javaplex;

import java.net.URI;
import java.util.List;

public class PlexPhotoalbum extends PlexMediatag<PlexPhotoSection>
		implements PlexParent<PlexPhotoSection, PlexMediatag<PlexPhotoSection>> {
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
	void update(PlexMetadata source) {
		super.update(source);
		PlexPhotoalbum p = (PlexPhotoalbum) source;
		setArt(p.getArt());
		setComposite(p.getComposite());
		setThumb(p.getThumb());
	}

	@Override
	public List<PlexMediatag<PlexPhotoSection>> children() {
		return new PlexGeneralPurposeMediaContainer<PlexMediatag<PlexPhotoSection>, PlexDirectory>(key(), getServer())
				.getMetadata();
	}

	public String getComposite() {
		ensureDetailed(composite.getValue());
		return (String) composite.getValue();
	}

	public URI composite() {
		ensureDetailed(composite.getValue());
		return composite.uri();
	}

	public void setComposite(String composite) {
		this.composite.setValue(composite);
	}

	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	public URI art() {
		ensureDetailed(art.getValue());
		return art.uri();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public String getThumb() {
		ensureDetailed(thumb.getValue());
		return (String) thumb.getValue();
	}

	public URI thumb() {
		ensureDetailed(thumb.getValue());
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
