package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PlexSeason extends Child<PlexShowSection, PlexShow> implements PlexParent<PlexShowSection, PlexEpisode> {
	public static final int TYPE_ID = 3;
	public static final String TYPE_DESCRIPTION = "season";

	private Integer leafCount;
	private Integer viewedLeafCount;
	private Integer year;
	@JsonIgnore
	private UriProvider art, thumb;

	public PlexSeason() {
		art = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
	}

	@Override
	void update(PlexMetadata source) {
		super.update(source);
		PlexSeason s = (PlexSeason) source;
		setLeafCount(s.getLeafCount());
		setViewedLeafCount(s.getViewedLeafCount());
		setYear(s.getYear());
		setArt(s.getArt());
		setThumb(s.getThumb());
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

	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	public URI art() {
		ensureDetailed(art.uri());
		return art.uri();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public String getThumb() {
		ensureDetailed(thumb.getValue());
		return (String) thumb.getValue();
	}

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
}
