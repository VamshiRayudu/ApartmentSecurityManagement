package com.sprint.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author VIVEK PABBA
 *
 */
@Entity
@Table(name = "owner_asm")
public class Owner extends User {

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.LAZY)
	private List<FlatDetails> flatDetails;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.LAZY)
	private List<Vehicle> vehicleDetails;

	/**
	 * @return
	 */
	public List<FlatDetails> getFlatDetails() {
		return flatDetails;
	}

	/**
	 * @param flatDetails
	 */
	public void setFlatDetails(List<FlatDetails> flatDetails) {
		this.flatDetails = flatDetails;
	}

	/**
	 * @return
	 */
	public List<Vehicle> getVehicleDetails() {
		return vehicleDetails;
	}

	/**
	 * @param vehicleDetails
	 */
	public void setVehicleDetails(List<Vehicle> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	/**
	 * @param id
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 * @param flatDetails
	 * @param vehicleDetails
	 */
	public Owner(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			List<FlatDetails> flatDetails, List<Vehicle> vehicleDetails) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		this.flatDetails = flatDetails;
		this.vehicleDetails = vehicleDetails;
	}

	/**
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 * @param flatDetails
	 * @param vehicleDetails
	 */
	public Owner(String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			List<FlatDetails> flatDetails, List<Vehicle> vehicleDetails) {
		super(userName, name, mobileNumber, emailId, password, role);
		this.flatDetails = flatDetails;
		this.vehicleDetails = vehicleDetails;
	}

	/**
	 * @param flatDetails
	 * @param vehicleDetails
	 */
	public Owner(List<FlatDetails> flatDetails, List<Vehicle> vehicleDetails) {
		super();
		this.flatDetails = flatDetails;
		this.vehicleDetails = vehicleDetails;
	}

	/**
	 * 
	 */
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
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
	public Owner(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
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
	public Owner(String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return super.toString() + "Owner [flatDetails=" + flatDetails + ", vehicleDetails=" + vehicleDetails + "]";
	}
}
