package kekolab.javaplex;

import kekolab.javaplex.model.PlexRole;

public class Role extends Tag implements PlexRole {
	private String role;

	@Override
	public String getRole() {
		ensureDetailed(role);
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
