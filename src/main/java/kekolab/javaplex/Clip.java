package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.StringListDeserializer;
import kekolab.javaplex.model.PlexClip;
import kekolab.javaplex.model.PlexClipEditor;
import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexPhotoalbum;

public class Clip extends Video implements PlexClip {
	private Integer createdAtTZOffset;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> createdAtAccuracy;
	private String subtype;
	private String tagline;
	private UriProvider art, thumb;

	@JsonIgnore
	private Child asChild;

	public void setParentGuid(String guid) {
		asChild.setParentGuid(guid);
	}

	public void setParentIndex(Integer index) {
		asChild.setParentIndex(index);
	}

	public void setParentStudio(String studio) {
		asChild.setParentStudio(studio);
	}

	public void setParentTitle(String title) {
		asChild.setParentTitle(title);
	}

	public void setParentYear(Integer year) {
		asChild.setParentYear(year);
	}

	public void setParentKey(String key) {
		asChild.setParentKey(key);
	}

	public void setParentRatingKey(Integer ratingKey) {
		asChild.setParentRatingKey(ratingKey);
	}

	public void setParentThumb(String thumb) {
		asChild.setParentThumb(thumb);
	}

	public void setParentTheme(String theme) {
		asChild.setParentTheme(theme);
	}

	@Override
	public PlexPhotoalbum parent() {
		return (PlexPhotoalbum) asChild.parent();
	}

	@Override
	public String getParentGuid() {
		return asChild.getParentGuid();
	}

	@Override
	public Integer getParentIndex() {
		return asChild.getParentIndex();
	}

	@Override
	public String getParentKey() {
		return asChild.getParentKey();
	}

	@Override
	public URI parentKey() {
		return asChild.parentKey();
	}

	@Override
	public Integer getParentRatingKey() {
		return asChild.getParentRatingKey();
	}

	@Override
	public URI parentRatingKey() {
		return asChild.parentRatingKey();
	}

	@Override
	public String getParentStudio() {
		return asChild.getParentStudio();
	}

	@Override
	public String getParentTheme() {
		return asChild.getParentTheme();
	}

	@Override
	public URI parentTheme() {
		return asChild.parentTheme();
	}

	@Override
	public String getParentThumb() {
		return asChild.getParentThumb();
	}

	@Override
	public URI parentThumb() {
		return asChild.parentThumb();
	}

	@Override
	public String getParentTitle() {
		return asChild.getParentTitle();
	}

	@Override
	public Integer getParentYear() {
		return asChild.getParentYear();
	}

	public Clip() {
		art = new UriProvider(this::uri);
		createdAtAccuracy = new ArrayList<>();
		asChild = new Child() {
			@Override
			public int typeId() {
				return TYPE_ID;
			}
		};
		thumb = new UriProvider(this::uri);
	}

	@Override
	public Integer getCreatedAtTZOffset() {
		ensureDetailed(createdAtTZOffset);
		return createdAtTZOffset;
	}

	public void setCreatedAtTZOffset(Integer createdAtTZOffset) {
		this.createdAtTZOffset = createdAtTZOffset;
	}

	@Override
	public List<String> getCreatedAtAccuracy() {
		ensureDetailed(createdAtAccuracy);
		return createdAtAccuracy;
	}

	public void setCreatedAtAccuracy(List<String> createdAtAccuracy) {
		this.createdAtAccuracy = createdAtAccuracy;
	}

	@Override
	public String getSubtype() {
		ensureDetailed(subtype);
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	@Override
	public String getTagline() {
		ensureDetailed(tagline);
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	@Override
	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	@Override
	public URI art() {
		ensureDetailed(art.uri());
		return art.uri();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	@Override
	public String getThumb() {
		ensureDetailed(thumb.getValue());
		return (String) thumb.getValue();
	}

	@Override
	public URI thumb() {
		ensureDetailed(thumb.uri());
		return thumb.uri();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}

	@Override
	public PlexClipEditor editor() {
		return new ClipEditor(this);
	}

	@Override
	public PlexPhotoSection section() {
		return (PlexPhotoSection) super.section();
	}
}
