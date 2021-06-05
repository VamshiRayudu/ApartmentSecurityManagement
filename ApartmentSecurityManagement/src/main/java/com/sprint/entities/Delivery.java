package com.sprint.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_asm")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deliveryId;
	
	@ManyToOne
	@JoinColumn(name = "flat_deliveries")
	private FlatDetails flatDetails;
	
	private LocalDateTime deliveryDateTime;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Guard> guards;

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public FlatDetails getFlatDetails() {
		return flatDetails;
	}

	public void setFlatDetails(FlatDetails flatDetails) {
		this.flatDetails = flatDetails;
	}

	public LocalDateTime getDeliveryDateTime() {
		return deliveryDateTime;
	}

	public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

	public List<Guard> getGuards() {
		return guards;
	}

	public void setGuards(List<Guard> guards) {
		this.guards = guards;
	}

	public Delivery(FlatDetails flatDetails, LocalDateTime deliveryDateTime, DeliveryStatus status,
			List<Guard> guards) {
		super();
		this.flatDetails = flatDetails;
		this.deliveryDateTime = deliveryDateTime;
		this.status = status;
		this.guards = guards;
	}

	public Delivery(Long deliveryId, FlatDetails flatDetails, LocalDateTime deliveryDateTime, DeliveryStatus status,
			List<Guard> guards) {
		super();
		this.deliveryId = deliveryId;
		this.flatDetails = flatDetails;
		this.deliveryDateTime = deliveryDateTime;
		this.status = status;
		this.guards = guards;
	}

	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Delivery [deliveryId=" + deliveryId + ", flatDetails=" + flatDetails + ", deliveryDateTime="
				+ deliveryDateTime + ", status=" + status + ", guards=" + guards + "]";
	}

}
