package kekolab.javaplex;

import java.util.Objects;

abstract class MediatagAttribute extends BaseItem {
	private Mediatag<?> tag;
	
	void initialise(Mediatag<?> tag) {
		Objects.requireNonNull(tag);
		this.tag = tag;
	}
	
	Mediatag<?> getParentTag() {		
		return tag;
	}

	void ensureDetailed(Object field) {
		getParentTag().ensureDetailed(field);
	}
}
