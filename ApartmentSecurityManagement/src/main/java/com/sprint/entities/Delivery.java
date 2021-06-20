package com.sprint.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
@Entity
@Table(name = "delivery_asm")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deliveryId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "flat_deliveries")
	private FlatDetails flatDetails;

	@NotNull(message = "Delivery Date Required")
	private LocalDateTime deliveryDateTime;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	@JsonIgnore
	@JsonBackReference
	// @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name = "g_deliveries")
	private Guard guard;

	/**
	 * @return
	 */
	public Long getDeliveryId() {
		return deliveryId;
	}

	/**
	 * @param deliveryId
	 */
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	/**
	 * @return
	 */
	public FlatDetails getFlatDetails() {
		return flatDetails;
	}

	/**
	 * @param flatDetails
	 */
	public void setFlatDetails(FlatDetails flatDetails) {
		this.flatDetails = flatDetails;
	}

	/**
	 * @return
	 */
	public LocalDateTime getDeliveryDateTime() {
		return deliveryDateTime;
	}

	/**
	 * @param deliveryDateTime
	 */
	public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}

	/**
	 * @return
	 */
	public DeliveryStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(DeliveryStatus status) {
		this.status = status;
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
	 * @param flatDetails
	 * @param deliveryDateTime
	 * @param status
	 * @param guard
	 */
	public Delivery(FlatDetails flatDetails, LocalDateTime deliveryDateTime, DeliveryStatus status, Guard guard) {
		super();
		this.flatDetails = flatDetails;
		this.deliveryDateTime = deliveryDateTime;
		this.status = status;
		this.guard = guard;
	}

	/**
	 * @param deliveryId
	 * @param flatDetails
	 * @param deliveryDateTime
	 * @param status
	 * @param guard
	 */
	public Delivery(Long deliveryId, FlatDetails flatDetails, LocalDateTime deliveryDateTime, DeliveryStatus status,
			Guard guard) {
		super();
		this.deliveryId = deliveryId;
		this.flatDetails = flatDetails;
		this.deliveryDateTime = deliveryDateTime;
		this.status = status;
		this.guard = guard;
	}

	/**
	 * 
	 */
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param flatDetails
	 * @param deliveryDateTime
	 * @param status
	 */
	public Delivery(FlatDetails flatDetails, LocalDateTime deliveryDateTime, DeliveryStatus status) {
		super();
		this.flatDetails = flatDetails;
		this.deliveryDateTime = deliveryDateTime;
		this.status = status;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Delivery [deliveryId=" + deliveryId + ", flatDetails=" + flatDetails + ", deliveryDateTime="
				+ deliveryDateTime + ", status=" + status + ", guard=" + guard + "]";
	}

}
