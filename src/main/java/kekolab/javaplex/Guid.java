package kekolab.javaplex;

import kekolab.javaplex.model.PlexGuid;

public class Guid extends MediatagAttribute implements PlexGuid  {
	private String id;

	@Override
	public String getId() {
		ensureDetailed(id);
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
