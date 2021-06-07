package com.sprint.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owner_asm")
public class Owner extends User{
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.LAZY)
	private List<FlatDetails> flatDetails;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.LAZY)
	private List<Vehicle> vehicleDetails;
	

	public List<FlatDetails> getFlatDetails() {
		return flatDetails;
	}

	public void setFlatDetails(List<FlatDetails> flatDetails) {
		this.flatDetails = flatDetails;
	}

	public List<Vehicle> getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(List<Vehicle> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	
	public Owner(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			List<FlatDetails> flatDetails, List<Vehicle> vehicleDetails) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		this.flatDetails = flatDetails;
		this.vehicleDetails = vehicleDetails;
	}

	public Owner(String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			List<FlatDetails> flatDetails, List<Vehicle> vehicleDetails) {
		super(userName, name, mobileNumber, emailId, password, role);
		this.flatDetails = flatDetails;
		this.vehicleDetails = vehicleDetails;
	}

	
	public Owner(List<FlatDetails> flatDetails, List<Vehicle> vehicleDetails) {
		super();
		this.flatDetails = flatDetails;
		this.vehicleDetails = vehicleDetails;
	}

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}

	public Owner(String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "Owner [flatDetails=" + flatDetails + ", vehicleDetails=" + vehicleDetails + "]";
	}
}
