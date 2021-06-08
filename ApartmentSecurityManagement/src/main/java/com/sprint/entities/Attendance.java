package com.sprint.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Embeddable
public class Attendance {
	
	private LocalDate dateOfAttendance;
	private LocalDateTime inTime;
	private LocalDateTime outTime;
	
	private Long updatedByGuardId;
	
	@Type(type="true_false")
	private Boolean attended;

	public LocalDate getDateOfAttendance() {
		return dateOfAttendance;
	}

	public void setDateOfAttendance(LocalDate dateOfAttendance) {
		this.dateOfAttendance = dateOfAttendance;
	}

	public LocalDateTime getInTime() {
		return inTime;
	}

	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}

	public LocalDateTime getOutTime() {
		return outTime;
	}

	public void setOutTime(LocalDateTime outTime) {
		this.outTime = outTime;
	}

	public Long getUpdatedByGuardId() {
		return updatedByGuardId;
	}

	public void setUpdatedByGuardId(Long updatedByGuardId) {
		this.updatedByGuardId = updatedByGuardId;
	}

	public Boolean getAttended() {
		return attended;
	}

	public void setAttended(Boolean attended) {
		this.attended = attended;
	}

	public Attendance(LocalDate dateOfAttendance, LocalDateTime inTime, LocalDateTime outTime, Long updatedByGuardId,
			Boolean attended) {
		super();
		this.dateOfAttendance = dateOfAttendance;
		this.inTime = inTime;
		this.outTime = outTime;
		this.updatedByGuardId = updatedByGuardId;
		this.attended = attended;
	}

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Attendance [dateOfAttendance=" + dateOfAttendance + ", inTime=" + inTime + ", outTime="
				+ outTime + ", updatedByGuardId=" + updatedByGuardId + ", attended=" + attended + "]";
	}

	
}
