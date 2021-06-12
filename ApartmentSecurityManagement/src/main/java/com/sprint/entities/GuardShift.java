package com.sprint.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class GuardShift{
	
	@NotBlank(message = "Enter Login Time")
	private LocalDateTime inTime;
	
	@NotBlank(message = "Enter Logout Time")
	private LocalDateTime outTime;
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
	public GuardShift(LocalDateTime inTime, LocalDateTime outTime) {
		super();
		this.inTime = inTime;
		this.outTime = outTime;
	}
	public GuardShift() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GuardShift [inTime=" + inTime + ", outTime=" + outTime + "]";
	}	
}
