package kekolab.javaplex;

import java.net.URI;

import kekolab.javaplex.model.PlexDirectory;

public class Directory extends InitialisableItem implements PlexDirectory {
	  
	private UriProvider key;
	private String title;

	public Directory() {
		key = new UriProvider(this::uri);
	}

	@Override
	public String getKey() {
		return (String) key.getValue();
	}

	public void setKey(String key) {
		this.key.setValue(key);
	}

	@Override
	public URI key() {
		return key.uri();
	}

	@Override
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/* TODO?
	public MediaContainer contents() {
		return new MediaContainer(key(), getClient(), getToken());
	}
     */
}
