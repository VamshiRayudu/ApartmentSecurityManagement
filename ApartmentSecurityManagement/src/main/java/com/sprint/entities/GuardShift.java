package com.sprint.entities;

import java.time.LocalTime;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class GuardShift{

	@NotBlank(message = "Enter Login Time")
	private LocalTime inTime;
	@NotBlank(message = "Enter Logout Time")
	private LocalTime outTime;
	public LocalTime getInTime() {
		return inTime;
	}
	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}
	public LocalTime getOutTime() {
		return outTime;
	}
	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
	}
	public GuardShift(LocalTime inTime, LocalTime outTime) {
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
