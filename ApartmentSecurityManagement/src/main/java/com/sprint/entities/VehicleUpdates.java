package com.sprint.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vechile_upd_asm")
public class VehicleUpdates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLong;
	
	private LocalDateTime vehicleInTime;
	
	private LocalDateTime vehicleOutTime;

	public Long getIdLong() {
		return idLong;
	}

	public void setIdLong(Long idLong) {
		this.idLong = idLong;
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

	public VehicleUpdates(Long idLong, LocalDateTime vehicleInTime, LocalDateTime vehicleOutTime) {
		super();
		this.idLong = idLong;
		this.vehicleInTime = vehicleInTime;
		this.vehicleOutTime = vehicleOutTime;
	}

	public VehicleUpdates() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VehicleUpdates [idLong=" + idLong + ", vehicleInTime=" + vehicleInTime + ", vehicleOutTime="
				+ vehicleOutTime + "]";
	}

}
