package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexSeasonEditor;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowSection;

public class Season extends Child implements PlexSeason {
	private Integer leafCount;
	private Integer viewedLeafCount;
	private Integer year;
	@JsonIgnore
	private UriProvider art, thumb;

	public Season() {
		art = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		PlexSeason s = (PlexSeason) source;
		setLeafCount(s.getLeafCount());
		setViewedLeafCount(s.getViewedLeafCount());
		setYear(s.getYear());
		setArt(s.getArt());
		setThumb(s.getThumb());
	}

	@Override
	public Integer getLeafCount() {
		return leafCount;
	}

	@Override
	public Integer getViewedLeafCount() {
		return viewedLeafCount;
	}

	public void setViewedLeafCount(Integer viewedLeafCount) {
		this.viewedLeafCount = viewedLeafCount;
	}

	public void setLeafCount(Integer leafCount) {
		this.leafCount = leafCount;
	}

	@Override
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

	@Override
	public PlexShow parent() {
		return (PlexShow) super.parent();
	}

	@Override
	public List<PlexEpisode> children() {
		return new MetadataContainer<PlexEpisode, Directory>(key(), getServer())
				.getMetadata();
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
	public PlexSeasonEditor editor() {
		return new SeasonEditor(this);
	}
}
