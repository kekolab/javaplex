package kekolab.javaplex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexMedia;
import kekolab.javaplex.model.PlexPart;

public class Media extends MediatagAttribute implements PlexMedia  { // TODO Forse sarebbe opportuno distinguere tra
	// i media di audio, video e foto
	@JsonProperty("Part")
	@JsonDeserialize(contentAs = Part.class)
	private List<PlexPart> parts = new ArrayList<>();
	private Integer id;
	private Integer bitrate;
	private Integer width;
	private Integer height;
	private Integer audioChannels;
	private Boolean optimizedForStreaming;
	private Integer orientation;
	private Integer iso;
	private String audioCodec;
	private String videoCodec;
	private String container;
	private String videoFrameRate;
	private String videoProfile;
	private String videoResolution;
	private String audioProfile;
	private String key;
	private String file;
	private String aperture;
	private String exposure;
	private String make;
	private String model;
	private String lens;
	private Boolean has64bitOffsets;
	private Long duration;
	private Long size;
	private Double aspectRatio;
	private String protocol;
	private Boolean selected;

	@Override
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Override
	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	@Override
	public Integer getId() {
		ensureDetailed(id);
		return id;
	}

	@Override
	public Integer getBitrate() {
		ensureDetailed(bitrate);
		return bitrate;
	}

	@Override
	public Integer getWidth() {
		ensureDetailed(width);
		return width;
	}

	@Override
	public Integer getHeight() {
		ensureDetailed(height);
		return height;
	}

	@Override
	public Integer getAudioChannels() {
		ensureDetailed(audioChannels);
		return audioChannels;
	}

	@Override
	public String getAudioCodec() {
		ensureDetailed(audioCodec);
		return audioCodec;
	}

	@Override
	public String getVideoCodec() {
		ensureDetailed(videoCodec);
		return videoCodec;
	}

	@Override
	public String getContainer() {
		ensureDetailed(container);
		return container;
	}

	@Override
	public String getVideoFrameRate() {
		ensureDetailed(videoFrameRate);
		return videoFrameRate;
	}

	@Override
	public String getVideoProfile() {
		ensureDetailed(videoProfile);
		return videoProfile;
	}

	@Override
	public Long getDuration() {
		ensureDetailed(duration);
		return duration;
	}

	@Override
	public Double getAspectRatio() {
		ensureDetailed(aspectRatio);
		return aspectRatio;
	}

	@Override
	public String getVideoResolution() {
		ensureDetailed(videoResolution);
		return videoResolution;
	}

	public void setVideoResolution(String videoResolution) {
		this.videoResolution = videoResolution;
	}

	@Override
	public List<PlexPart> getParts() {
		ensureDetailed(parts);
		return parts;
	}

	public void setParts(List<PlexPart> parts) {
		this.parts = parts;
	}

	@Override
	public Boolean getOptimizedForStreaming() {
		ensureDetailed(optimizedForStreaming);
		return optimizedForStreaming;
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

	public void setOptimizedForStreaming(Boolean optimizedForStreaming) {
		this.optimizedForStreaming = optimizedForStreaming;
	}

	public void setAudioProfile(String audioProfile) {
		this.audioProfile = audioProfile;
	}

	public void setHas64bitOffsets(Boolean has64bitOffsets) {
		this.has64bitOffsets = has64bitOffsets;
	}

	@Override
	public Integer getOrientation() {
		ensureDetailed(orientation);
		return orientation;
	}

	@Override
	public String getKey() {
		ensureDetailed(key);
		return key;
	}

	@Override
	public String getFile() {
		ensureDetailed(getFile());
		return file;
	}

	@Override
	public Long getSize() {
		ensureDetailed(size);
		return size;
	}

	@Override
	public Integer getIso() {
		ensureDetailed(iso);
		return iso;
	}

	public void setIso(Integer iso) {
		this.iso = iso;
	}

	@Override
	public String getAperture() {
		ensureDetailed(aperture);
		return aperture;
	}

	public void setAperture(String aperture) {
		this.aperture = aperture;
	}

	@Override
	public String getExposure() {
		ensureDetailed(exposure);
		return exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	@Override
	public String getMake() {
		ensureDetailed(make);
		return make;
	}

	@Override
	public String getModel() {
		ensureDetailed(model);
		return model;
	}

	@Override
	public String getLens() {
		ensureDetailed(lens);
		return lens;
	}

	public void setLens(String lens) {
		this.lens = lens;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBitrate(Integer bitrate) {
		this.bitrate = bitrate;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setAudioChannels(Integer audioChannels) {
		this.audioChannels = audioChannels;
	}

	public void setAudioCodec(String audioCodec) {
		this.audioCodec = audioCodec;
	}

	public void setVideoCodec(String videoCodec) {
		this.videoCodec = videoCodec;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public void setVideoFrameRate(String videoFrameRate) {
		this.videoFrameRate = videoFrameRate;
	}

	public void setVideoProfile(String videoProfile) {
		this.videoProfile = videoProfile;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public void setAspectRatio(Double aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public void setOrientation(Integer orientation) {
		this.orientation = orientation;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
