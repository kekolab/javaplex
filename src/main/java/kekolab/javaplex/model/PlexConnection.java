package kekolab.javaplex.model;

import java.net.URI;
import java.net.URISyntaxException;

import kekolab.javaplex.PlexException;

public interface PlexConnection {
    String getProtocol();

    String getAddress();

    Integer getPort();

    String getUri();

    Integer getLocal();

    default URI uri() {
        try {
            return new URI(getUri());
        } catch (URISyntaxException e) {
            throw new PlexException(e);
        }
    }
}
