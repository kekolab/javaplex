package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoalbum;
import kekolab.javaplex.model.PlexPhotoalbumEditor;

public class Photoalbum extends Mediatag implements PlexPhotoalbum {
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
		PlexPhotoalbum p = (PlexPhotoalbum) source;
		setArt(p.getArt());
		setComposite(p.getComposite());
		setThumb(p.getThumb());
	}

	@Override
	public List<? extends Mediatag> children() {
		return new MetadataContainer<Mediatag, Directory>(key(), getServer()).getMetadata();
	}
	@Override
	public String getComposite() {
		ensureDetailed(composite.getValue());
		return (String) composite.getValue();
	}

	@Override
	public URI composite() {
		ensureDetailed(composite.getValue());
		return composite.uri();
	}

	public void setComposite(String composite) {
		this.composite.setValue(composite);
	}

	@Override
	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	@Override
	public URI art() {
		ensureDetailed(art.getValue());
		return art.uri();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	@Override
	public String getThumb() {
		ensureDetailed(thumb.getValue());
		return (String) thumb.getValue();
	}

	@Override
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

	@Override
	public PlexPhotoalbumEditor editor() {
		return new PhotoalbumEditor(this);
	}

	@Override
	public PlexPhotoSection section() {
		return (PlexPhotoSection) super.section();
	}
}
