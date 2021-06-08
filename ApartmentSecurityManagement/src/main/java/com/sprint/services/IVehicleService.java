package com.sprint.services;

import com.sprint.entities.Vehicle;

public interface IVehicleService {

	public Vehicle getVehiclesById(Long id);
	
	public Vehicle addVehicle(Vehicle vehicle);
	
	public Vehicle deleteVehicleById(Long id);
	
}
