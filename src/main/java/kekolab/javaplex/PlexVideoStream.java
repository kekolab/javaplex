package kekolab.javaplex;

public class PlexVideoStream extends PlexStream {
	
	public static final int TYPE_ID = 1;
    private Integer bitDepth;
	private Integer codedHeight;
	private Integer codedWidth;
	private Integer height;
	private Integer level;
	private Integer refFrames;
	private Integer width;
	private Integer orientation;
	private Boolean hasScalingMatrix;
	private Boolean anamorphic;
	private String chromaLocation;
	private String chromaSubsampling;
	private String colorPrimaries;
	private String colorRange;
	private String colorSpace;
	private String colorTrc;
	private String profile;
	private String scanType;
	private String pixelAspectRatio;
	private String codecID;

	public String getCodecID() {
		getParentTag().fetchDetailedIfNullOrEmpty(codecID);
		return codecID;
	}

	public void setCodecID(String codecID) {
		this.codecID = codecID;
	}

	private Double frameRate;

	public String getChromaSubsampling() {
		getParentTag().fetchDetailedIfNullOrEmpty(chromaSubsampling);
		return chromaSubsampling;
	}

	public void setChromaSubsampling(String chromaSubsampling) {
		this.chromaSubsampling = chromaSubsampling;
	}

	public Integer getBitDepth() {
		getParentTag().fetchDetailedIfNullOrEmpty(bitDepth);
		return bitDepth;
	}

	public Integer getCodedHeight() {
		getParentTag().fetchDetailedIfNullOrEmpty(codedHeight);
		return codedHeight;
	}

	public Integer getCodedWidth() {
		getParentTag().fetchDetailedIfNullOrEmpty(codedWidth);
		return codedWidth;
	}

	public Boolean getAnamorphic() {
		getParentTag().fetchDetailedIfNullOrEmpty(anamorphic);
		return anamorphic;
	}

	public void setAnamorphic(Boolean anamorphic) {
		this.anamorphic = anamorphic;
	}

	public String getPixelAspectRatio() {
		getParentTag().fetchDetailedIfNullOrEmpty(pixelAspectRatio);
		return pixelAspectRatio;
	}

	public void setPixelAspectRatio(String pixelAspectRatio) {
		this.pixelAspectRatio = pixelAspectRatio;
	}

	public Integer getHeight() {
		getParentTag().fetchDetailedIfNullOrEmpty(height);
		return height;
	}

	public Integer getLevel() {
		getParentTag().fetchDetailedIfNullOrEmpty(level);
		return level;
	}

	public Integer getRefFrames() {
		getParentTag().fetchDetailedIfNullOrEmpty(refFrames);
		return refFrames;
	}

	public Integer getWidth() {
		getParentTag().fetchDetailedIfNullOrEmpty(width);
		return width;
	}

	public Boolean getHasScalingMatrix() {
		getParentTag().fetchDetailedIfNullOrEmpty(hasScalingMatrix);
		return hasScalingMatrix;
	}

	public String getChromaLocation() {
		getParentTag().fetchDetailedIfNullOrEmpty(chromaLocation);
		return chromaLocation;
	}

	public String getColorPrimaries() {
		getParentTag().fetchDetailedIfNullOrEmpty(colorPrimaries);
		return colorPrimaries;
	}

	public String getColorRange() {
		getParentTag().fetchDetailedIfNullOrEmpty(colorRange);
		return colorRange;
	}

	public Double getFrameRate() {
		getParentTag().fetchDetailedIfNullOrEmpty(frameRate);
		return frameRate;
	}

	public void setBitDepth(Integer bitDepth) {
		this.bitDepth = bitDepth;
	}

	public void setCodedHeight(Integer codedHeight) {
		this.codedHeight = codedHeight;
	}

	public void setCodedWidth(Integer codedWidth) {
		this.codedWidth = codedWidth;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setRefFrames(Integer refFrames) {
		this.refFrames = refFrames;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setHasScalingMatrix(Boolean hasScalingMatrix) {
		this.hasScalingMatrix = hasScalingMatrix;
	}

	public void setChromaLocation(String chromaLocation) {
		this.chromaLocation = chromaLocation;
	}

	public void setColorPrimaries(String colorPrimaries) {
		this.colorPrimaries = colorPrimaries;
	}

	public void setColorRange(String colorRange) {
		this.colorRange = colorRange;
	}

	public void setFrameRate(Double frameRate) {
		this.frameRate = frameRate;
	}

	public String getColorSpace() {
		getParentTag().fetchDetailedIfNullOrEmpty(colorSpace);
		return colorSpace;
	}

	public String getColorTrc() {
		getParentTag().fetchDetailedIfNullOrEmpty(colorTrc);
		return colorTrc;
	}

	public String getProfile() {
		getParentTag().fetchDetailedIfNullOrEmpty(profile);
		return profile;
	}

	public String getScanType() {
		getParentTag().fetchDetailedIfNullOrEmpty(scanType);
		return scanType;
	}

	public void setColorSpace(String colorSpace) {
		this.colorSpace = colorSpace;
	}

	public void setColorTrc(String colorTrc) {
		this.colorTrc = colorTrc;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	public Integer getOrientation() {
		getParentTag().fetchDetailedIfNullOrEmpty(orientation);
		return orientation;
	}

	public void setOrientation(Integer orientation) {
		this.orientation = orientation;
	}

}
