package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;

import kekolab.javaplex.model.PlexTextStream;

public class TextStream extends Stream implements PlexTextStream {
	private Boolean selected;
	private Boolean hearingImpaired;
	@JsonProperty("transient")
	private Integer _transient;
	private String format;
	private String providerTitle;
	private String sourceKey;
	private Integer subIndex;
	private Integer userID;
	private Double score;

	@Override
	public Boolean getSelected() {
		ensureDetailed(selected);
		return selected;
	}

	@Override
	public Integer getTransient() {
		ensureDetailed(_transient);
		return _transient;
	}

	@Override
	public String getFormat() {
		ensureDetailed(format);
		return format;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public void setTransient(Integer _transient) {
		this._transient = _transient;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public Integer getSubIndex() {
		ensureDetailed(subIndex);
		return subIndex;
	}

	public void setSubIndex(Integer subIndex) {
		this.subIndex = subIndex;
	}

	@Override
	public Boolean getHearingImpaired() {
		ensureDetailed(hearingImpaired);
		return hearingImpaired;
	}

	public void setHearingImpaired(Boolean hearingImpaired) {
		this.hearingImpaired = hearingImpaired;
	}

	@Override
	public String getProviderTitle() {
		ensureDetailed(providerTitle);
		return providerTitle;
	}

	public void setProviderTitle(String providerTitle) {
		this.providerTitle = providerTitle;
	}

	@Override
	public String getSourceKey() {
		ensureDetailed(sourceKey);
		return sourceKey;
	}

	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}

	@Override
	public Integer getUserID() {
		ensureDetailed(userID);
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	@Override
	public Double getScore() {
		ensureDetailed(score);
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
