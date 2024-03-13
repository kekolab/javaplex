package kekolab.javaplex.model;

public interface PlexAudioStream extends PlexStream {
	int TYPE_ID = 2;
	
	String getBitrateMode();

	Double getAlbumGain();

	Double getAlbumPeak();

	Double getAlbumRange();

	Double getGain();

	Double getLoudness();

	Double getLra();

	Double getPeak();

	String getProfile();

	Boolean getSelected();

	Integer getChannels();

	Integer getSamplingRate();

	String getAudioChannelLayout();

	Integer getBitDepth();
}
