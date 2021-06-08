package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.Delivery;

public interface IDeliveryRepository extends JpaRepository<Delivery, Long>{

	
	//Use Join Query
	//public List<Delivery> getDeliveriesByFlatNumber(Long FlatNumber);
	
}
