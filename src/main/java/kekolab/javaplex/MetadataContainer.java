package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.DirectoryDeserializer;
import kekolab.javaplex.mappers.MetadataDeserializer;

public class MetadataContainer<M extends PlexMetadata, D extends PlexDirectory> extends ServerMediaContainer {
	@JsonProperty("Metadata")
	@JsonDeserialize(contentUsing = MetadataDeserializer.class)
	private List<M> metadata;

	@JsonProperty("SearchResult")
	private List<PlexSearchResult> searchResults;

	@JsonProperty("Directory")
	@JsonDeserialize(contentUsing = DirectoryDeserializer.class)
	private List<D> directories;

	public MetadataContainer(URI uri, PlexHTTPClient client, String token, PlexMediaServer server) {
		super(uri, client, token, server);
		metadata = new ArrayList<>();
		searchResults = new ArrayList<>();
	}

	@Override
	protected void clear() {
		super.clear();
		metadata.clear();
		searchResults.clear();
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof MetadataContainer<?, ?> metadataContainer) {
			metadata.clear();
			metadata.addAll((Collection<? extends M>) metadataContainer.metadata);
			directories.clear();
			directories.addAll((Collection<? extends D>) metadataContainer.directories);
			searchResults.clear();
			searchResults.addAll(metadataContainer.searchResults);
		} else
			throw new ClassCastException("Cannot cast source to MetadataContainer");
	}

	private void initialiseItems(List<? extends InitialisableItem> list) {
		list.stream().forEach(d -> d.initialise(server(), uri(), client(), token()));
	}

	public List<M> getMetadata() {
		fetch();
		initialiseItems(metadata);
		return metadata;
	}

	public void setMetadata(List<M> metadata) {
		this.metadata = metadata;
	}

	public List<PlexSearchResult> getSearchResults() {
		fetch();
		initialiseItems(searchResults);
		return searchResults;
	}

	public void setSearchResults(List<PlexSearchResult> searchResults) {
		this.searchResults = searchResults;
	}

	public List<D> getDirectories() {
		fetch();
		initialiseItems(directories);
		return directories;
	}

	public void setDirectories(List<D> directories) {
		this.directories = directories;
	}
}
