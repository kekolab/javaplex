package kekolab.javaplex;

public class PlexRole extends PlexTag {
	private String role;

	public String getRole() {
		getParentTag().fetchDetailedIfNullOrEmpty(role);
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
