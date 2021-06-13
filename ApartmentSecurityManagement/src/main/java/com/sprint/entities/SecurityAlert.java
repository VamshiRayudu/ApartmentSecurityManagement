package com.sprint.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author VIVEK PABBA
 *
 */
@Entity
@Table(name = "securityalerts_asm")
public class SecurityAlert {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Alert Message is Required")
	private String message;

	@NotBlank(message = "Alert is Required")
	private String alert;

	@NotNull
	private LocalDateTime dateTimeOfAlert;

	@ManyToOne
	@JoinColumn(name = "guard_alerts")
	private Guard guard;

	@ManyToOne
	@JoinColumn(name = "admin_alerts")
	private Admin admin;

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return
	 */
	public String getAlert() {
		return alert;
	}

	/**
	 * @param alert
	 */
	public void setAlert(String alert) {
		this.alert = alert;
	}

	/**
	 * @return
	 */
	public Guard getGuard() {
		return guard;
	}

	/**
	 * @param guard
	 */
	public void setGuard(Guard guard) {
		this.guard = guard;
	}

	/**
	 * @return
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * @return
	 */
	public LocalDateTime getDateTimeOfAlert() {
		return dateTimeOfAlert;
	}

	/**
	 * @param dateTimeOfAlert
	 */
	public void setDateTimeOfAlert(LocalDateTime dateTimeOfAlert) {
		this.dateTimeOfAlert = dateTimeOfAlert;
	}

	/**
	 * @param id
	 * @param message
	 * @param alert
	 * @param dateTimeOfAlert
	 * @param guard
	 * @param admin
	 */
	public SecurityAlert(Long id, String message, String alert, LocalDateTime dateTimeOfAlert, Guard guard,
			Admin admin) {
		super();
		this.id = id;
		this.message = message;
		this.alert = alert;
		this.dateTimeOfAlert = dateTimeOfAlert;
		this.guard = guard;
		this.admin = admin;
	}

	/**
	 * @param message
	 * @param alert
	 * @param dateTimeOfAlert
	 * @param guard
	 * @param admin
	 */
	public SecurityAlert(String message, String alert, LocalDateTime dateTimeOfAlert, Guard guard, Admin admin) {
		super();
		this.message = message;
		this.alert = alert;
		this.dateTimeOfAlert = dateTimeOfAlert;
		this.guard = guard;
		this.admin = admin;
	}

	/**
	 * 
	 */
	public SecurityAlert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "SecurityAlert [id=" + id + ", message=" + message + ", alert=" + alert + ", dateTimeOfAlert="
				+ dateTimeOfAlert + ", guard=" + guard + ", admin=" + admin + "]";
	}

}
