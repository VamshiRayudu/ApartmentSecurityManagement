package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint.entities.FlatDetails;
import com.sprint.entities.Vehicle;

@Repository
public interface IFlatDetailsRepository extends JpaRepository<FlatDetails, Long> {

	/**
	 * @param isRented
	 * @return
	 */
	public List<FlatDetails> findByIsRented(Boolean isRented);

	public FlatDetails findByIsRented(Long FlatNumber);

	/**
	 * @param ownerId
	 * @return
	 */
	@Query("select fd FROM FlatDetails fd WHERE fd.owner.id = ?1 ")
	public List<FlatDetails> getFlatDetailsByOwnerId(Long ownerId);

	/**
	 * @param floorNumber
	 * @return
	 */
	public List<FlatDetails> findFlatByFloorNumber(Long floorNumber);

	@Query("select fd FROM FlatDetails fd WHERE fd.owner.name = ?1 ")
	public List<FlatDetails> getFlatDetailsByOwnerName(String ownerName);
}
