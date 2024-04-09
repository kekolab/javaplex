package kekolab.javaplex.model;

public interface PlexLyricsStream extends PlexStream {

    int TYPE_ID = 4;

    String getFormat();

    String getProvider();

    Integer getMinLines();

    Boolean getTimed();

}