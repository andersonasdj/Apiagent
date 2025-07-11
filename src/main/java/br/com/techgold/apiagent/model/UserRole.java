package br.com.techgold.apiagent.model;

public enum UserRole {
	
	ADMIN("admin"),
	EDITOR("editor"),
	USER("user");
	
	private String role;
	
	UserRole(String role) {
		this.role=role;
	}

	public String getRole() {
		return role;
	}
}
