package com.sprint.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "guard_asm")
public class Guard extends User{
	
	@Type(type="true_false")
	private Boolean isTrained;
	
	@Embedded
	private GuardShift guardShifts;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="guard_salaries",joinColumns = @JoinColumn(name = "guard_id"))
	@Column(name = "salary")
	private List<GuardSalary> guardSalaries = new ArrayList<GuardSalary>();
	
	
	
	@OneToMany(mappedBy = "guard",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<SecurityAlert> securityAlerts;
	
	
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="guard_attnd",joinColumns = @JoinColumn(name = "guard_id"))
	@Column(name = "guard_att")
	private List<Attendance> guardAttendances = new ArrayList<Attendance>();
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Visitor> visitors;

	
	
	//@ManyToMany(cascade = CascadeType.ALL)
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="guard_vehicleupd",joinColumns = @JoinColumn(name = "guard_id"))
	@Column(name = "vehiclesUpdates")
	private List<VehicleUpdates> vehicleUpdates = new ArrayList<VehicleUpdates>();
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Delivery> deliveries;
	

	public Boolean getIsTrained() {
		return isTrained;
	}



	public void setIsTrained(Boolean isTrained) {
		this.isTrained = isTrained;
	}



	public GuardShift getGuardShifts() {
		return guardShifts;
	}



	public void setGuardShifts(GuardShift guardShifts) {
		this.guardShifts = guardShifts;
	}



	public List<GuardSalary> getGuardSalaries() {
		return guardSalaries;
	}



	public void setGuardSalaries(List<GuardSalary> guardSalaries) {
		this.guardSalaries = guardSalaries;
	}



	public List<SecurityAlert> getSecurityAlerts() {
		return securityAlerts;
	}



	public void setSecurityAlerts(List<SecurityAlert> securityAlerts) {
		this.securityAlerts = securityAlerts;
	}



	public List<Attendance> getGuardAttendances() {
		return guardAttendances;
	}



	public void setGuardAttendances(List<Attendance> guardAttendances) {
		this.guardAttendances = guardAttendances;
	}



	public List<Visitor> getVisitors() {
		return visitors;
	}



	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}



	public List<VehicleUpdates> getVehicleUpdates() {
		return vehicleUpdates;
	}



	public void setVehicleUpdates(List<VehicleUpdates> vehicleUpdates) {
		this.vehicleUpdates = vehicleUpdates;
	}



	public List<Delivery> getDeliveries() {
		return deliveries;
	}



	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}



	public Guard(String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			Boolean isTrained, GuardShift guardShifts, List<GuardSalary> guardSalaries,
			List<SecurityAlert> securityAlerts, List<Attendance> guardAttendances, List<Visitor> visitors,
			List<VehicleUpdates> vehicleUpdates, List<Delivery> deliveries) {
		super(userName, name, mobileNumber, emailId, password, role);
		this.isTrained = isTrained;
		this.guardShifts = guardShifts;
		this.guardSalaries = guardSalaries;
		this.securityAlerts = securityAlerts;
		this.guardAttendances = guardAttendances;
		this.visitors = visitors;
		this.vehicleUpdates = vehicleUpdates;
		this.deliveries = deliveries;
	}



	public Guard(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role,
			Boolean isTrained, GuardShift guardShifts, List<GuardSalary> guardSalaries,
			List<SecurityAlert> securityAlerts, List<Attendance> guardAttendances, List<Visitor> visitors,
			List<VehicleUpdates> vehicleUpdates, List<Delivery> deliveries) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		this.isTrained = isTrained;
		this.guardShifts = guardShifts;
		this.guardSalaries = guardSalaries;
		this.securityAlerts = securityAlerts;
		this.guardAttendances = guardAttendances;
		this.visitors = visitors;
		this.vehicleUpdates = vehicleUpdates;
		this.deliveries = deliveries;
	}



	public Guard(Boolean isTrained, GuardShift guardShifts, List<GuardSalary> guardSalaries,
			List<SecurityAlert> securityAlerts, List<Attendance> guardAttendances, List<Visitor> visitors,
			List<VehicleUpdates> vehicleUpdates, List<Delivery> deliveries) {
		super();
		this.isTrained = isTrained;
		this.guardShifts = guardShifts;
		this.guardSalaries = guardSalaries;
		this.securityAlerts = securityAlerts;
		this.guardAttendances = guardAttendances;
		this.visitors = visitors;
		this.vehicleUpdates = vehicleUpdates;
		this.deliveries = deliveries;
	}



	public Guard() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Guard(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}



	public Guard(String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return super.toString() + "Guard [isTrained=" + isTrained + ", guardShifts=" + guardShifts + ", guardSalaries=" + guardSalaries
				+ ", securityAlerts=" + securityAlerts + ", guardAttendances=" + guardAttendances + ", visitors="
				+ visitors + ", vehicleUpdates=" + vehicleUpdates + ", deliveries=" + deliveries + "]";
	}

	//to create a method ,register domestic help through guard service
//	@OneToMany
//	private List<DomesticHelp> domesticHelp;
	
}
