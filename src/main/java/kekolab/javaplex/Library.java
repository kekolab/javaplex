package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexLibrary;
import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexMetadata;
import kekolab.javaplex.model.PlexSearchResult;
import kekolab.javaplex.model.PlexSection;
import kekolab.javaplex.model.PlexVideo;

/**
 * The class represents the media library of a Plex Media Server and maps the
 * XML received when connecting to https://PMSHost:PMSIP/library
 *
 */
class Library extends ServerMediaContainer implements PlexLibrary {
	private Boolean allowSync;
	private String content;
	private String identifier;
	private String mediaTagPrefix;
	private Long mediaTagVersion;
	private String title1;
	private String title2;

	private UriProvider art;

	public Library(MediaServer server)
			throws URISyntaxException {
		super(new URIBuilder(server.getUri()).appendPath("library").build(), server);
		art = new UriProvider(this::getUri);
	}

	public Boolean getAllowSync() {
		ensureFetched(allowSync);
		return allowSync;
	}

	public String getIdentifier() {
		ensureFetched(identifier);
		return identifier;
	}

	public String getMediaTagPrefix() {
		ensureFetched(mediaTagPrefix);
		return mediaTagPrefix;
	}

	public Long getMediaTagVersion() {
		ensureFetched(mediaTagVersion);
		return mediaTagVersion;
	}

	public String getContent() {
		ensureFetched(content);
		return content;
	}

	public String getTitle1() {
		ensureFetched(title1);
		return title1;
	}

	public String getTitle2() {
		ensureFetched(title2);
		return title2;
	}

	public String getArt() {
		ensureFetched((String) art.getValue());
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
		ensureFetched(art.uri());
		return art.uri();
	}

	public List<PlexMetadata> all() {
		return fetchMetadata("all").stream().map(Metadata.class::cast).collect(Collectors.toList());
	}

	public List<PlexMediatag<?>> recentlyAdded() {
		return fetchMetadata("recentlyAdded").stream().map(m -> (Mediatag<?>) m).collect(Collectors.toList());
	}

	public List<PlexVideo<?>> onDeck() {
		return fetchMetadata("onDeck").stream().map(m -> (PlexVideo<?>) m).collect(Collectors.toList());
	}

	private List<PlexMetadata> fetchMetadata(String path) {
		URI uri;
		try {
			uri = new URIBuilder(getUri()).appendPath(path).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexMetadata, Directory>(uri, server()).getMetadata();
	}

	public List<PlexSearchResult> search(String query) {
		if (query == null || query.isBlank())
			return Collections.emptyList();
		URI uri;
		try {
			uri = new URIBuilder(getUri()).appendPath("search").addParameter("query", query).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<Metadata, Directory>(uri, server())
				.getSearchResults();
	}

	public List<PlexSection<?, ?>> sections() {
		URI uri;
		try {
			uri = new URIBuilder(getUri()).appendPath("sections").build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<PlexMetadata, PlexSection<?, ?>>(uri, server())
				.getDirectories();
	}

	public PlexSection<?, ?> section(int id) {
		return sections().stream().filter(s -> s.getKey().equals(Integer.toString(id))).findAny().get();
	}
}
