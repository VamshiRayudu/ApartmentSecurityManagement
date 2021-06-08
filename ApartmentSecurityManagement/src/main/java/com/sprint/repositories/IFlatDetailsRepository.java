package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.FlatDetails;

public interface IFlatDetailsRepository extends JpaRepository<FlatDetails, Long>{

	public List<FlatDetails> findByIsRented(Boolean isRented);
	
	public FlatDetails findByIsRented(Long FlatNumber);
	
}
