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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author SHUBHAM
 *
 */
@Entity
@Table(name = "guard_asm")
public class Guard extends User {

	@Type(type = "true_false")
	private Boolean isTrained;

	@Embedded
	private GuardShift guardShifts;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "guard_salaries", joinColumns = @JoinColumn(name = "guard_id"))
	@Column(name = "salary")
	private List<GuardSalary> guardSalaries = new ArrayList<GuardSalary>();

	@JsonIgnore
	@OneToMany(mappedBy = "guard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SecurityAlert> securityAlerts;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "guard_attnd", joinColumns = @JoinColumn(name = "guard_id"))
	@Column(name = "guard_att")
	private List<Attendance> guardAttendances = new ArrayList<Attendance>();

	@JsonIgnore
	@OneToMany(mappedBy = "guard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Visitor> visitors;

	@JsonIgnore
	// @ManyToMany(cascade = CascadeType.ALL)
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "guard_vehicleupd", joinColumns = @JoinColumn(name = "guard_id"))
	@Column(name = "vehiclesUpdates")
	private List<VehicleUpdates> vehicleUpdates = new ArrayList<VehicleUpdates>();

	@JsonIgnore
	@OneToMany(mappedBy = "guard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Delivery> deliveries;

	/**
	 * @return
	 */
	public Boolean getIsTrained() {
		return isTrained;
	}

	/**
	 * @param isTrained
	 */
	public void setIsTrained(Boolean isTrained) {
		this.isTrained = isTrained;
	}

	/**
	 * @return
	 */
	public GuardShift getGuardShifts() {
		return guardShifts;
	}

	/**
	 * @param guardShifts
	 */
	public void setGuardShifts(GuardShift guardShifts) {
		this.guardShifts = guardShifts;
	}

	/**
	 * @return
	 */
	public List<GuardSalary> getGuardSalaries() {
		return guardSalaries;
	}

	/**
	 * @param guardSalaries
	 */
	public void setGuardSalaries(List<GuardSalary> guardSalaries) {
		this.guardSalaries = guardSalaries;
	}

	/**
	 * @return
	 */
	public List<SecurityAlert> getSecurityAlerts() {
		return securityAlerts;
	}

	/**
	 * @param securityAlerts
	 */
	public void setSecurityAlerts(List<SecurityAlert> securityAlerts) {
		this.securityAlerts = securityAlerts;
	}

	/**
	 * @return
	 */
	public List<Attendance> getGuardAttendances() {
		return guardAttendances;
	}

	/**
	 * @param guardAttendances
	 */
	public void setGuardAttendances(List<Attendance> guardAttendances) {
		this.guardAttendances = guardAttendances;
	}

	/**
	 * @return
	 */
	public List<Visitor> getVisitors() {
		return visitors;
	}

	/**
	 * @param visitors
	 */
	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}

	/**
	 * @return
	 */
	public List<VehicleUpdates> getVehicleUpdates() {
		return vehicleUpdates;
	}

	/**
	 * @param vehicleUpdates
	 */
	public void setVehicleUpdates(List<VehicleUpdates> vehicleUpdates) {
		this.vehicleUpdates = vehicleUpdates;
	}

	/**
	 * @return
	 */
	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	/**
	 * @param deliveries
	 */
	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	/**
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 * @param isTrained
	 * @param guardShifts
	 * @param guardSalaries
	 * @param securityAlerts
	 * @param guardAttendances
	 * @param visitors
	 * @param vehicleUpdates
	 * @param deliveries
	 */
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

	/**
	 * @param id
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 * @param isTrained
	 * @param guardShifts
	 * @param guardSalaries
	 * @param securityAlerts
	 * @param guardAttendances
	 * @param visitors
	 * @param vehicleUpdates
	 * @param deliveries
	 */
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

	/**
	 * @param isTrained
	 * @param guardShifts
	 * @param guardSalaries
	 * @param securityAlerts
	 * @param guardAttendances
	 * @param visitors
	 * @param vehicleUpdates
	 * @param deliveries
	 */
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

	/**
	 * 
	 */
	public Guard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 */
	public Guard(Long id, String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(id, userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 * @param name
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @param role
	 */
	public Guard(String userName, String name, Long mobileNumber, String emailId, String password, Role role) {
		super(userName, name, mobileNumber, emailId, password, role);
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return super.toString() + "Guard [isTrained=" + isTrained + ", guardShifts=" + guardShifts + ", guardSalaries="
				+ guardSalaries + ", securityAlerts=" + securityAlerts + ", guardAttendances=" + guardAttendances
				+ ", visitors=" + visitors + ", vehicleUpdates=" + vehicleUpdates + ", deliveries=" + deliveries + "]";
	}

	// to create a method ,register domestic help through guard service
//	@OneToMany
//	private List<DomesticHelp> domesticHelp;

}
