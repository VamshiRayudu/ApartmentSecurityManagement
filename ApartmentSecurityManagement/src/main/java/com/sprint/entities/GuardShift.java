package com.sprint.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
@Embeddable
public class GuardShift {

	@NotBlank(message = "Enter Login Time")
	private LocalDateTime inTime;

	@NotBlank(message = "Enter Logout Time")
	private LocalDateTime outTime;

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
	 * @param inTime
	 * @param outTime
	 */
	public GuardShift(LocalDateTime inTime, LocalDateTime outTime) {
		super();
		this.inTime = inTime;
		this.outTime = outTime;
	}

	/**
	 * 
	 */
	public GuardShift() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "GuardShift [inTime=" + inTime + ", outTime=" + outTime + "]";
	}
}
