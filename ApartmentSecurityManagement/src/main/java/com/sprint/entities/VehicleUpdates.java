package com.sprint.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_upd_asm")
public class VehicleUpdates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDateTime vehicleInTime;
	
	private LocalDateTime vehicleOutTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getVehicleInTime() {
		return vehicleInTime;
	}

	public void setVehicleInTime(LocalDateTime vehicleInTime) {
		this.vehicleInTime = vehicleInTime;
	}

	public LocalDateTime getVehicleOutTime() {
		return vehicleOutTime;
	}

	public void setVehicleOutTime(LocalDateTime vehicleOutTime) {
		this.vehicleOutTime = vehicleOutTime;
	}

	public VehicleUpdates(LocalDateTime vehicleInTime, LocalDateTime vehicleOutTime) {
		super();
		this.vehicleInTime = vehicleInTime;
		this.vehicleOutTime = vehicleOutTime;
	}

	public VehicleUpdates(Long id, LocalDateTime vehicleInTime, LocalDateTime vehicleOutTime) {
		super();
		this.id = id;
		this.vehicleInTime = vehicleInTime;
		this.vehicleOutTime = vehicleOutTime;
	}

	public VehicleUpdates() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VehicleUpdates [id=" + id + ", vehicleInTime=" + vehicleInTime + ", vehicleOutTime="
				+ vehicleOutTime + "]";
	}

}
