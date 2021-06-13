package com.sprint.services;

import java.util.List;

import com.sprint.entities.Vehicle;
import com.sprint.entities.VehicleUpdates;
import com.sprint.exceptions.RecordNotFoundException;

/**
 * @author VISHNU KUMAR
 *
 */
public interface IVehicleService {
	
	/**
	 * @return
	 */
	public List<Vehicle> getAllVehicles();

	/**
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Vehicle getVehiclesById(Long id) throws RecordNotFoundException;
	
	/**
	 * @param vehicle
	 * @return
	 */
	public Vehicle addVehicle(Vehicle vehicle);
	
	/**
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Vehicle deleteVehicleById(Long id) throws RecordNotFoundException;
	
	/**
	 * @param vehicleId
	 * @param vUpdate
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Vehicle updateVehicleUpdate(Long vehicleId,VehicleUpdates vUpdate) throws RecordNotFoundException;
}
