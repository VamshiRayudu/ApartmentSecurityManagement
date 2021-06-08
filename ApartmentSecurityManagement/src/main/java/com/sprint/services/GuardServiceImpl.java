package com.sprint.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.entities.Guard;

@Service
@Transactional
public class GuardServiceImpl implements IGuardService{

	@Override
	public Guard addGuard(Guard guard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guard getGuardById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guard> getAllGuards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guard deleteGuard(Guard guard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guard deleteGuardById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guard updateGuardById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guard updateGuard(Guard guard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guard updateGuardAttendance(Long id, LocalDateTime inTime, LocalDateTime outTime) {
		// TODO Auto-generated method stub
		return null;
	}


}
