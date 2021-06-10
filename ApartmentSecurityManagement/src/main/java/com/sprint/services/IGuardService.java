package com.sprint.services;

import java.time.LocalDateTime;
import java.util.List;

import com.sprint.entities.Guard;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

public interface IGuardService extends IUserService{
	
	public Guard addGuard(Guard guard) throws DuplicateRecordException;

	public Guard getGuardById(Long id) throws UserNotFoundException;
	
	public List<Guard> getAllGuards();
	
	public Guard deleteGuard(Guard guard)throws UserNotFoundException;
	
	public Guard deleteGuardById(Long id)throws UserNotFoundException;
	
	public Guard updateGuard(Guard guard) throws UserNotFoundException;
	
	public Guard updateGuardAttendance(Long id, LocalDateTime inTime, LocalDateTime outTime) throws UserNotFoundException;

	public Guard updateGuardById(Long id,Long oldMobileNumber, Long newMobileNumber) throws UserNotFoundException;
}
