package kekolab.javaplex;

import kekolab.javaplex.model.PlexRole;

class Role extends Tag implements PlexRole {
	private String role;

	public String getRole() {
		ensureDetailed(role);
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
