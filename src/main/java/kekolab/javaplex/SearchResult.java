package kekolab.javaplex;

import java.net.URI;

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
	protected void initialise(MediaServer server, URI uri) {
		super.initialise(server, uri);
		((Metadata) item).initialise(server, uri);
	}
}
