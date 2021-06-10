package com.sprint.services;

import java.util.List;

import com.sprint.entities.Vehicle;
import com.sprint.entities.VehicleUpdates;
import com.sprint.exceptions.RecordNotFoundException;

public interface IVehicleService {
	
	public List<Vehicle> getAllVehicles();

	public Vehicle getVehiclesById(Long id) throws RecordNotFoundException;
	
	public Vehicle addVehicle(Vehicle vehicle);
	
	public Vehicle deleteVehicleById(Long id) throws RecordNotFoundException;
	
	public Vehicle updateVehicleUpdate(Long vehicleId,VehicleUpdates vUpdate) throws RecordNotFoundException;
}
