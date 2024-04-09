package kekolab.javaplex;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexSearchResult;

public class SearchResult extends InitialisableItem implements PlexSearchResult {
	private Double score;
	@JsonProperty("Metadata")
	@JsonDeserialize(using = MetadataDeserializer.class)
	private Metadata item;

	@Override
	public Double getScore() {
		return score;
	}

	@Override
	public Metadata getItem() {
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
