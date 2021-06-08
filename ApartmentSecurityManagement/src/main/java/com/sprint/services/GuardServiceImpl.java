package com.sprint.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Attendance;
import com.sprint.entities.Guard;
import com.sprint.repositories.IGuardRepository;

@Service
@Transactional
public class GuardServiceImpl implements IGuardService{

	@Autowired
	private IGuardRepository guardRepository;

	@Override
	public Guard addGuard(Guard guard) {
		// TODO Auto-generated method stub
		return guardRepository.saveAndFlush(guard);
	}

	@Override
	public Guard getGuardById(Long id) {
		// TODO Auto-generated method stub
		return guardRepository.getById(id);
	}

	@Override
	public List<Guard> getAllGuards() {
		// TODO Auto-generated method stub
		return guardRepository.findAll();
	}

	@Override
	public Guard deleteGuard(Guard guard) {
		// TODO Auto-generated method stub
		Guard g= guardRepository.findById(guard.getId()).get();

		//performing a delete operation  on the entity directly
		guardRepository.delete(guard);

		//returning Product which is deleted
		return g;
	}

	@Override
	public Guard deleteGuardById(Long id) {
		// TODO Auto-generated method stub
		Guard g = guardRepository.findById(id).get();

		//performing a delete operation  on this id
		guardRepository.deleteById(id);

		//returning Product which is deleted
		return g;
	}

	@Override
	public Guard updateGuardById(Long id,Long MobileNumber) {
		// TODO Auto-generated method stub	
		Guard guard = guardRepository.findById(id).get();
		guard.setMobileNumber(MobileNumber);

		return guard;
	}

	@Override
	public Guard updateGuard(Guard guard) {
		// TODO Auto-generated method stub
		return guardRepository.saveAndFlush(guard);
	}

	@Override
	public Guard updateGuardAttendance(Long id, LocalDateTime inTime, LocalDateTime outTime) {
		// TODO Auto-generated method stub
		Guard guard = guardRepository.findById(id).get();
		List<Attendance> attendanceList = new ArrayList();
		Attendance a = new Attendance();
		a.setInTime(inTime);
		a.setOutTime(outTime);
		a.setUpdatedByGuardId(id);
		attendanceList.add(a);
		guard.getGuardAttendances().add(a);
		return guardRepository.saveAndFlush(guard);
	}



}



