package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.IntegerListDeserializer;
import kekolab.javaplex.model.PlexPart;
import kekolab.javaplex.model.PlexStream;

public class Part extends MediatagAttribute implements PlexPart  {
	@JsonProperty("Stream")
	@JsonDeserialize(contentUsing = StreamDeserializer.class)
	private List<PlexStream> streams;
	@JsonDeserialize(using = IntegerListDeserializer.class)
	private List<Integer> requiredBandwidths;
	private Integer id;
	private Integer hasThumbnail;
	private Integer orientation;
	private Long duration;
	private Long size;
	private String file;
	private String container;
	private String videoProfile;
	private String audioProfile;
	private Boolean has64bitOffsets;
	private Boolean optimizedForStreaming;
	private Boolean accessible;
	private Boolean exists;
	private Integer deepAnalysisVersion;
	private UriProvider key;
	private Integer height;
	private Integer width;
	private String protocol;
	private String decision;
	private Boolean selected;

	@Override
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Override
	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	@Override
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Override
	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	@Override
	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Part() {
		streams = new ArrayList<>();
		key = new UriProvider(() -> getParentTag().getServer().getUri());
	}

	@Override
	public Integer getOrientation() {
		ensureDetailed(orientation);
		return orientation;
	}

	public void setOrientation(Integer orientation) {
		this.orientation = orientation;
	}

	@Override
	public Integer getId() {
		ensureDetailed(id);
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Long getDuration() {
		ensureDetailed(duration);
		return duration;
	}

	@Override
	public String getFile() {
		ensureDetailed(file);
		return file;
	}

	@Override
	public String getContainer() {
		ensureDetailed(container);
		return container;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	@Override
	public String getVideoProfile() {
		ensureDetailed(videoProfile);
		return videoProfile;
	}

	@Override
	public Long getSize() {
		ensureDetailed(size);
		return size;
	}

	public void setVideoProfile(String videoProfile) {
		this.videoProfile = videoProfile;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	@Override
	public String getAudioProfile() {
		ensureDetailed(audioProfile);
		return audioProfile;
	}

	@Override
	public Boolean getHas64bitOffsets() {
		ensureDetailed(has64bitOffsets);
		return has64bitOffsets;
	}

	@Override
	public Boolean getOptimizedForStreaming() {
		ensureDetailed(optimizedForStreaming);
		return optimizedForStreaming;
	}

	public void setAudioProfile(String audioProfile) {
		this.audioProfile = audioProfile;
	}

	public void setHas64bitOffsets(Boolean has64bitOffsets) {
		this.has64bitOffsets = has64bitOffsets;
	}

	public void setOptimizedForStreaming(Boolean optimizedForStreaming) {
		this.optimizedForStreaming = optimizedForStreaming;
	}

	@Override
	public Integer getHasThumbnail() {
		ensureDetailed(hasThumbnail);
		return hasThumbnail;
	}

	public void setHasThumbnail(Integer hasThumbnail) {
		this.hasThumbnail = hasThumbnail;
	}

	@Override
	public List<PlexStream> getStreams() {
		ensureDetailed(streams);
		return streams;
	}

	public void setStreams(List<PlexStream> streams) {
		this.streams = streams;
	}

	@Override
	public Boolean getAccessible() {
		ensureDetailed(accessible);
		return accessible;
	}

	public void setAccessible(Boolean accessible) {
		this.accessible = accessible;
	}

	@Override
	public Boolean getExists() {
		ensureDetailed(exists);
		return exists;
	}

	public void setExists(Boolean exists) {
		this.exists = exists;
	}

	@Override
	public Integer getDeepAnalysisVersion() {
		ensureDetailed(deepAnalysisVersion);
		return deepAnalysisVersion;
	}

	public void setDeepAnalysisVersion(Integer deepAnalysisVersion) {
		this.deepAnalysisVersion = deepAnalysisVersion;
	}

	@Override
	public List<Integer> getRequiredBandwidths() {
		ensureDetailed(requiredBandwidths);
		return requiredBandwidths;
	}

	public void setRequiredBandwidths(List<Integer> requiredBandwidths) {
		this.requiredBandwidths = requiredBandwidths;
	}

	@Override
	public String getKey() {
		return (String) key.getValue();
	}

	public void setKey(String key) {
		this.key.setValue(key);
	}

	@Override
	public URI key() {
		return key.uri();
	}
}
