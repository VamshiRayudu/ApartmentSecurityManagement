package com.sprint.services;

import java.util.List;

import com.sprint.entities.Delivery;

public interface IDeliveryService {

	public Delivery getDeliveryById(Long deliveryId);
	
	public List<Delivery> getAllDeliveries(Long flatNumber);
}
