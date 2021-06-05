package com.sprint.entities;

import javax.persistence.Embeddable;
@Embeddable
public class Rental {
	
	private String name;
	
	private Long mobileNumber;
	
	private String emailId;
	
	private String aadharId;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public Rental(String name, Long mobileNumber, String emailId, String aadharId) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.aadharId = aadharId;
	}

	public Rental() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Rentals [name=" + name + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", aadharId=" + aadharId + "]";
	}
	
	

}
