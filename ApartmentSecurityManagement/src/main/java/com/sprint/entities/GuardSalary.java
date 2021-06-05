package com.sprint.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guard_sal_asm")
public class GuardSalary{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private GuardSalaryStatus salaryStatus;
	private double amount;
	private LocalDate dateofPayment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public GuardSalary(Long id, GuardSalaryStatus salaryStatus, double amount, LocalDate dateofPayment) {
		super();
		this.id = id;
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
		return "GuardSalary [id=" + id + ", salaryStatus=" + salaryStatus + ", amount=" + amount + ", dateofPayment="
				+ dateofPayment + "]";
	}

}
