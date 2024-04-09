package kekolab.javaplex;

import kekolab.javaplex.model.PlexLyricsStream;

public class LyricsStream extends Stream implements PlexLyricsStream {
	private String format;
	private String provider;
	private Integer minLines;
	private Boolean timed;

	@Override
	public String getFormat() {
		ensureDetailed(format);
		return format;
	}

	@Override
	public String getProvider() {
		ensureDetailed(provider);
		return provider;
	}

	@Override
	public Integer getMinLines() {
		ensureDetailed(minLines);
		return minLines;
	}

	@Override
	public Boolean getTimed() {
		ensureDetailed(timed);
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
