package com.sprint.services;

import java.util.List;

import com.sprint.entities.Vehicle;

public interface IVehicleService {
	
	public List<Vehicle> getAllVehicles();

	public Vehicle getVehiclesById(Long id);
	
	public Vehicle addVehicle(Vehicle vehicle);
	
	public Vehicle deleteVehicleById(Long id);
	
	
}
