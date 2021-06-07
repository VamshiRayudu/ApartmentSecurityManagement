package com.sprint.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Attendance;
import com.sprint.repositories.IAttendanceRepository;


@Service
@Transactional
public class AttendanceServiceImpl implements IAttendanceService{

	
	@Autowired
	private IAttendanceRepository attendanceRepository;
	
	@Override
	public Attendance addAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attendance updateAttendance(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
