package com.sprint.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_asm")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String numberPlate;
	
	private String vehicleColour;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="vehicle_updates",joinColumns = @JoinColumn(name = "vehicle_id"))
	private List<VehicleUpdates> vehicleUpdates = new ArrayList<VehicleUpdates>();
	
	@ManyToOne
	@JoinColumn(name = "owner_vehicle")
	private Owner owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getVehicleColour() {
		return vehicleColour;
	}

	public void setVehicleColour(String vehicleColour) {
		this.vehicleColour = vehicleColour;
	}

	public List<VehicleUpdates> getVehicleUpdates() {
		return vehicleUpdates;
	}

	public void setVehicleUpdates(List<VehicleUpdates> vehicleUpdates) {
		this.vehicleUpdates = vehicleUpdates;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Vehicle(String numberPlate, String vehicleColour, List<VehicleUpdates> vehicleUpdates, Owner owner) {
		super();
		this.numberPlate = numberPlate;
		this.vehicleColour = vehicleColour;
		this.vehicleUpdates = vehicleUpdates;
		this.owner = owner;
	}

	public Vehicle(Long id, String numberPlate, String vehicleColour, List<VehicleUpdates> vehicleUpdates,
			Owner owner) {
		super();
		this.id = id;
		this.numberPlate = numberPlate;
		this.vehicleColour = vehicleColour;
		this.vehicleUpdates = vehicleUpdates;
		this.owner = owner;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", numberPlate=" + numberPlate + ", vehicleColour=" + vehicleColour
				+ ", vehicleUpdates=" + vehicleUpdates + ", owner=" + owner + "]";
	}

}
