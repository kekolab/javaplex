package kekolab.javaplex;

public class PlexField extends MediatagAttribute {
	private String name;
	private Boolean locked;

	public String getName() {
		getParentTag().fetchDetailedIfNullOrEmpty(name);
		return name;
	}

	public Boolean getLocked() {
		getParentTag().fetchDetailedIfNullOrEmpty(locked);
		return locked;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
}
