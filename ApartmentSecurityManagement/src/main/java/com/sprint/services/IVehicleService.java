package com.sprint.services;

import java.util.List;


import com.sprint.entities.Vehicle;

public interface IVehicleService {

	public Vehicle getVehiclesById(Long id);
	
	public List<Vehicle> listVehiclesByFlatNumber(Long flatNumber);
	
	public Vehicle addVehicle(Vehicle vehicle);
	
	public Vehicle deleteVehicleById(Long id);
}
