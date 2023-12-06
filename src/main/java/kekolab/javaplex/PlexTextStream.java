package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlexTextStream extends PlexStream {
	public static final int TYPE_ID = 3;
	
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

	public Boolean getSelected() {
		getParentTag().fetchDetailedIfNullOrEmpty(selected);
		return selected;
	}

	public Integer get_transient() {
		getParentTag().fetchDetailedIfNullOrEmpty(_transient);
		return _transient;
	}

	public String getFormat() {
		getParentTag().fetchDetailedIfNullOrEmpty(format);
		return format;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public void set_transient(Integer _transient) {
		this._transient = _transient;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer getSubIndex() {
		getParentTag().fetchDetailedIfNullOrEmpty(subIndex);
		return subIndex;
	}

	public void setSubIndex(Integer subIndex) {
		this.subIndex = subIndex;
	}

	public Boolean getHearingImpaired() {
		getParentTag().fetchDetailedIfNullOrEmpty(hearingImpaired);
		return hearingImpaired;
	}

	public void setHearingImpaired(Boolean hearingImpaired) {
		this.hearingImpaired = hearingImpaired;
	}

	public String getProviderTitle() {
		getParentTag().fetchDetailedIfNullOrEmpty(providerTitle);
		return providerTitle;
	}

	public void setProviderTitle(String providerTitle) {
		this.providerTitle = providerTitle;
	}

	public String getSourceKey() {
		getParentTag().fetchDetailedIfNullOrEmpty(sourceKey);
		return sourceKey;
	}

	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}

	public Integer getUserID() {
		getParentTag().fetchDetailedIfNullOrEmpty(userID);
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Double getScore() {
		getParentTag().fetchDetailedIfNullOrEmpty(score);
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
