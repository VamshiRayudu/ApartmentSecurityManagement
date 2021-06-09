package com.sprint.services;

import java.util.List;

import com.sprint.entities.Vehicle;
import com.sprint.entities.VehicleUpdates;

public interface IVehicleService {
	
	public List<Vehicle> getAllVehicles();

	public Vehicle getVehiclesById(Long id);
	
	public Vehicle addVehicle(Vehicle vehicle);
	
	public Vehicle deleteVehicleById(Long id);
	
	public Vehicle updateVehicleUpdate(Long vehicleId,VehicleUpdates vUpdate);
}
