package kekolab.javaplex;

import java.util.Objects;

public abstract class MediatagAttribute extends BaseItem {
	private PlexMediatag<?> tag;
	
	protected void initialise(PlexMediatag<?> tag) {
		Objects.requireNonNull(tag);
		this.tag = tag;
	}
	
	protected PlexMediatag<?> getParentTag() {		
		return tag;
	}
}
