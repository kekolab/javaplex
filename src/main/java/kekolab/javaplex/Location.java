package kekolab.javaplex;

import kekolab.javaplex.model.PlexLocation;

class Location extends MediatagAttribute implements PlexLocation {
	private String path;
	private Integer id;

	public String getPath() {
		ensureDetailed(path);
		return path;
	}

	public Integer getId() {
		ensureDetailed(id);
		return id;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
