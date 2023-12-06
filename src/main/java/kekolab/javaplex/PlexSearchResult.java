package kekolab.javaplex;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.MetadataDeserializer;

public class PlexSearchResult extends InitialisableItem {
	private Double score;
	@JsonProperty("Metadata")
	@JsonDeserialize(using = MetadataDeserializer.class)
	private PlexMetadata item;

	@Override
	protected void clear() {
		super.clear();
		score = null;
		item = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexSearchResult searchResult) {
			score = searchResult.score;
			item = searchResult.item;
		} else
			throw new ClassCastException("Cannot cast source to PlexSearchResult");
	}

	public Double getScore() {
		return score;
	}

	public PlexMetadata getItem() {
		return item;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public void setItem(PlexMetadata item) {
		this.item = item;
	}

	@Override
	protected void initialise(PlexMediaServer container, URI uri, PlexHTTPClient client, String token) {
		super.initialise(container, uri, client, token);
		item.initialise(container, uri, client, token);
	}
}
