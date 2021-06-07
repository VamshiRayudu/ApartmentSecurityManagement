package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Owner;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long>{
	
	public List<Owner> findByName(String name);
	

}
