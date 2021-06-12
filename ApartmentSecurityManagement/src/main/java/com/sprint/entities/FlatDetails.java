package com.sprint.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flatdetails_asm")
public class FlatDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long flatNumber;
	
	@NotNull(message = "Floor Number is Mandatory")
	private Long floorNumber;
	
	@Type(type="true_false")
	private Boolean isRented;

	@ManyToOne
	@JoinColumn(name = "owner_flat")
	private Owner owner;
	
	@Embedded
	private FlatRent flatRent;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "flatDetails", fetch = FetchType.LAZY)
	private List<Visitor> visitors;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "flatDetails",fetch = FetchType.LAZY)
	//@JoinColumn(name = "flat_dhelp")
	private List<DomesticHelp> dHelpList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "flatDetails", fetch = FetchType.LAZY)
	private List<Delivery> deliveries;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "flatDetails", fetch = FetchType.LAZY)
	private List<Vehicle> vehicleList;

	public Long getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(Long flatNumber) {
		this.flatNumber = flatNumber;
	}

	public Long getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Long floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Boolean getIsRented() {
		return isRented;
	}

	public void setIsRented(Boolean isRented) {
		this.isRented = isRented;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public FlatRent getFlatRent() {
		return flatRent;
	}

	public void setFlatRent(FlatRent flatRent) {
		this.flatRent = flatRent;
	}

	public List<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}

	public List<DomesticHelp> getdHelpList() {
		return dHelpList;
	}

	public void setdHelpList(List<DomesticHelp> dHelpList) {
		this.dHelpList = dHelpList;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVechileList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public FlatDetails(Long floorNumber, Boolean isRented, Owner owner, FlatRent flatRent, List<Visitor> visitors,
			List<DomesticHelp> dHelpList, List<Delivery> deliveries, List<Vehicle> vehicleList) {
		super();
		this.floorNumber = floorNumber;
		this.isRented = isRented;
		this.owner = owner;
		this.flatRent = flatRent;
		this.visitors = visitors;
		this.dHelpList = dHelpList;
		this.deliveries = deliveries;
		this.vehicleList = vehicleList;
	}

	public FlatDetails(Long flatNumber, Long floorNumber, Boolean isRented, Owner owner, FlatRent flatRent,
			List<Visitor> visitors, List<DomesticHelp> dHelpList, List<Delivery> deliveries,
			List<Vehicle> vehicleList) {
		super();
		this.flatNumber = flatNumber;
		this.floorNumber = floorNumber;
		this.isRented = isRented;
		this.owner = owner;
		this.flatRent = flatRent;
		this.visitors = visitors;
		this.dHelpList = dHelpList;
		this.deliveries = deliveries;
		this.vehicleList = vehicleList;
	}

	public FlatDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FlatDetails(Long flatNumber, Long floorNumber, Boolean isRented, Owner owner) {
		super();
		this.flatNumber = flatNumber;
		this.floorNumber = floorNumber;
		this.isRented = isRented;
		this.owner = owner;
		
	}
	
	public FlatDetails(Long flatNumber, Long floorNumber) {
		super();
		this.flatNumber = flatNumber;
		this.floorNumber = floorNumber;
	}

	@Override
	public String toString() {
		return "FlatDetails [flatNumber=" + flatNumber + ", floorNumber=" + floorNumber + ", isRented=" + isRented
				+ ", owner=" + owner + ", flatRent=" + flatRent + ", visitors=" + visitors + ", dHelpList=" + dHelpList
				+ ", deliveries=" + deliveries + ", vehicleList=" + vehicleList + "]";
	}

	
	
}
