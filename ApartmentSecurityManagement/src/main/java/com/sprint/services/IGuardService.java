package com.sprint.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sprint.entities.Attendance;
import com.sprint.entities.Guard;
import com.sprint.entities.GuardSalary;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

/**
 * @author SHUBHAM
 *
 */
public interface IGuardService extends IUserService{
	
	/**
	 * @param guard
	 * @return
	 * @throws DuplicateRecordException
	 */
	public Guard addGuard(Guard guard) throws DuplicateRecordException;

	/**
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	public Guard getGuardById(Long id) throws UserNotFoundException;
	
	/**
	 * @return
	 */
	public List<Guard> getAllGuards();
	
	/**
	 * @param guard
	 * @return
	 * @throws UserNotFoundException
	 */
	public Guard deleteGuard(Guard guard)throws UserNotFoundException;
	
	/**
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	public Guard deleteGuardById(Long id)throws UserNotFoundException;
	
	/**
	 * @param guard
	 * @return
	 * @throws UserNotFoundException
	 */
	public Guard updateGuard(Guard guard) throws UserNotFoundException;
	
	/**
	 * @param id
	 * @param attendance
	 * @return
	 * @throws UserNotFoundException
	 */
	public Guard updateGuardAttendance(Long id, Attendance attendance) throws UserNotFoundException;

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws UserNotFoundException
	 */
	public Guard updateGuardById(Long id,String oldPassword, String newPassword) throws UserNotFoundException;
	
	/**
	 * @param inTime
	 * @param outTime
	 * @return
	 */
	public List<Guard> getGuardsByTimings(LocalDateTime inTime, LocalDateTime outTime);
	
	/**
	 * @param id
	 * @param guardSalary
	 * @return
	 * @throws UserNotFoundException
	 */
	public Guard updateGuardSalary(Long id, GuardSalary guardSalary) throws UserNotFoundException;
		
	/**
	 * @return
	 */
	public List<Guard> getGuardAttendanceList();

	/**
	 * @return
	 */
	public List<Guard> getGuardSalaryList();
	
	/**
	 * @return
	 */
	public List<Guard> getVehicleUpdatesByGuardList();
}
