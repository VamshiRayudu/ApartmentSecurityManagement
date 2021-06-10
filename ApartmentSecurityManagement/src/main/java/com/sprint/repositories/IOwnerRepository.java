package com.sprint.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint.entities.Owner;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner,Long>{
	
	public Owner findByEmailId(String emailId);
	
	public List<Owner> findByName(String name);
	
	
//	@Query("select g from Owner ") //Join Query
//	public Owner getOwnerByFlatNumber(Long flatNumber);
//	
//	@Query("select g from Owner ") //Join Query
//	public List<Owner> getOwnerByFloorNumber(Long floorNumber);
	
}
