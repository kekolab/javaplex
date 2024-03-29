package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexDirectory;
import kekolab.javaplex.model.PlexField;
import kekolab.javaplex.model.PlexMetadata;

abstract class Metadata extends Directory implements PlexMetadata {
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date addedAt;
	private String guid;
	@JsonProperty("Field")
	@JsonDeserialize(contentAs = Field.class)
	private List<PlexField> fields;
	private Integer ratingKey;
	private String summary;
	private String type;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date updatedAt;
	private Integer viewCount;

	public Metadata() {
		fields = new ArrayList<>();
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
		ensureDetailed(fields);
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

	void update(Metadata source) {
		setAddedAt(source.getAddedAt());
		setFields(source.getFields());
		setGuid(source.getGuid());
		setKey(source.getKey());
		setRatingKey(source.getRatingKey());
		setSummary(source.getSummary());
		setTitle(source.getTitle());
		setType(source.getType());
		setUpdatedAt(source.getUpdatedAt());
		setViewCount(source.getViewCount());
	}

	void ensureDetailed(Object field) {
		if (!detailed() && (field == null || field instanceof Collection collection && collection.isEmpty())) 
			update(new MetadataContainer<Metadata, PlexDirectory>(ratingKey(), getServer()).getMetadata().get(0));
	}

	private boolean detailed() {
		return uri().getPath().equalsIgnoreCase(ratingKey().getPath());
	}

	public abstract URI ratingKey();

	Boolean getFieldLocked(String field) {
		return getFields().stream().filter(f -> f.getName().equals(field)).map(PlexField::getLocked)
				.findAny().orElse(null);
	}
}