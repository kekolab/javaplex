package kekolab.javaplex;

import java.util.List;

public class PlexSeason extends Child<PlexShowSection, PlexShow> implements PlexParent<PlexShowSection, PlexEpisode> {
	public static final int TYPE_ID = 3;
	public static final String TYPE_DESCRIPTION = "season";

	private Integer leafCount;
	private Integer viewedLeafCount;
	private Integer year;

	@Override
	void update(PlexMetadata source) {
		super.update(source);
		PlexSeason s = (PlexSeason) source;
		setLeafCount(s.getLeafCount());
		setViewedLeafCount(s.getViewedLeafCount());
		setYear(s.getYear());
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

	public List<PlexEpisode> children() {
		return new PlexGeneralPurposeMediaContainer<PlexEpisode, PlexDirectory>(key(), getServer())
				.getMetadata();
	}

	@Override
	public int typeId() {
		return TYPE_ID;
	}
}
