package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.Delivery;

public interface IDeliveryRepository extends JpaRepository<Delivery, Long>{

}
