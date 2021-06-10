package com.sprint.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user_asm")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "UserName is Mandatory")
	private String userName;
	
	@NotBlank(message = "Name is Mandatory")
	private String name;
	
	@NotNull
	private Long mobileNumber;
	
	@Pattern(regexp = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b")
	private String emailId;
	
	@NotBlank(message = "Password is Mandatory")
	private String password;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User(String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super();
		this.userName = userName;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}

	public User(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}

	public User(String emailId, String password, Role role) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
