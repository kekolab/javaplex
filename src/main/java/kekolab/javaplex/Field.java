package kekolab.javaplex;

import kekolab.javaplex.model.PlexField;

public class Field extends MediatagAttribute implements PlexField {
	private String name;
	private Boolean locked;

	@Override
	public String getName() {
		ensureDetailed(name);
		return name;
	}

	@Override
	public Boolean getLocked() {
		ensureDetailed(locked);
		return locked;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
}
