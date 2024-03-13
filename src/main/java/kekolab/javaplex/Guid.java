package kekolab.javaplex;

import kekolab.javaplex.model.PlexGuid;

class Guid extends MediatagAttribute implements PlexGuid {
	private String id;

	public String getId() {
		ensureDetailed(id);
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
