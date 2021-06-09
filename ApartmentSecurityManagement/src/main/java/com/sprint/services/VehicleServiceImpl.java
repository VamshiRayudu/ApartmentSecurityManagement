package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Vehicle;
import com.sprint.entities.VehicleUpdates;
import com.sprint.repositories.IVehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements IVehicleService{

	@Autowired
	private IVehicleRepository vehicleRepository;

	@Override
	public Vehicle getVehiclesById(Long id) {
		// TODO Auto-generated method stub
		return vehicleRepository.getById(id);

	}


	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return vehicleRepository.saveAndFlush(vehicle) ;
	}

	@Override
	public Vehicle deleteVehicleById(Long id) {
		// TODO Auto-generated method stub
		Vehicle vehicle= vehicleRepository .findById(id).get();
		vehicleRepository.deleteById(id);		
		return vehicle;
	}


	@Override
	public List<Vehicle> getAllVehicles() {
		// TODO Auto-generated method stub
		return vehicleRepository.findAll() ;
	}


	@Override
	public Vehicle updateVehicleUpdate(Long vehicleId, VehicleUpdates vUpdate) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Vehicle v= vehicleRepository.getById(vehicleId);
		v.getVehicleUpdates().add(vUpdate);
		return vehicleRepository.save(v);
	}



}
