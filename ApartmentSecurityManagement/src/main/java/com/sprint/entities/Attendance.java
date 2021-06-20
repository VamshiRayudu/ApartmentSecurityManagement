package com.sprint.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
@Embeddable
public class Attendance {

	@NotNull(message = "Date of Attendance is Mandatory")
	private LocalDate dateOfAttendance;

	@NotBlank(message = "Enter Login Time")
	private LocalDateTime inTime;

	@NotBlank(message = "Enter Logiout Time")
	private LocalDateTime outTime;

	private Long updatedByGuardId;

	@Type(type = "true_false")
	private Boolean attended;

	/**
	 * @return
	 */
	public LocalDate getDateOfAttendance() {
		return dateOfAttendance;
	}

	/**
	 * @param dateOfAttendance
	 */
	public void setDateOfAttendance(LocalDate dateOfAttendance) {
		this.dateOfAttendance = dateOfAttendance;
	}

	/**
	 * @return
	 */
	public LocalDateTime getInTime() {
		return inTime;
	}

	/**
	 * @param inTime
	 */
	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}

	/**
	 * @return
	 */
	public LocalDateTime getOutTime() {
		return outTime;
	}

	/**
	 * @param outTime
	 */
	public void setOutTime(LocalDateTime outTime) {
		this.outTime = outTime;
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
	 * @return
	 */
	public Boolean getAttended() {
		return attended;
	}

	/**
	 * @param attended
	 */
	public void setAttended(Boolean attended) {
		this.attended = attended;
	}

	/**
	 * @param dateOfAttendance
	 * @param inTime
	 * @param outTime
	 * @param updatedByGuardId
	 * @param attended
	 */
	public Attendance(LocalDate dateOfAttendance, LocalDateTime inTime, LocalDateTime outTime, Long updatedByGuardId,
			Boolean attended) {
		super();
		this.dateOfAttendance = dateOfAttendance;
		this.inTime = inTime;
		this.outTime = outTime;
		this.updatedByGuardId = updatedByGuardId;
		this.attended = attended;
	}

	/**
	 * 
	 */
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Attendance [dateOfAttendance=" + dateOfAttendance + ", inTime=" + inTime + ", outTime=" + outTime
				+ ", updatedByGuardId=" + updatedByGuardId + ", attended=" + attended + "]";
	}

}
