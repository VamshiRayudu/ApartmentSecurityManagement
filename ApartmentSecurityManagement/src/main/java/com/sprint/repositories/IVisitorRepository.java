package com.sprint.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Visitor;

@Repository
public interface IVisitorRepository extends JpaRepository<Visitor, Long>{

	public List<Visitor> findByVisitorName(String visitorName);
	
	public List<Visitor> findByInTime(LocalDateTime inTime);
	
	public List<Visitor> findByOutTime(LocalDateTime outTime);
	
	@Query("select v FROM Visitor v WHERE v.inTime = ?1 and v.outTime = ?2")
	public List<Visitor> getVisitorByTimings(LocalDateTime inTime, LocalDateTime outTime);
	
	@Query("select a FROM Visitor a WHERE a.flatDetails.id =?1")
	public List<Visitor> getAllVistiorsByFlatId(Long id);
	
}
