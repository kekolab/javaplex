package kekolab.javaplex.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.PlexException;

public interface PlexMediatag<S extends PlexSection<?, ?>> extends PlexSectionItem<S> {
    Boolean getAllowSync();

    Double getUserRating();

    Date getLastViewedAt();

    Long getViewOffset();

    Integer getSkipCount();

    Integer getIndex();

    Integer getPlaylistItemID();

    List<PlexTag> getCollections();

    List<PlexGuid> getGuids();

    Date getLastRatedAt();

    PlexUser getUser();

    PlexPlayer getPlayer();

    PlexSession getSession();

    PlexTranscodeSession getTranscodeSession();

    Integer getSessionKey();

    default URI serverSchemeUri(PlexMediaServer server) {
		try {
			return new URIBuilder().setScheme("server").setHost(server.getMachineIdentifier())
					.appendPath("com.plexapp.plugins.library").appendPath("library").appendPath("metadata")
					.appendPath(Integer.toString(getRatingKey())).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}
}
