package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint.entities.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long>{

	public Vehicle findByNumberPlate(String vehicleNumber);
	
	@Query("select a FROM Vehicle a WHERE a.flatDetails.id =?1")
	public List<Vehicle> getAllVehcilesByFlatId(Long id);
	
	
	@Query("select a FROM Vehicle a WHERE a.owner.id =?1")
	public List<Vehicle> getAllVehcilesByOwnerId(Long id);
	
}
