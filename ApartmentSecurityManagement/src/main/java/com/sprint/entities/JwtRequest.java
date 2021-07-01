package com.sprint.entities;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String email;
	private String password;
	private Role role;

	// need default constructor for JSON Parsing
	public JwtRequest() {

	}

	public JwtRequest(String email, String password, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getEmail() {
		return this.email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setEmail(String username) {
		this.email = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}