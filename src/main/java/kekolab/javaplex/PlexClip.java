package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.StringListDeserializer;

public class PlexClip extends PlexVideo<PlexPhotoSection> {
	public static final int TYPE_ID = 14;
	public static final String TYPE_DESCRIPTION = "clip";
	private Integer createdAtTZOffset;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	private String subtype;
	private String tagline;
	private UriProvider art, thumb;

	private ChildDelegate<PlexPhotoalbum> child;

	public PlexClip() {
		art = new UriProvider(this::uri);
		createdAtAccuracy = new ArrayList<>();
		child = new ChildDelegate<>(this::server, this::getClient, this::getToken);
		thumb = new UriProvider(this::uri);
	}

	@Override
	protected void clear() {
		super.clear();
		art.setValue(null);
		createdAtAccuracy.clear();
		createdAtTZOffset = null;
		subtype = null;
		tagline = null;
		thumb.setValue(null);
		child.clear();
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexClip clip) {
			art.setValue(clip.art.getValue());
			createdAtAccuracy = clip.createdAtAccuracy;
			createdAtTZOffset = clip.createdAtTZOffset;
			subtype = clip.subtype;
			tagline = clip.tagline;
			thumb.setValue(clip.thumb.getValue());
			child.update(clip.child);
		} else
			throw new ClassCastException("Cannot cast item to PlexClip");
	}

	public Integer getCreatedAtTZOffset() {
		fetchDetailedIfNullOrEmpty(createdAtTZOffset);
		return createdAtTZOffset;
	}

	public void setCreatedAtTZOffset(Integer createdAtTZOffset) {
		this.createdAtTZOffset = createdAtTZOffset;
	}

	public List<String> getCreatedAtAccuracy() {
		fetchDetailedIfNullOrEmpty(createdAtAccuracy);
		return createdAtAccuracy;
	}

	public void setCreatedAtAccuracy(List<String> createdAtAccuracy) {
		this.createdAtAccuracy = createdAtAccuracy;
	}

	public String getSubtype() {
		fetchDetailedIfNullOrEmpty(subtype);
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getTagline() {
		fetchDetailedIfNullOrEmpty(tagline);
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public PlexPhotoalbum parent() {
		fetchDetailedIfNullOrEmpty(child.parent());
		return (PlexPhotoalbum) child.parent();
	}

	public String getParentGuid() {
		fetchDetailedIfNullOrEmpty(child.getParentGuid());
		return child.getParentGuid();
	}

	public Integer getParentIndex() {
		fetchDetailedIfNullOrEmpty(child.getParentIndex());
		return child.getParentIndex();
	}

	public String getParentKey() {
		fetchDetailedIfNullOrEmpty(child.getParentKey());
		return child.getParentKey();
	}

	public URI parentKey() {
		fetchDetailedIfNullOrEmpty(child.parentKey());
		return child.parentKey();
	}

	public Integer getParentRatingKey() {
		fetchDetailedIfNullOrEmpty(child.getParentRatingKey());
		return child.getParentRatingKey();
	}

	public URI parentRatingKey() {
		fetchDetailedIfNullOrEmpty(child.parentRatingKey());
		return child.parentRatingKey();
	}

	public String getParentStudio() {
		fetchDetailedIfNullOrEmpty(child.getParentStudio());
		return child.getParentStudio();
	}

	public String getParentTheme() {
		fetchDetailedIfNullOrEmpty(child.getParentTheme());
		return child.getParentTheme();
	}

	public URI parentTheme() {
		fetchDetailedIfNullOrEmpty(child.parentTheme());
		return child.parentTheme();
	}

	public String getParentThumb() {
		fetchDetailedIfNullOrEmpty(child.getParentThumb());
		return child.getParentThumb();
	}

	public URI parentThumb() {
		fetchDetailedIfNullOrEmpty(child.parentThumb());
		return child.parentThumb();
	}

	public String getParentTitle() {
		fetchDetailedIfNullOrEmpty(child.getParentTitle());
		return child.getParentTitle();
	}

	public Integer getParentYear() {
		fetchDetailedIfNullOrEmpty(child.getParentYear());
		return child.getParentYear();
	}

	public void setParentGuid(String arg) {
		child.setParentGuid(arg);
	}

	public void setParentIndex(Integer arg) {
		child.setParentIndex(arg);
	}

	public void setParentKey(String arg) {
		child.setParentKey(arg);
	}

	public void setParentRatingKey(Integer arg) {
		child.setParentRatingKey(arg);
	}

	public void setParentStudio(String arg) {
		child.setParentStudio(arg);
	}

	public void setParentTheme(String arg) {
		child.setParentTheme(arg);
	}

	public void setParentThumb(String arg) {
		child.setParentThumb(arg);
	}

	public void setParentTitle(String arg) {
		child.setParentTitle(arg);
	}

	public void setParentYear(Integer arg) {
		child.setParentYear(arg);
	}

	public String getArt() {
		fetchDetailedIfNullOrEmpty(art.getValue());
		return (String) art.getValue();
	}

	public URI art() {
		fetchDetailedIfNullOrEmpty(art.uri());
		return art.uri();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public String getThumb() {
		fetchDetailedIfNullOrEmpty(thumb.getValue());
		return (String) thumb.getValue();
	}

	public URI thumb() {
		fetchDetailedIfNullOrEmpty(thumb.uri());
		return thumb.uri();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

}
