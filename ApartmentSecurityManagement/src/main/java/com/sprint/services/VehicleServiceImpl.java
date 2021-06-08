package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.entities.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements IVehicleService{

	@Override
	public Vehicle getVehiclesById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle deleteVehicleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Vehicle> getAllVehicles() {
		// TODO Auto-generated method stub
		return null;
	}

}
