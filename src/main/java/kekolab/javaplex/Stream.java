package kekolab.javaplex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.IntegerListDeserializer;
import kekolab.javaplex.model.PlexStream;

public class Stream extends MediatagAttribute implements PlexStream  { // TODO abstract?
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

	@Override
	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	@Override
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Stream() {
		requiredBandwidths = new ArrayList<>();
	}

	@Override
	public Boolean getDefault() {
		ensureDetailed(_default);
		return _default;
	}

	@Override
	public String getCodec() {
		ensureDetailed(codec);
		return codec;
	}

	@Override
	public Integer getId() {
		ensureDetailed(id);
		return id;
	}

	@Override
	public Integer getStreamType() {
		ensureDetailed(streamType);
		return streamType;
	}

	@Override
	public Integer getIndex() {
		ensureDetailed(index);
		return index;
	}

	@Override
	public String getKey() {
		ensureDetailed(key);
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public Integer getBitrate() {
		ensureDetailed(bitrate);
		return bitrate;
	}

	public void setBitrate(Integer bitrate) {
		this.bitrate = bitrate;
	}

	@Override
	public Boolean getForced() {
		ensureDetailed(forced);
		return forced;
	}

	public void setForced(Boolean forced) {
		this.forced = forced;
	}

	@Override
	public String getDisplayTitle() {
		ensureDetailed(displayTitle);
		return displayTitle;
	}

	public void setDisplayTitle(String displayTitle) {
		this.displayTitle = displayTitle;
	}

	@Override
	public Boolean getHeaderCompression() {
		ensureDetailed(headerCompression);
		return headerCompression;
	}

	public void setHeaderCompression(Boolean headerCompression) {
		this.headerCompression = headerCompression;
	}

	@Override
	public String getLanguage() {
		ensureDetailed(language);
		return language;
	}

	@Override
	public String getLanguageCode() {
		ensureDetailed(languageCode);
		return languageCode;
	}

	@Override
	public String getLanguageTag() {
		ensureDetailed(languageTag);
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

	@Override
	public String getExtendedDisplayTitle() {
		ensureDetailed(extendedDisplayTitle);
		return extendedDisplayTitle;
	}

	public void setExtendedDisplayTitle(String extendedDisplayTitle) {
		this.extendedDisplayTitle = extendedDisplayTitle;
	}

	@Override
	public String getTitle() {
		ensureDetailed(title);
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public Integer getStreamIdentifier() {
		ensureDetailed(streamIdentifier);
		return streamIdentifier;
	}

	public void setStreamIdentifier(Integer streamIdentifier) {
		this.streamIdentifier = streamIdentifier;
	}

	@Override
	public List<Integer> getRequiredBandwidths() {
		ensureDetailed(requiredBandwidths);
		return requiredBandwidths;
	}

	public void setRequiredBandwidths(List<Integer> requiredBandwidths) {
		this.requiredBandwidths = requiredBandwidths;
	}

	public void setDefault(Boolean _default) {
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