package kekolab.javaplex;

import kekolab.javaplex.model.PlexAudioStream;

public class AudioStream extends Stream implements PlexAudioStream {
	private Boolean selected;
	private Integer channels;
	private Integer samplingRate;
	private Integer bitDepth;
	private String audioChannelLayout;
	private String profile;
	private Double albumGain;
	private Double albumPeak;
	private Double albumRange;
	private Double gain;
	private Double loudness;
	private Double lra;
	private Double peak;
	private String bitrateMode;

	@Override
	public String getBitrateMode() {
		return bitrateMode;
	}

	public void setBitrateMode(String bitrateMode) {
		this.bitrateMode = bitrateMode;
	}

	@Override
	public Double getAlbumGain() {
		ensureDetailed(albumGain);
		return albumGain;
	}

	@Override
	public Double getAlbumPeak() {
		ensureDetailed(albumPeak);
		return albumPeak;
	}

	@Override
	public Double getAlbumRange() {
		ensureDetailed(albumRange);
		return albumRange;
	}

	@Override
	public Double getGain() {
		ensureDetailed(gain);
		return gain;
	}

	@Override
	public Double getLoudness() {
		ensureDetailed(loudness);
		return loudness;
	}

	@Override
	public Double getLra() {
		ensureDetailed(lra);
		return lra;
	}

	@Override
	public Double getPeak() {
		ensureDetailed(peak);
		return peak;
	}

	@Override
	public String getProfile() {
		ensureDetailed(profile);
		return profile;
	}

	@Override
	public Boolean getSelected() {
		ensureDetailed(selected);
		return selected;
	}

	@Override
	public Integer getChannels() {
		ensureDetailed(channels);
		return channels;
	}

	@Override
	public Integer getSamplingRate() {
		ensureDetailed(samplingRate);
		return samplingRate;
	}

	@Override
	public String getAudioChannelLayout() {
		ensureDetailed(audioChannelLayout);
		return audioChannelLayout;
	}

	@Override
	public Integer getBitDepth() {
		ensureDetailed(bitDepth);
		return bitDepth;
	}

	public void setAlbumGain(Double albumGain) {
		this.albumGain = albumGain;
	}

	public void setAlbumPeak(Double albumPeak) {
		this.albumPeak = albumPeak;
	}

	public void setAlbumRange(Double albumRange) {
		this.albumRange = albumRange;
	}

	public void setGain(Double gain) {
		this.gain = gain;
	}

	public void setLoudness(Double loudness) {
		this.loudness = loudness;
	}

	public void setLra(Double lra) {
		this.lra = lra;
	}

	public void setPeak(Double peak) {
		this.peak = peak;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public void setChannels(Integer channels) {
		this.channels = channels;
	}

	public void setSamplingRate(Integer samplingRate) {
		this.samplingRate = samplingRate;
	}

	public void setAudioChannelLayout(String audioChannelLayout) {
		this.audioChannelLayout = audioChannelLayout;
	}

	public void setBitDepth(Integer bitDepth) {
		this.bitDepth = bitDepth;
	}
}
