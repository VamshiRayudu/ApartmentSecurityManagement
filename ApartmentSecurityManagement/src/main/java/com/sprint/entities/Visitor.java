package com.sprint.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "visitor_asm")
public class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Required Visitor Name")
	private String visitorName;
	
	@NotBlank(message = "Mobile Number Name")
	private String mobileNumber;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "flatdetails_visitors")
	private FlatDetails flatDetails;
	
	private LocalDateTime inTime;
	
	private LocalDateTime outTime;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "guard_visitors")
	private Guard guard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public FlatDetails getFlatDetails() {
		return flatDetails;
	}

	public void setFlatDetails(FlatDetails flatDetails) {
		this.flatDetails = flatDetails;
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

	public Guard getGuard() {
		return guard;
	}

	public void setGuard(Guard guard) {
		this.guard = guard;
	}

	public Visitor(String visitorName, String mobileNumber, FlatDetails flatDetails, LocalDateTime inTime,
			LocalDateTime outTime, Guard guard) {
		super();
		this.visitorName = visitorName;
		this.mobileNumber = mobileNumber;
		this.flatDetails = flatDetails;
		this.inTime = inTime;
		this.outTime = outTime;
		this.guard = guard;
	}

	public Visitor(Long id, String visitorName, String mobileNumber, FlatDetails flatDetails, LocalDateTime inTime,
			LocalDateTime outTime, Guard guard) {
		super();
		this.id = id;
		this.visitorName = visitorName;
		this.mobileNumber = mobileNumber;
		this.flatDetails = flatDetails;
		this.inTime = inTime;
		this.outTime = outTime;
		this.guard = guard;
	}

	public Visitor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", visitorName=" + visitorName + ", mobileNumber=" + mobileNumber
				+ ", flatDetails=" + flatDetails + ", inTime=" + inTime + ", outTime=" + outTime + ", guard=" + guard
				+ "]";
	}
}
