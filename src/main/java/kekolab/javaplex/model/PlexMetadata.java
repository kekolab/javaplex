package kekolab.javaplex.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

public interface PlexMetadata extends PlexDirectory {

    Integer getRatingKey();

    Date getUpdatedAt();

    String getGuid();

    Date getAddedAt();

    List<PlexField> getFields();

    String getType();

    Integer getViewCount();

    String getSummary();

    URI ratingKey();

    void delete();
}
