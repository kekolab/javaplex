package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.TimestampDeserializer;

public abstract class PlexSection<All extends PlexMediatag<?>, RecentlyAdded extends PlexMediatag<?>>
		extends PlexDirectory {
	private Boolean allowSync;
	private String agent;
	private Boolean content;
	private Long contentChangedAt;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date createdAt;
	private Boolean directory;
	private Integer hidden;
	private String language;
	@JsonProperty("Location")
	private List<PlexLocation> locations = new ArrayList<>();
	private Boolean refreshing;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date scannedAt;
	private String scanner;
	private Boolean filters;
	private String type;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date updatedAt;
	private String uuid;

	private UriProvider art;
	private UriProvider composite;
	private UriProvider thumb;

	public PlexSection() {
		art = new UriProvider(this::uri);
		composite = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
	}

	@Override
	protected void clear() {
		super.clear();
		agent = null;
		art.setValue(null);
		composite.setValue(null);
		content = null;
		contentChangedAt = null;
		createdAt = null;
		directory = null;
		hidden = null;
		language = null;
		locations.clear();
		refreshing = null;
		scannedAt = null;
		scanner = null;
		filters = null;
		thumb.setValue(null);
		type = null;
		updatedAt = null;
		uuid = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexSection<?, ?> section) {
			agent = section.agent;
			art = section.art;
			composite = section.composite;
			content = section.content;
			contentChangedAt = section.contentChangedAt;
			createdAt = section.createdAt;
			directory = section.directory;
			hidden = section.hidden;
			language = section.language;
			locations.clear();
			locations.addAll(section.locations);
			refreshing = section.refreshing;
			scannedAt = section.scannedAt;
			scanner = section.scanner;
			filters = section.filters;
			thumb = section.thumb;
			type = section.type;
			updatedAt = section.updatedAt;
			uuid = section.uuid;
		} else
			throw new ClassCastException("Cannot cast item to PlexSection");
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public String getArt() {
		return (String) art.getValue();
	}

	public URI art() {
		return art.uri();
	}

	public void setComposite(String composite) {
		this.composite.setValue(composite);
	}

	public String getComposite() {
		return (String) composite.getValue();
	}

	public URI composite() {
		return composite.uri();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	public String getThumb() {
		return (String) thumb.getValue();
	}

	public URI thumb() {
		return thumb.uri();
	}

	public Boolean getAllowSync() {
		return allowSync;
	}

	public Boolean getFilters() {
		return filters;
	}

	public String getType() {
		return type;
	}

	public String getAgent() {
		return agent;
	}

	public String getScanner() {
		return scanner;
	}

	public String getLanguage() {
		return language;
	}

	public String getUuid() {
		return uuid;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getScannedAt() {
		return scannedAt;
	}

	public Boolean getContent() {
		return content;
	}

	public Boolean getDirectory() {
		return directory;
	}

	public Long getContentChangedAt() {
		return contentChangedAt;
	}

	public List<PlexLocation> getLocations() {
		return locations;
	}

	public Boolean getRefreshing() {
		return refreshing;
	}

	public Integer getHidden() {
		return hidden;
	}

	public void setAllowSync(Boolean allowSync) {
		this.allowSync = allowSync;
	}

	public void setFilters(Boolean filters) {
		this.filters = filters;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public void setScanner(String scanner) {
		this.scanner = scanner;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setScannedAt(Date scannedAt) {
		this.scannedAt = scannedAt;
	}

	public void setContent(Boolean content) {
		this.content = content;
	}

	public void setDirectory(Boolean directory) {
		this.directory = directory;
	}

	public void setContentChangedAt(Long contentChangedAt) {
		this.contentChangedAt = contentChangedAt;
	}

	public void setLocations(List<PlexLocation> locations) {
		this.locations = locations;
	}

	public void setRefreshing(Boolean refreshing) {
		this.refreshing = refreshing;
	}

	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}

	public List<All> all() {
		return executeRequestAndGetMetadata("all");//
	}

	public List<RecentlyAdded> recentlyAdded() {
		return executeRequestAndGetMetadata("recentlyAdded");
	}

	private <M extends PlexMetadata> List<M> executeRequestAndGetMetadata(String key) {
		URI uri;
		try {
			uri = new URIBuilder(key()).appendPath(key).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		return new MetadataContainer<M, PlexDirectory>(uri, getClient(), getToken(), server()).getMetadata();
	}

	protected <M extends PlexMediatag<?>> List<M> executeRequestAndCastMetadata(String key, Class<M> cls) {
		return executeRequestAndGetMetadata(key).stream().map(m -> cls.cast(m)).toList();
	}

	public List<PlexCollection<?, ?>> collections() {
		return executeRequestAndGetMetadata("collections").stream().map(m -> (PlexCollection<?, ?>) m)
				.collect(Collectors.toList());
	}

	public <M extends PlexMediatag<S>, S extends PlexSection<?, ?>> PlexCollection<M, S> createCollection(String title,
			M item) {
		URI uri;
		PlexMediaServer server = server();
		try {
			uri = new URIBuilder(server.uri()).appendPathSegments("library", "collections")
					.addParameter("type", Integer.toString(item.typeId())).addParameter("title", title)
					.addParameter("uri", item.serverSchemeUri().toString()).addParameter("sectionId", getKey()).build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
		PlexHTTPClient client = getClient();
		String token = getToken();
		MetadataContainer<PlexCollection<M, S>, PlexDirectory> container = new MetadataContainer<>(uri, client, token,
				server);
		container.fetched(true);
		client.executeAndUpdateFromResponse(ClassicRequestBuilder.post(uri).build(), container, token);
		return container.getMetadata().get(0);
	}

	@Override
	public URI key() {
		try {
			return new URIBuilder(server().uri()).appendPathSegments("library", "sections").appendPath(getKey())
					.build();
		} catch (URISyntaxException e) {
			throw new PlexException(e);
		}
	}
}