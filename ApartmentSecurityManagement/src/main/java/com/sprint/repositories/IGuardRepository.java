package com.sprint.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint.entities.Attendance;
import com.sprint.entities.Delivery;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.Guard;
import com.sprint.entities.GuardSalary;
import com.sprint.entities.SecurityAlert;
import com.sprint.entities.VehicleUpdates;

public interface IGuardRepository extends JpaRepository<Guard, Long>{

	public List<Guard> findByName(String name);
	
	public List<Guard> findByGuardShifts(Long id);
	
	public List<Attendance> findByGuardAttendances(Long id);
	
	public List<GuardSalary> findByGuardSalaries(Long id);
	
//	@Query("select g FROM Guard g WHERE g.inTime = ?1 and g.outTime = ?2")
//	public List<Guard> getGuardsByTimings(LocalDateTime inTime, LocalDateTime outTime);
	
	
	public Guard findByIsTrained(Long id);
	
	public List<Guard> findByIsTrained(Boolean isTrained);
	
	
//	@Query("select * FROM guard_attnd ORDER BY id")
//	public List<Attendance> getGuardAttendanceList();
//	
//	
//	@Query("select g FROM guard_salaries ORDER BY id")
//	public List<GuardSalary> getGuardSalaryList();
//	
//	@Query("select g FROM guard_vehicleupd g ORDER BY id") //Join should be used
//	public List<VehicleUpdates> getVehicleUpdatesByGuardList();
//	
//	@Query("select g FROM securityalerts_asm g g.GUARD_ALERTS = ?1") //join should be used
//	public List<SecurityAlert> getSecurityAlertsByGuardId(Long id);
//	
//	
//	@Query("select g FROM securityalerts_asm g g.GUARD_ALERTS = ?1") //join should be used
//	public List<SecurityAlert> getSecurityAlertsByGuardIdAndDate(Long id, LocalDateTime date);
//	
//	@Query("select g FROM guard_asm_delivery_asm g g.GUARD_ALERTS = ?1") //join should be used
//	public List<Delivery> getDeliveryByGuardId(Long id);
//	
//	@Query("select g FROM guard_asm_delivery_asm g g.GUARD_ALERTS = ?1") //join should be used
//	public List<DomesticHelp> getDomesticHelpbyGuardId(Long id);
	
	
	
}
