package kekolab.javaplex;

import kekolab.javaplex.model.PlexField;

class Field extends MediatagAttribute implements PlexField {
	private String name;
	private Boolean locked;

	public String getName() {
		ensureDetailed(name);
		return name;
	}

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
