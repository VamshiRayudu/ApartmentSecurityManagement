package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint.entities.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long>{

	public Vehicle findByNumberPlate(String vehicleNumber);
	
	
	//@Query() //JOin query
	//public Vehicle findByFlatNumber(Long flatNumber);
	
}
