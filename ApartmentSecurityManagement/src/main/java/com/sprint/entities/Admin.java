package com.sprint.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admin_asm")
public class Admin extends User{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "admin", fetch = FetchType.LAZY)
	private List<SecurityAlert> securityAlerts;
	
	public List<SecurityAlert> getSecurityAlerts() {
		return securityAlerts;
	}

	public void setSecurityAlerts(List<SecurityAlert> securityAlerts) {
		this.securityAlerts = securityAlerts;
	}


	public Admin(String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			List<SecurityAlert> securityAlerts) {
		super(userName, name, mobileNumber, emailId, password, role);
		this.securityAlerts = securityAlerts;
	}
	
	public Admin(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			List<SecurityAlert> securityAlerts) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		this.securityAlerts = securityAlerts;
	}
	
	

	public Admin(List<SecurityAlert> securityAlerts, List<Owner> owners) {
		super();
		this.securityAlerts = securityAlerts;
	}

	public Admin(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}

	public Admin(String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "Admin [securityAlerts=" + securityAlerts + "]";
	}
	
	
}
