package com.sprint.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint.entities.Admin;
import com.sprint.entities.Attendance;
import com.sprint.entities.Delivery;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.Guard;
import com.sprint.entities.GuardSalary;
import com.sprint.entities.SecurityAlert;
import com.sprint.entities.VehicleUpdates;

public interface IGuardRepository extends JpaRepository<Guard,Long>{
		
	public List<Guard> findByName(String name);
	
	public Guard findByEmailId(String emailId);
	
	public Guard findByIsTrained(Long id);
	
	public List<Guard> findByIsTrained(Boolean isTrained);
	
	@Query("select guard from Guard guard join guard.guardShifts gs where gs.inTime = ?1 and gs.outTime = ?2")
	public List<Guard> getGuardsByTimings(LocalDateTime inTime, LocalDateTime outTime);
	
	@Query("select guard from Guard guard join guard.guardAttendances ga where ga.id = ?1")
	public Guard getGuardAttendanceById(Long id);
	
	@Query("select guard from Guard guard join guard.guardSalaries gsl where gsl.id = ?1")
	public List<Guard> findByGuardSalaries(Long id);
		
	@Query("select guard from Guard guard join guard.guardAttendances ga ORDER BY ga.id")
	public List<Guard> getGuardAttendanceList();

	@Query("select guard from Guard guard join guard.guardSalaries gs ORDER BY gs.id")
	public List<Guard> getGuardSalaryList();
	
	@Query("select guard from Guard guard join guard.vehicleUpdates gvu ORDER BY gvu.id") //Join should be used
	public List<Guard> getVehicleUpdatesByGuardList();
	
//	@Query("select guard from Guard guard join guard.securityAlerts s WHERE s.guardAlerts = ?1")
//	public List<Guard> getSecurityAlertsByGuardId(Long id);
	
//	@Query("select guard from Guard guard join guard.securityAlerts s WHERE s.dateTimeOfAlert = ?1 and s.guardAlerts = ?2") //join should be used
//	public List<Guard> getSecurityAlertsByGuardIdAndDate(LocalDateTime date,Long id);
//	
//	@Query("select d FROM Delivery d join d.id ")
//	public List<Delivery> getDeliveryByGuardId(Long id);
//	
//	@Query("select dh FROM DomesticHelp dh WHERE dh. = ?1")
//	public List<DomesticHelp> getDomesticHelpbyGuardId(Long id);

}
