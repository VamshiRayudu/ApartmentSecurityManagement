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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author VISHNU KUMAR
 *
 */
@Entity
@Table(name = "vehicle_asm")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Vehicle NumberPlate is Mandatory")
	private String numberPlate;

	private String vehicleColour;

	// @JsonIgnore
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "vehicle_updates", joinColumns = @JoinColumn(name = "vehicle_id"))
	private List<VehicleUpdates> vehicleUpdates = new ArrayList<VehicleUpdates>();

	@ManyToOne
	@JoinColumn(name = "owner_vehicle")
	private Owner owner;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "flat_vehicle")
	private FlatDetails flatDetails;

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getNumberPlate() {
		return numberPlate;
	}

	/**
	 * @param numberPlate
	 */
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	/**
	 * @return
	 */
	public String getVehicleColour() {
		return vehicleColour;
	}

	/**
	 * @param vehicleColour
	 */
	public void setVehicleColour(String vehicleColour) {
		this.vehicleColour = vehicleColour;
	}

	/**
	 * @return
	 */
	public List<VehicleUpdates> getVehicleUpdates() {
		return vehicleUpdates;
	}

	/**
	 * @param vehicleUpdates
	 */
	public void setVehicleUpdates(List<VehicleUpdates> vehicleUpdates) {
		this.vehicleUpdates = vehicleUpdates;
	}

	/**
	 * @return
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * @return
	 */
	public FlatDetails getFlatDetails() {
		return flatDetails;
	}

	/**
	 * @param flatDetails
	 */
	public void setFlatdetails(FlatDetails flatDetails) {
		this.flatDetails = flatDetails;
	}

	/**
	 * @param numberPlate
	 * @param vehicleColour
	 * @param vehicleUpdates
	 * @param owner
	 * @param flatDetails
	 */
	public Vehicle(String numberPlate, String vehicleColour, List<VehicleUpdates> vehicleUpdates, Owner owner,
			FlatDetails flatDetails) {
		super();
		this.numberPlate = numberPlate;
		this.vehicleColour = vehicleColour;
		this.vehicleUpdates = vehicleUpdates;
		this.owner = owner;
		this.flatDetails = flatDetails;
	}

	/**
	 * @param id
	 * @param numberPlate
	 * @param vehicleColour
	 * @param vehicleUpdates
	 * @param owner
	 * @param flatDetails
	 */
	public Vehicle(Long id, String numberPlate, String vehicleColour, List<VehicleUpdates> vehicleUpdates, Owner owner,
			FlatDetails flatDetails) {
		super();
		this.id = id;
		this.numberPlate = numberPlate;
		this.vehicleColour = vehicleColour;
		this.vehicleUpdates = vehicleUpdates;
		this.owner = owner;
		this.flatDetails = flatDetails;
	}

	/**
	 * 
	 */
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", numberPlate=" + numberPlate + ", vehicleColour=" + vehicleColour
				+ ", vehicleUpdates=" + vehicleUpdates + ", owner=" + owner + ", flatDetails=" + flatDetails + "]";
	}
}
