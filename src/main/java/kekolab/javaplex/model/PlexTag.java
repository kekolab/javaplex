package kekolab.javaplex.model;

import java.net.URI;

// TODO Should be splitted in different classes... Chapter, Review, Tag, ...
public interface PlexTag {
	Integer getCount();

	String getThumb();

	URI thumb();

	String getFilter();

	String getTag();

	String getPath();

	String getTagKey();
}
