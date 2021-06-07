package com.sprint.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "securityalerts_asm")
public class SecurityAlert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String message;
	
	private String alert;
	
	private LocalDateTime dateTimeOfAlert;
	
	@ManyToOne
	@JoinColumn(name = "guard_alerts")
	private Guard guard;
	
	@ManyToOne
	@JoinColumn(name = "admin_alerts")
	private Admin admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public Guard getGuard() {
		return guard;
	}

	public void setGuard(Guard guard) {
		this.guard = guard;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public LocalDateTime getDateTimeOfAlert() {
		return dateTimeOfAlert;
	}

	public void setDateTimeOfAlert(LocalDateTime dateTimeOfAlert) {
		this.dateTimeOfAlert = dateTimeOfAlert;
	}

  
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

	public SecurityAlert(String message, String alert, LocalDateTime dateTimeOfAlert, Guard guard, Admin admin) {
		super();
		this.message = message;
		this.alert = alert;
		this.dateTimeOfAlert = dateTimeOfAlert;
		this.guard = guard;
		this.admin = admin;
	}

	public SecurityAlert() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SecurityAlert [id=" + id + ", message=" + message + ", alert=" + alert + ", dateTimeOfAlert="
				+ dateTimeOfAlert + ", guard=" + guard + ", admin=" + admin + "]";
	}

	

}
