package kekolab.javaplex;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.mappers.IntegerListDeserializer;
import kekolab.javaplex.mappers.StreamDeserializer;

public class PlexPart extends MediatagAttribute {
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

	public PlexPart() {
		streams = new ArrayList<>();
		key = new UriProvider(() -> getParentTag().server().uri());
	}

	public Integer getOrientation() {
		getParentTag().fetchDetailedIfNullOrEmpty(orientation);
		return orientation;
	}

	public void setOrientation(Integer orientation) {
		this.orientation = orientation;
	}

	public Integer getId() {
		getParentTag().fetchDetailedIfNullOrEmpty(id);
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getDuration() {
		getParentTag().fetchDetailedIfNullOrEmpty(duration);
		return duration;
	}

	public String getFile() {
		getParentTag().fetchDetailedIfNullOrEmpty(file);
		return file;
	}

	public String getContainer() {
		getParentTag().fetchDetailedIfNullOrEmpty(container);
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

	public String getVideoProfile() {
		getParentTag().fetchDetailedIfNullOrEmpty(videoProfile);
		return videoProfile;
	}

	public Long getSize() {
		getParentTag().fetchDetailedIfNullOrEmpty(size);
		return size;
	}

	public void setVideoProfile(String videoProfile) {
		this.videoProfile = videoProfile;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getAudioProfile() {
		getParentTag().fetchDetailedIfNullOrEmpty(audioProfile);
		return audioProfile;
	}

	public Boolean getHas64bitOffsets() {
		getParentTag().fetchDetailedIfNullOrEmpty(has64bitOffsets);
		return has64bitOffsets;
	}

	public Boolean getOptimizedForStreaming() {
		getParentTag().fetchDetailedIfNullOrEmpty(optimizedForStreaming);
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

	public Integer getHasThumbnail() {
		getParentTag().fetchDetailedIfNullOrEmpty(hasThumbnail);
		return hasThumbnail;
	}

	public void setHasThumbnail(Integer hasThumbnail) {
		this.hasThumbnail = hasThumbnail;
	}

	public List<PlexStream> getStreams() {
		getParentTag().fetchDetailedIfNullOrEmpty(streams);
		return streams;
	}

	public void setStreams(List<PlexStream> streams) {
		this.streams = streams;
	}

	public Boolean getAccessible() {
		getParentTag().fetchDetailedIfNullOrEmpty(accessible);
		return accessible;
	}

	public void setAccessible(Boolean accessible) {
		this.accessible = accessible;
	}

	public Boolean getExists() {
		getParentTag().fetchDetailedIfNullOrEmpty(exists);
		return exists;
	}

	public void setExists(Boolean exists) {
		this.exists = exists;
	}

	public Integer getDeepAnalysisVersion() {
		getParentTag().fetchDetailedIfNullOrEmpty(deepAnalysisVersion);
		return deepAnalysisVersion;
	}

	public void setDeepAnalysisVersion(Integer deepAnalysisVersion) {
		this.deepAnalysisVersion = deepAnalysisVersion;
	}

	public List<Integer> getRequiredBandwidths() {
		getParentTag().fetchDetailedIfNullOrEmpty(requiredBandwidths);
		return requiredBandwidths;
	}

	public void setRequiredBandwidths(List<Integer> requiredBandwidths) {
		this.requiredBandwidths = requiredBandwidths;
	}

	public String getKey() {
		return (String) key.getValue();
	}

	public void setKey(String key) {
		this.key.setValue(key);
	}

	public URI key() {
		return key.uri();
	}
}
