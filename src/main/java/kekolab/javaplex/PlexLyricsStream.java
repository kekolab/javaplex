package kekolab.javaplex;

public class PlexLyricsStream extends PlexStream {
	public static final int TYPE_ID = 4;
	private String format;
	private String provider;
	private Integer minLines;
	private Boolean timed;

	public String getFormat() {
		getParentTag().fetchDetailedIfNullOrEmpty(format);
		return format;
	}

	public String getProvider() {
		getParentTag().fetchDetailedIfNullOrEmpty(provider);
		return provider;
	}

	public Integer getMinLines() {
		getParentTag().fetchDetailedIfNullOrEmpty(minLines);
		return minLines;
	}

	public Boolean getTimed() {
		getParentTag().fetchDetailedIfNullOrEmpty(timed);
		return timed;
	}

	public void setTimed(Boolean timed) {
		this.timed = timed;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setMinLines(Integer minLines) {
		this.minLines = minLines;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
}
