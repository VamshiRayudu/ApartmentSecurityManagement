package com.sprint.entities;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class FlatRent {

	private double amount;
	
	@Embedded
	private Rental rentals;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Rental getRentals() {
		return rentals;
	}

	public void setRentals(Rental rentals) {
		this.rentals = rentals;
	}

	public FlatRent(double amount, Rental rentals) {
		super();
		this.amount = amount;
		this.rentals = rentals;
	}

	public FlatRent() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FlatRent [amount=" + amount + ", rentals=" + rentals + "]";
	}

}
