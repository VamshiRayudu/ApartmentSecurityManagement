package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long>{

}
