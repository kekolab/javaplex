package kekolab.javaplex.model;

public interface PlexVideoStream extends PlexStream {
	int TYPE_ID = 1;

	String getCodecID();

	String getChromaSubsampling();

	Integer getBitDepth();

	Integer getCodedHeight();

	Integer getCodedWidth();

	Boolean getAnamorphic();

	String getPixelAspectRatio();

	Integer getHeight();

	Integer getLevel();

	Integer getRefFrames();

	Integer getWidth();

	Boolean getHasScalingMatrix();

	String getChromaLocation();

	String getColorPrimaries();

	String getColorRange();

	Double getFrameRate();

	String getColorSpace();

	String getColorTrc();

	String getProfile();

	String getScanType();

	Integer getOrientation();

}
