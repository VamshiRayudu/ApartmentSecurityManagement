package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint.entities.FlatDetails;

public interface IFlatDetailsRepository extends JpaRepository<FlatDetails, Long>{

	public List<FlatDetails> findByIsRented(Boolean isRented);
	
	public FlatDetails findByIsRented(Long FlatNumber);
	
	@Query("select fd FROM FlatDetails fd WHERE fd.owner.id = ?1 ")
	public List<FlatDetails> getFlatDetailsByOwnerName(Long ownerId);
	
	public List<FlatDetails> findFlatByFloorNumber(Long floorNumber);
}
