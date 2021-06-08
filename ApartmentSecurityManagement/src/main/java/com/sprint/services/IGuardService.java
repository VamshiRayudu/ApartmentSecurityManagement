package com.sprint.services;

import java.time.LocalDateTime;
import java.util.List;

import com.sprint.entities.Guard;

public interface IGuardService {
	
	public Guard addGuard(Guard guard);

	public Guard getGuardById(Long id);
	
	public List<Guard> getAllGuards();
	
	public Guard deleteGuard(Guard guard);
	
	public Guard deleteGuardById(Long id);
	
	public Guard updateGuardById(Long id);
	
	public Guard updateGuard(Guard guard);
	
	public Guard updateGuardAttendance(Long id, LocalDateTime inTime, LocalDateTime outTime);
}
