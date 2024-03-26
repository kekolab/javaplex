package kekolab.javaplex.model;

import java.util.Date;
import java.util.List;

public interface PlexVideo<S extends PlexSection<?, ?>> extends PlexMediatag<S> {

	String getContentRating();

	Long getDuration();

	List<PlexMedia> getMedia();

	Date getOriginallyAvailableAt();

	String getOriginalTitle();

	String getStudio();

	Integer getYear();

	Boolean getContentRatingLocked();

	@Override
	PlexVideoEditor editor();
}
