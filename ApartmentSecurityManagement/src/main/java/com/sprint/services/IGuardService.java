package com.sprint.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sprint.entities.Attendance;
import com.sprint.entities.Guard;
import com.sprint.entities.GuardSalary;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

public interface IGuardService extends IUserService{
	
	public Guard addGuard(Guard guard) throws DuplicateRecordException;

	public Guard getGuardById(Long id) throws UserNotFoundException;
	
	public List<Guard> getAllGuards();
	
	public Guard deleteGuard(Guard guard)throws UserNotFoundException;
	
	public Guard deleteGuardById(Long id)throws UserNotFoundException;
	
	public Guard updateGuard(Guard guard) throws UserNotFoundException;
	
	public Guard updateGuardAttendance(Long id, Attendance attendance) throws UserNotFoundException;

	public Guard updateGuardById(Long id,String oldPassword, String newPassword) throws UserNotFoundException;
	
	public List<Guard> getGuardsByTimings(LocalDateTime inTime, LocalDateTime outTime);
	
	public Guard updateGuardSalary(Long id, GuardSalary guardSalary) throws UserNotFoundException;
		
	public List<Guard> getGuardAttendanceList();

	public List<Guard> getGuardSalaryList();
	
	public List<Guard> getVehicleUpdatesByGuardList();
}
