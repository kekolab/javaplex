package kekolab.javaplex.model;

import java.net.URI;

public interface PlexDirectory {
    String getKey();
    URI key();
    String getTitle();
    /* TODO?
	public MediaContainer contents() {
		return new MediaContainer(key(), getClient(), getToken());
	}
     */
}
