package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.hc.core5.net.URIBuilder;

/**
 * The class represents the media library of a Plex Media Server and maps the
 * XML received when connecting to https://PMSHost:PMSIP/library
 *
 */
public class PlexLibrary extends ServerMediaContainer {
	private Boolean allowSync;
	private String content;
	private String identifier;
	private String mediaTagPrefix;
	private Long mediaTagVersion;
	private String title1;
	private String title2;

	private UriProvider art;

	public PlexLibrary(PlexMediaServer server, PlexHTTPClient client, String token) throws URISyntaxException {
		super(new URIBuilder(server.uri()).appendPath("library").build(), client, token, server);
		art = new UriProvider(this::uri);
	}

	@Override
	protected void clear() {
		super.clear();
		allowSync = null;
		art.setValue(null);
		content = null;
		identifier = null;
		mediaTagPrefix = null;
		mediaTagVersion = null;
		title1 = null;
		title2 = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexLibrary library) {
			allowSync = library.allowSync;
			art = library.art;
			content = library.content;
			identifier = library.identifier;
			mediaTagPrefix = library.mediaTagPrefix;
			mediaTagVersion = library.mediaTagVersion;
			title1 = library.title1;
			title2 = library.title2;
		} else
			throw new ClassCastException("Cannot convert source to PlexLibrary");
	}

	public Boolean getAllowSync() {
		fetch();
		return allowSync;
	}

	public String getIdentifier() {
		fetch();
		return identifier;
	}

	public String getMediaTagPrefix() {
		fetch();
		return mediaTagPrefix;
	}

	public Long getMediaTagVersion() {
		fetch();
		return mediaTagVersion;
	}

	public String getContent() {
		fetch();
		return content;
	}

	public String getTitle1() {
		fetch();
		return title1;
	}

	public String getTitle2() {
		fetch();
		return title2;
	}

	public String getArt() {
		fetch();
		return (String) art.getValue();
	}

	public void setAllowSync(Boolean allowSync) {
		this.allowSync = allowSync;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void setMediaTagPrefix(String mediaTagPrefix) {
		this.mediaTagPrefix = mediaTagPrefix;
	}

	public void setMediaTagVersion(Long mediaTagVersion) {
		this.mediaTagVersion = mediaTagVersion;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public URI art() {
		fetch();
		return art.uri();
	}

	public List<PlexMetadata> all() {
		return fetchMetadata("all").stream().map(PlexMetadata.class::cast).collect(Collectors.toList());
	}

	public List<PlexMediatag<?>> recentlyAdded() {
		return fetchMetadata("recentlyAdded").stream().map(m -> (PlexMediatag<?>) m).collect(Collectors.toList());
	}

	public List<PlexVideo<?>> onDeck() {
		return fetchMetadata("onDeck").stream().map(m -> (PlexVideo<?>) m).collect(Collectors.toList());
	}

	private List<PlexMetadata> fetchMetadata(String path) {
		URI uri;
		try {
			uri = new URIBuilder(uri()).appendPath(path).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexMetadata, PlexDirectory>(uri, client(), token(), server()).getMetadata();
	}

	public List<PlexSearchResult> search(String query) {
		if (query == null || query.isBlank())
			return Collections.emptyList();
		URI uri;
		try {
			uri = new URIBuilder(uri()).appendPath("search").addParameter("query", query).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexMetadata, PlexDirectory>(uri, client(), token(), server()).getSearchResults();
	}

	public List<PlexSection<?, ?>> sections() {
		URI uri;
		try {
			uri = new URIBuilder(uri()).appendPath("sections").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexMetadata, PlexSection<?, ?>>(uri, client(), token(), server())
				.getDirectories();
	}

	public PlexSection<?, ?> section(int id) {
		return sections().stream().filter(s -> s.getKey().equals(Integer.toString(id))).findAny().get();
	}
}
