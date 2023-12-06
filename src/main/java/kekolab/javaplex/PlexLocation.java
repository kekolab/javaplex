package kekolab.javaplex;

public class PlexLocation extends MediatagAttribute {
	private String path;
	private Integer id;

	public String getPath() {
		getParentTag().fetchDetailedIfNullOrEmpty(path);
		return path;
	}

	public Integer getId() {
		getParentTag().fetchDetailedIfNullOrEmpty(id);
		return id;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
