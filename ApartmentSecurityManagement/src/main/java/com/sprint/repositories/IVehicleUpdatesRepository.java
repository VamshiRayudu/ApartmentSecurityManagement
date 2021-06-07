package com.sprint.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.VehicleUpdates;

import  java.util.List;

public interface IVehicleUpdatesRepository extends JpaRepository<VehicleUpdates, Long>{
	
	public List<VehicleUpdates> findByVehicleInTime(LocalDateTime vehicleInTime);

}
