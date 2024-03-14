package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexDirectory;
import kekolab.javaplex.model.PlexMetadata;
import kekolab.javaplex.model.PlexSearchResult;
import kekolab.javaplex.model.PlexTranscodeSession;

class MetadataContainer<M extends PlexMetadata, D extends PlexDirectory> extends ServerMediaContainer {
	@JsonProperty("Metadata")
	@JsonDeserialize(contentUsing = MetadataDeserializer.class)
	private List<M> metadata;

	@JsonProperty("SearchResult")
	@JsonDeserialize(contentAs = SearchResult.class)
	private List<PlexSearchResult> searchResults;

	@JsonProperty("Directory")
	@JsonDeserialize(contentUsing = DirectoryDeserializer.class)
	private List<D> directories;

	@JsonProperty("TranscodeSession")
	@JsonDeserialize(contentAs = TranscodeSession.class)
	private List<PlexTranscodeSession> transcodeSessions;

	MetadataContainer(URI uri, MediaServer server) {
		super(uri, server);
		metadata = new ArrayList<>();
		searchResults = new ArrayList<>();
		transcodeSessions = new ArrayList<>();
	}

	private void initialiseItems(List<? extends InitialisableItem> list) {
		list.stream().forEach(d -> d.initialise(server(), getUri()));
	}

	public List<M> getMetadata() {
		ensureFetched(metadata);
		initialiseItems(metadata.stream().map(InitialisableItem.class::cast).toList());
		return metadata;
	}

	public void setMetadata(List<M> metadata) {
		this.metadata = metadata;
	}

	public List<PlexSearchResult> getSearchResults() {
		ensureFetched(searchResults);
		initialiseItems(searchResults.stream().map(SearchResult.class::cast).toList());
		return searchResults;
	}

	public void setSearchResults(List<PlexSearchResult> searchResults) {
		this.searchResults = searchResults;
	}

	public List<PlexTranscodeSession> getTranscodeSessions() {
		ensureFetched(transcodeSessions);
		initialiseItems(transcodeSessions.stream().map(TranscodeSession.class::cast).toList());
		return transcodeSessions;
	}

	public void setTranscodeSessions(List<PlexTranscodeSession> transcodeSessions) {
		this.transcodeSessions = transcodeSessions;
	}

	public List<D> getDirectories() {
		ensureFetched(directories);
		initialiseItems(directories.stream().map(Directory.class::cast).toList());
		return directories;
	}

	public void setDirectories(List<D> directories) {
		this.directories = directories;
	}
}
