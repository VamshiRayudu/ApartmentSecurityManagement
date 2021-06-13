package com.sprint.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Vehicle;
import com.sprint.entities.VehicleUpdates;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.repositories.IVehicleRepository;

/**
 * @author VISHNU KUMAR
 *
 */
@Service
@Transactional
public class VehicleServiceImpl implements IVehicleService{

	@Autowired
	private IVehicleRepository vehicleRepository;

	@Override
	public Vehicle getVehiclesById(Long id) throws RecordNotFoundException {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if(vehicle!=null)
		{
			return vehicleRepository.getById(id);
		}
		else
		{
			throw new RecordNotFoundException("Record not found");
		}
	}

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return vehicleRepository.save(vehicle) ;
	}

	@Override
	public Vehicle deleteVehicleById(Long id) throws RecordNotFoundException{
		Optional<Vehicle> deleteVehicle=vehicleRepository.findById(id);
		if(deleteVehicle !=null)
		{
			vehicleRepository.delete(deleteVehicle.get());
		}
		else
		{
			throw new RecordNotFoundException("Record not found");
		}
		return deleteVehicle.get();
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		// TODO Auto-generated method stub
		return vehicleRepository.findAll() ;
	}


	@Override
	public Vehicle updateVehicleUpdate(Long vehicleId, VehicleUpdates vUpdate) throws RecordNotFoundException {
		Optional<Vehicle>vehicle = vehicleRepository.findById(vehicleId);
		if(vehicle!=null)
		{
			vehicle.get().getVehicleUpdates().add(vUpdate);

			return vehicleRepository.save(vehicle.get());
		}
		else
		{
			throw new  RecordNotFoundException("user not found");
		}
	}

}
