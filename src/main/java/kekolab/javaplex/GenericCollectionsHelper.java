package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexCollection;
import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexMediaServer;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexMetadata;
import kekolab.javaplex.model.PlexPlaylist;
import kekolab.javaplex.model.PlexSection;

public class GenericCollectionsHelper {
	private final PlexMetadata target;
	private MediaServer server;

	protected static URI uriParameter(PlexMediaServer server, PlexMediatag mediatag) {
		try {
			return new URIBuilder().setScheme("server").setHost(server.getMachineIdentifier())
					.appendPath("com.plexapp.plugins.library").appendPath("library").appendPath("metadata")
					.appendPath(Integer.toString(mediatag.getRatingKey())).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}

	protected static URI uriParameter(PlexMediaServer server, PlexSection section, PlexFilter filter) {
		try {
			return uriParameterBuilder(server, section, filter).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e); // TODO
		}
	}

	protected static URI uriParameter(PlexMediaServer server, PlexSection section, PlexFilter filter, String sort) {
		try {
			return uriParameterBuilder(server, section, filter)
					.addParameter(new BasicNameValuePair("sort", sort))
					.build();
		} catch (URISyntaxException e) {
			throw new PlexException(e); // TODO
		}
	}

	private static URIBuilder uriParameterBuilder(PlexMediaServer server, PlexSection section, PlexFilter filter) {
		return new URIBuilder().setScheme("server")
				.setHost(server.getMachineIdentifier())
				.appendPath("com.plexapp.plugins.library").appendPath("library").appendPath("sections")
				.appendPath(section.getKey())
				.appendPath("all")
				.addParameters(filter.getQueryParameters());
	}

	private GenericCollectionsHelper(PlexMetadata target, MediaServer server) {
		this.target = target;
		this.server = server;
	}

	protected GenericCollectionsHelper(PlexPlaylist target, MediaServer server) {
		this((PlexMetadata) target, server);
	}

	protected GenericCollectionsHelper(PlexCollection target, MediaServer server) {
		this((PlexMetadata) target, server);
	}

	protected PlexMetadata add(PlexMediatag mediatag) {
		URI uri;
		try {
			uri = new URIBuilder(target.key()).addParameter("uri", uriParameter(server, mediatag).toString()).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}

		server.getClient().put(uri, server.getToken(), Optional.empty());
		MetadataContainer<Metadata, ?> container = new MetadataContainer<>(target.ratingKey(), server);
		return container.getMetadata().get(0);
	}

	PlexMetadata remove(URI uri) {
		MetadataContainer<Metadata, ?> container = new MetadataContainer<>(uri, server);
		return server.getClient().delete(server.getToken(), container).getMetadata().get(0);
	}
}
