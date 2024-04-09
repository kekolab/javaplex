package kekolab.javaplex.model;

import java.net.URI;

public interface PlexConnection {

    String getProtocol();

    String getAddress();

    Integer getPort();

    String getUri();

    URI uri();

    Integer getLocal();

}