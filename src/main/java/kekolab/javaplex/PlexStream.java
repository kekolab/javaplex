package kekolab.javaplex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.IntegerListDeserializer;

public class PlexStream extends MediatagAttribute { // TODO abstract?
	@JsonDeserialize(using = IntegerListDeserializer.class)
	private List<Integer> requiredBandwidths;
	@JsonProperty("default")
	private Boolean _default;
	private String codec;
	private String key;
	private Integer id;
	private Integer index;
	private Integer streamType;
	private Integer bitrate;
	private Boolean forced;
	private String displayTitle;
	private Boolean headerCompression;
	private String language;
	private String languageCode;
	private String languageTag;
	private String extendedDisplayTitle;
	private String title;
	private Integer streamIdentifier;
	private String decision;
	private String location;

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public PlexStream() {
		requiredBandwidths = new ArrayList<>();
	}

	public Boolean get_default() {
		getParentTag().fetchDetailedIfNullOrEmpty(_default);
		return _default;
	}

	public String getCodec() {
		getParentTag().fetchDetailedIfNullOrEmpty(codec);
		return codec;
	}

	public Integer getId() {
		getParentTag().fetchDetailedIfNullOrEmpty(id);
		return id;
	}

	public Integer getStreamType() {
		getParentTag().fetchDetailedIfNullOrEmpty(streamType);
		return streamType;
	}

	public Integer getIndex() {
		getParentTag().fetchDetailedIfNullOrEmpty(index);
		return index;
	}

	public String getKey() {
		getParentTag().fetchDetailedIfNullOrEmpty(key);
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getBitrate() {
		getParentTag().fetchDetailedIfNullOrEmpty(bitrate);
		return bitrate;
	}

	public void setBitrate(Integer bitrate) {
		this.bitrate = bitrate;
	}

	public Boolean getForced() {
		getParentTag().fetchDetailedIfNullOrEmpty(forced);
		return forced;
	}

	public void setForced(Boolean forced) {
		this.forced = forced;
	}

	public String getDisplayTitle() {
		getParentTag().fetchDetailedIfNullOrEmpty(displayTitle);
		return displayTitle;
	}

	public void setDisplayTitle(String displayTitle) {
		this.displayTitle = displayTitle;
	}

	public Boolean getHeaderCompression() {
		getParentTag().fetchDetailedIfNullOrEmpty(headerCompression);
		return headerCompression;
	}

	public void setHeaderCompression(Boolean headerCompression) {
		this.headerCompression = headerCompression;
	}

	public String getLanguage() {
		getParentTag().fetchDetailedIfNullOrEmpty(language);
		return language;
	}

	public String getLanguageCode() {
		getParentTag().fetchDetailedIfNullOrEmpty(languageCode);
		return languageCode;
	}

	public String getLanguageTag() {
		getParentTag().fetchDetailedIfNullOrEmpty(languageTag);
		return languageTag;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public void setLanguageTag(String languageTag) {
		this.languageTag = languageTag;
	}

	public String getExtendedDisplayTitle() {
		getParentTag().fetchDetailedIfNullOrEmpty(extendedDisplayTitle);
		return extendedDisplayTitle;
	}

	public void setExtendedDisplayTitle(String extendedDisplayTitle) {
		this.extendedDisplayTitle = extendedDisplayTitle;
	}

	public String getTitle() {
		getParentTag().fetchDetailedIfNullOrEmpty(title);
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStreamIdentifier() {
		getParentTag().fetchDetailedIfNullOrEmpty(streamIdentifier);
		return streamIdentifier;
	}

	public void setStreamIdentifier(Integer streamIdentifier) {
		this.streamIdentifier = streamIdentifier;
	}

	public List<Integer> getRequiredBandwidths() {
		getParentTag().fetchDetailedIfNullOrEmpty(requiredBandwidths);
		return requiredBandwidths;
	}

	public void setRequiredBandwidths(List<Integer> requiredBandwidths) {
		this.requiredBandwidths = requiredBandwidths;
	}

	public void set_default(Boolean _default) {
		this._default = _default;
	}

	public void setCodec(String codec) {
		this.codec = codec;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStreamType(Integer streamType) {
		this.streamType = streamType;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}