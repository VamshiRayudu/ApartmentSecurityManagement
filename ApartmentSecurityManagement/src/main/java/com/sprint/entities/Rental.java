package com.sprint.entities;

import javax.persistence.Embeddable;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
@Embeddable
public class Rental {

	private String name;

	private Long mobileNumber;

	private String emailId;

	private String aadharId;

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return
	 */
	public String getAadharId() {
		return aadharId;
	}

	/**
	 * @param aadharId
	 */
	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	/**
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param aadharId
	 */
	public Rental(String name, Long mobileNumber, String emailId, String aadharId) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.aadharId = aadharId;
	}

	/**
	 * 
	 */
	public Rental() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Rentals [name=" + name + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", aadharId="
				+ aadharId + "]";
	}

}
