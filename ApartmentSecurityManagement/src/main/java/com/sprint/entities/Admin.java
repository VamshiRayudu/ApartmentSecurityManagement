package com.sprint.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
@Entity
@Table(name = "admin_asm")
public class Admin extends User {

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "admin", fetch = FetchType.LAZY)
	private List<SecurityAlert> securityAlerts;

	/**
	 * @return
	 */
	public List<SecurityAlert> getSecurityAlerts() {
		return securityAlerts;
	}

	/**
	 * @param securityAlerts
	 */
	public void setSecurityAlerts(List<SecurityAlert> securityAlerts) {
		this.securityAlerts = securityAlerts;
	}

	/**
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 * @param securityAlerts
	 */
	public Admin(String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			List<SecurityAlert> securityAlerts) {
		super(userName, name, mobileNumber, emailId, password, role);
		this.securityAlerts = securityAlerts;
	}

	/**
	 * @param id
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 * @param securityAlerts
	 */
	public Admin(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			List<SecurityAlert> securityAlerts) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		this.securityAlerts = securityAlerts;
	}

	/**
	 * @param securityAlerts
	 * @param owners
	 */
	public Admin(List<SecurityAlert> securityAlerts, List<Owner> owners) {
		super();
		this.securityAlerts = securityAlerts;
	}

	/**
	 * @param id
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 */
	public Admin(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 */
	public Admin(String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return super.toString() + "Admin [securityAlerts=" + securityAlerts + "]";
	}

}
