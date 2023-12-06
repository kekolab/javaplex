package kekolab.javaplex;

public class PlexGuid extends MediatagAttribute {
	private String id;

	public String getId() {
		getParentTag().fetchDetailedIfNullOrEmpty(id);
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
