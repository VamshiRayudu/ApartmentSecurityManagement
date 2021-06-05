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

@Entity
@Table(name = "attendance_asm")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate dateOfAttendance;
	private LocalDateTime inTime;
	private LocalDateTime outTime;
	
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
	public boolean isAttended() {
		return attended;
	}
	public void setAttended(boolean attended) {
		this.attended = attended;
	}
	public Attendance(LocalDate dateOfAttendance, LocalDateTime inTime, LocalDateTime outTime, boolean attended) {
		super();
		this.dateOfAttendance = dateOfAttendance;
		this.inTime = inTime;
		this.outTime = outTime;
		this.attended = attended;
	}
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Attendance [dateOfAttendance=" + dateOfAttendance + ", inTime=" + inTime + ", outTime=" + outTime
				+ ", attended=" + attended + "]";
	}
}
