package kekolab.javaplex;

import java.net.URI;

public class PlexDirectory extends InitialisableItem {
	private UriProvider key;
	private String title;

	public PlexDirectory() {
		key = new UriProvider(this::uri);
	}

	@Override
	protected void clear() {
		super.clear();
		title = null;
		key = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexDirectory directory) {
			title = directory.title;
			key = directory.key;
		} else throw new ClassCastException("Cannot cast item to PlexDirectory");
	}

	public String getKey() {
		return (String) key.getValue();
	}

	public void setKey(String key) {
		this.key.setValue(key);
	}

	public URI key() {
		return key.uri();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PlexMediaContainer contents() {
		return new PlexMediaContainer(key(), getClient(), getToken());
	}
}
