package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PlexSeason extends PlexMediatag<PlexShowSection> {
	public static final int TYPE_ID = 3;
	public static final String TYPE_DESCRIPTION = "season";
	private Integer leafCount;
	private Integer viewedLeafCount;
	private Integer year;
	@JsonIgnore
	private ChildDelegate<PlexShow> child;
	private UriProvider art, thumb;

	public PlexSeason() {
		art = new UriProvider(this::uri);
		child = new ChildDelegate<>(this::server, this::getClient, this::getToken);
		thumb = new UriProvider(this::uri);
	}

	@Override
	protected void clear() {
		super.clear();
		art.setValue(null);
		leafCount = null;
		child.clear();
		thumb.setValue(null);
		viewedLeafCount = null;
		year = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexSeason season) {
			art.setValue(season.art.getValue());
			leafCount = season.leafCount;
			child.update(season.child);
			thumb.setValue(season.thumb.getValue());
			viewedLeafCount = season.viewedLeafCount;
			year = season.year;
		} else
			throw new ClassCastException("Cannot cast item to PlexSeason");
	}

	public Integer getLeafCount() {
		return leafCount;
	}

	public Integer getViewedLeafCount() {
		return viewedLeafCount;
	}

	public void setViewedLeafCount(Integer viewedLeafCount) {
		this.viewedLeafCount = viewedLeafCount;
	}

	public void setLeafCount(Integer leafCount) {
		this.leafCount = leafCount;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public PlexShowSection section() {
		return (PlexShowSection) super.section();
	}

	public PlexShow parent() {
		fetchDetailedIfNullOrEmpty(child.parent());
		return (PlexShow) child.parent();
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

	public void setParentYear(Integer parentYear) {
		child.setParentYear(parentYear);
	}

	public void setParentTitle(String parentTitle) {
		child.setParentTitle(parentTitle);
	}

	public void setParentThumb(String parentThumb) {
		child.setParentThumb(parentThumb);
	}

	public void setParentTheme(String parentTheme) {
		child.setParentTheme(parentTheme);
	}

	public void setParentStudio(String parentStudio) {
		child.setParentStudio(parentStudio);
	}

	public void setParentRatingKey(Integer parentRatingKey) {
		child.setParentRatingKey(parentRatingKey);
	}

	public void setParentKey(String parentKey) {
		child.setParentKey(parentKey);
	}

	public void setParentIndex(Integer parentIndex) {
		child.setParentIndex(parentIndex);
	}

	public void setParentGuid(String parentGuid) {
		child.setParentGuid(parentGuid);
	}

	public List<PlexEpisode> children() {
		return new MetadataContainer<PlexEpisode, PlexDirectory>(key(), getClient(), getToken(), server())
				.getMetadata();
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
