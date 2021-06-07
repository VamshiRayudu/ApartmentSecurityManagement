package com.sprint.services;

import com.sprint.entities.Attendance;

public interface IAttendanceService {

	public Attendance addAttendance(Attendance attendance);
	
	public Attendance updateAttendance(Long id);
	
}
