package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Delivery;
@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery, Long> {

	@Query("select a FROM Delivery a WHERE a.flatDetails.id =?1")
	public List<Delivery> getAllDeliveriesByFlatId(Long id);

}
