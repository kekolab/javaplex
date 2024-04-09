package kekolab.javaplex;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InitialisableItem extends BaseItem {
  @JsonIgnore
  private MediaServer server;
  @JsonIgnore
  private URI uri;

  protected void initialise(MediaServer server, URI uri) {
    this.server = server;
    this.uri = uri;
  }

  MediaServer getServer() {
    return server;
  }

  protected URI uri() {
    return uri;
  }
}