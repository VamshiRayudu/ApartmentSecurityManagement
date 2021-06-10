package com.sprint.entities;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;


@Embeddable
public class VehicleUpdates {

	@NotBlank(message = "Enter vehicle inTime")
	private LocalDateTime vehicleInTime;
	
	@NotBlank(message = "Enter vehicle outTime")
	private LocalDateTime vehicleOutTime;
	
	@NotBlank(message = "GuardId is Required")
	private Long updatedByGuardId;

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

	public Long getUpdatedByGuardId() {
		return updatedByGuardId;
	}

	public void setUpdatedByGuardId(Long updatedByGuardId) {
		this.updatedByGuardId = updatedByGuardId;
	}

	public VehicleUpdates(LocalDateTime vehicleInTime, LocalDateTime vehicleOutTime, Long updatedByGuardId) {
		super();
		this.vehicleInTime = vehicleInTime;
		this.vehicleOutTime = vehicleOutTime;
		this.updatedByGuardId = updatedByGuardId;
	}

	public VehicleUpdates() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VehicleUpdates [vehicleInTime=" + vehicleInTime + ", vehicleOutTime=" + vehicleOutTime
				+ ", updatedByGuardId=" + updatedByGuardId + "]";
	}
	
}
