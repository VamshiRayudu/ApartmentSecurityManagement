package com.sprint.entities;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author KUNDANA PRIYA
 *
 */
@Embeddable
public class FlatRent {

	private double amount;

	@Embedded
	private Rental rentals;

	/**
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return
	 */
	public Rental getRentals() {
		return rentals;
	}

	/**
	 * @param rentals
	 */
	public void setRentals(Rental rentals) {
		this.rentals = rentals;
	}

	/**
	 * @param amount
	 * @param rentals
	 */
	public FlatRent(double amount, Rental rentals) {
		super();
		this.amount = amount;
		this.rentals = rentals;
	}

	/**
	 * 
	 */
	public FlatRent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "FlatRent [amount=" + amount + ", rentals=" + rentals + "]";
	}

}
