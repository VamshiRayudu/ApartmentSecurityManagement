package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.entities.VehicleUpdates;

@Service
@Transactional
public class VehicleUpdatesServiceImpl implements IVehicleUpdatesService{

	@Override
	public List<VehicleUpdates> getVehicleUpdateList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleUpdates getVehicleUpdateList(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleUpdates addVehicleUpdate(VehicleUpdates vehcileUpdates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleUpdates updateVehicleUpdatesById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleUpdates updateVehicleUpdate(VehicleUpdates vehcileUpdates) {
		// TODO Auto-generated method stub
		return null;
	}

}
