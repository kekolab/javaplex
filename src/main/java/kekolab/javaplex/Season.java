package kekolab.javaplex;

import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kekolab.javaplex.model.PlexDirectory;
import kekolab.javaplex.model.PlexEpisode;
import kekolab.javaplex.model.PlexSeason;
import kekolab.javaplex.model.PlexSeasonEditor;
import kekolab.javaplex.model.PlexShow;
import kekolab.javaplex.model.PlexShowSection;

class Season extends Child<PlexShow, PlexShowSection> implements PlexSeason {
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
		Season s = (Season) source;
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
		return new MetadataContainer<PlexEpisode, PlexDirectory>(key(), getServer())
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
		return PlexSeason.super.typeId();
	}

	@Override
	public PlexSeasonEditor editor() {
		return new SeasonEditor(this);
	}
}
