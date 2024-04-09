package kekolab.javaplex;

import kekolab.javaplex.model.PlexLocation;

public class Location extends MediatagAttribute implements PlexLocation {
	private String path;
	private Integer id;

	@Override
	public String getPath() {
		ensureDetailed(path);
		return path;
	}

	@Override
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
