package com.sprint.entities;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

/**
 * @author VISHNU KUMAR
 *
 */
@Embeddable
public class VehicleUpdates {

	@NotBlank(message = "Enter vehicle inTime")
	private LocalDateTime vehicleInTime;

	@NotBlank(message = "Enter vehicle outTime")
	private LocalDateTime vehicleOutTime;

	@NotBlank(message = "GuardId is Required")
	private Long updatedByGuardId;

	/**
	 * @return
	 */
	public LocalDateTime getVehicleInTime() {
		return vehicleInTime;
	}

	/**
	 * @param vehicleInTime
	 */
	public void setVehicleInTime(LocalDateTime vehicleInTime) {
		this.vehicleInTime = vehicleInTime;
	}

	/**
	 * @return
	 */
	public LocalDateTime getVehicleOutTime() {
		return vehicleOutTime;
	}

	/**
	 * @param vehicleOutTime
	 */
	public void setVehicleOutTime(LocalDateTime vehicleOutTime) {
		this.vehicleOutTime = vehicleOutTime;
	}

	/**
	 * @return
	 */
	public Long getUpdatedByGuardId() {
		return updatedByGuardId;
	}

	/**
	 * @param updatedByGuardId
	 */
	public void setUpdatedByGuardId(Long updatedByGuardId) {
		this.updatedByGuardId = updatedByGuardId;
	}

	/**
	 * @param vehicleInTime
	 * @param vehicleOutTime
	 * @param updatedByGuardId
	 */
	public VehicleUpdates(LocalDateTime vehicleInTime, LocalDateTime vehicleOutTime, Long updatedByGuardId) {
		super();
		this.vehicleInTime = vehicleInTime;
		this.vehicleOutTime = vehicleOutTime;
		this.updatedByGuardId = updatedByGuardId;
	}

	/**
	 * 
	 */
	public VehicleUpdates() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "VehicleUpdates [vehicleInTime=" + vehicleInTime + ", vehicleOutTime=" + vehicleOutTime
				+ ", updatedByGuardId=" + updatedByGuardId + "]";
	}

}
