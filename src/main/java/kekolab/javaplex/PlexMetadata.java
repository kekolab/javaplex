package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.TimestampDeserializer;

public abstract class PlexMetadata extends PlexDirectory {
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date addedAt;
	private String guid;
	@JsonProperty("Field")
	private List<PlexField> fields;
	private Integer ratingKey;
	private String summary;
	private String type;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date updatedAt;
	private Integer viewCount;

	public PlexMetadata() {
		fields = new ArrayList<>();
	}

	@Override
	protected void clear() {
		super.clear();
		addedAt = null;
		fields.clear();
		guid = null;
		ratingKey = null;
		summary = null;
		type = null;
		updatedAt = null;
		viewCount = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexMetadata metadata) {
			addedAt = metadata.addedAt;
			fields.clear();
			fields.addAll(metadata.fields);
			guid = metadata.guid;
			ratingKey = metadata.ratingKey;
			summary = metadata.summary;
			type = metadata.type;
			updatedAt = metadata.updatedAt;
			viewCount = metadata.viewCount;
		} else
			throw new ClassCastException("Cannot cast item to PlexMetadata");
	}

	public Integer getRatingKey() {
		return ratingKey;
	}

	public void setRatingKey(Integer ratingKey) {
		this.ratingKey = ratingKey;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}

	public List<PlexField> getFields() {
		fetchDetailedIfNullOrEmpty(fields);
		return fields;
	}

	public void setFields(List<PlexField> fields) {
		this.fields = fields;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * The method verifies whether the current mediatag is already detailed. If it
	 * is not detailed and the argument is null or the argument is a zero-length
	 * array (i.e. an unitialised array) then the current {@link PlexMediatag} is
	 * updated with the detailed version of itself. If the {@link PlexMediatag} is
	 * already detailed, nothing is done.
	 * 
	 * @param argument the argument to test for nullity or zero-length
	 * @
	 * @
	 */
	protected void fetchDetailedIfNullOrEmpty(Object argument) {
		if (!detailed()) {
			if (argument == null)
				detail();
			if (argument instanceof Collection && ((Collection<?>) argument).size() == 0)
				detail();
		}
	}

	private boolean detailed() {
		return server().uri().getPath().equalsIgnoreCase(ratingKey().getPath());
	}

	private void detail() {
		List<PlexMetadata> results = new MetadataContainer<PlexMetadata, PlexDirectory>(ratingKey(), getClient(),
				getToken(), server())
				.getMetadata();
		if (results.size() == 1)
			update(results.get(0));
		else
			throw new RuntimeException("0 or more than 1 detailed version of the mediatag was found");
	}

	public abstract URI ratingKey();

	protected boolean isLocked(String field) {
		return getFields().stream().filter(f -> f.getName().equals(field)).map(PlexField::getLocked)
				.findAny().orElse(false);
	}

	public void delete() {
		getClient().execute(ClassicRequestBuilder.delete(ratingKey()).build(), getToken());
		clear();
	}
}