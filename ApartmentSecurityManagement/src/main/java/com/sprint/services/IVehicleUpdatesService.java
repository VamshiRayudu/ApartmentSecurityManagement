package com.sprint.services;
import java.util.List;

import com.sprint.entities.VehicleUpdates;

public interface IVehicleUpdatesService {
	
    public List<VehicleUpdates> getVehicleUpdateList();
    
    public VehicleUpdates getVehicleUpdateList(Long id);
    
    public VehicleUpdates addVehicleUpdate(VehicleUpdates vehcileUpdates);
    
    public VehicleUpdates updateVehicleUpdatesById(Long id);
    
    public VehicleUpdates updateVehicleUpdate(VehicleUpdates vehcileUpdates);
    
}