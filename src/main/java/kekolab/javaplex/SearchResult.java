package kekolab.javaplex;

import java.net.URI;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexMetadata;
import kekolab.javaplex.model.PlexSearchResult;

class SearchResult extends InitialisableItem implements PlexSearchResult {
	private Double score;
	@JsonProperty("Metadata")
	@JsonDeserialize(using = MetadataDeserializer.class)
	private PlexMetadata item;

	public Double getScore() {
		return score;
	}

	public PlexMetadata getItem() {
		return item;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public void setItem(Metadata item) {
		this.item = item;
	}

	@Override
	protected void initialise(MediaServer container, URI uri, PlexHTTPClient client, Optional<String> token) {
		super.initialise(container, uri, client, token);
		((Metadata) item).initialise(container, uri, client, token);
	}
}
