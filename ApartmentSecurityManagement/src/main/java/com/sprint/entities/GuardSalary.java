package com.sprint.entities;

import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
public class GuardSalary{
	
	@Enumerated(EnumType.STRING)
	private GuardSalaryStatus salaryStatus;
	private double amount;
	private LocalDate dateofPayment;

	public GuardSalaryStatus getSalaryStatus() {
		return salaryStatus;
	}
	public void setSalaryStatus(GuardSalaryStatus salaryStatus) {
		this.salaryStatus = salaryStatus;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDateofPayment() {
		return dateofPayment;
	}
	public void setDateofPayment(LocalDate dateofPayment) {
		this.dateofPayment = dateofPayment;
	}
	public GuardSalary(GuardSalaryStatus salaryStatus, double amount, LocalDate dateofPayment) {
		super();
		this.salaryStatus = salaryStatus;
		this.amount = amount;
		this.dateofPayment = dateofPayment;
	}

	public GuardSalary() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GuardSalary [salaryStatus=" + salaryStatus + ", amount=" + amount + ", dateofPayment="
				+ dateofPayment + "]";
	}

}
