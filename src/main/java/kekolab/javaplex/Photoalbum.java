package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexChild;
import kekolab.javaplex.model.PlexDirectory;
import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoalbum;
import kekolab.javaplex.model.PlexPhotoalbumEditor;

class Photoalbum extends Mediatag<PlexPhotoSection> implements PlexPhotoalbum {
	private UriProvider art;
	private UriProvider composite;
	private UriProvider thumb;

	public Photoalbum() {
		art = new UriProvider(this::uri);
		composite = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		Photoalbum p = (Photoalbum) source;
		setArt(p.getArt());
		setComposite(p.getComposite());
		setThumb(p.getThumb());
	}

	@Override
	public List<PlexChild<?, PlexPhotoSection>> children() {
		return new MetadataContainer<PlexChild<?, PlexPhotoSection>, PlexDirectory>(key(), getServer()).getMetadata();
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
		return PlexPhotoalbum.super.typeId();
	}

	@Override
	public PlexPhotoalbumEditor editor() {
		return new PhotoalbumEditor(this);
	}
}
