package com.sprint.services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Admin;
import com.sprint.entities.Attendance;
import com.sprint.entities.Guard;
import com.sprint.entities.GuardSalary;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IGuardRepository;

@Service
@Transactional
public class GuardServiceImpl extends UserServiceImpl implements IGuardService{

	@Autowired
	private IGuardRepository guardRepository;

	@Override
	public Guard addGuard(Guard guard) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		Guard user =  guardRepository.findByEmailId(guard.getEmailId());
		if(user == null)
		{
			return guardRepository.saveAndFlush(guard);
		}
		else
		{
			throw new DuplicateRecordException("User Already Exists");
		}

	}

	@Override
	public Guard getGuardById(Long id) throws UserNotFoundException{
		// TODO Auto-generated method stub
		Optional<Guard> guard = guardRepository.findById(id);
		if(guard!=null)
		{
			return guardRepository.getById(id);
		}
		else
		{
			throw new UserNotFoundException("UserNotFound");

		}
	}

	@Override
	public List<Guard> getAllGuards() {
		// TODO Auto-generated method stub
		return guardRepository.findAll();
	}

	@Override
	public Guard deleteGuard(Guard guard) throws UserNotFoundException{
		// TODO Auto-generated method stub
		Optional<Guard> gData =guardRepository.findById(guard.getId());
		if(gData != null)
		{
			guardRepository.delete(guard);
		}
		else
		{
			throw new UserNotFoundException("UserNotFound");
		}
		return guard;
	}

	@Override
	public Guard deleteGuardById(Long id) throws UserNotFoundException{
		// TODO Auto-generated method stub
		Optional<Guard> guard=guardRepository.findById(id);
		if(guard!=null)
		{
			guardRepository.delete(guard.get());
			return guard.get();
		}
		else
		{
			throw new UserNotFoundException("UserNotFound");
		}
	}

	@Override
	public Guard updateGuardById(Long id,String oldPassword, String newPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub	
		Optional<Guard> guard =guardRepository.findById(id);
		if(guard!=null)
		{
			if(guard.get().getPassword().equals(oldPassword)) {
				guard.get().setPassword(newPassword);
				return guardRepository.save(guard.get());

			}
			else
				throw new ValidationException("Invalid MobileNumber");
		}
		else
		{
			throw new UserNotFoundException("UserNotFound");
		}

	}	

	@Override
	public Guard updateGuard(Guard guard) throws UserNotFoundException{
		// TODO Auto-generated method stub
		Optional<Guard> user=guardRepository.findById(guard.getId());
		if(user!=null)
		{
			return guardRepository.save(guard);
		}
		else
		{
			throw new UserNotFoundException("UserNotFound");
		}
	}

	@Override
	public Guard updateGuardAttendance(Long id, Attendance attendance) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Guard> guard = guardRepository.findById(id);
		
		if(guard != null)
		{
			guard.get().getGuardAttendances().add(attendance);

			return guardRepository.save(guard.get());
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public List<Guard> getGuardsByTimings(LocalDateTime inTime, LocalDateTime outTime) {
		// TODO Auto-generated method stub
		return guardRepository.getGuardsByTimings(inTime, outTime);
	}

	@Override
	public List<Guard> getGuardAttendanceList() {
		// TODO Auto-generated method stub
		return guardRepository.getGuardAttendanceList();
	}

	@Override
	public List<Guard> getGuardSalaryList() {
		// TODO Auto-generated method stub
		return guardRepository.getGuardSalaryList();
	}

	@Override
	public List<Guard> getVehicleUpdatesByGuardList() {
		// TODO Auto-generated method stub
		return guardRepository.getVehicleUpdatesByGuardList();
	}

	@Override
	public Guard updateGuardSalary(Long id, GuardSalary guardSalary) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Guard> guard = guardRepository.findById(id);
		
		if(guard != null)
		{
			guard.get().getGuardSalaries().add(guardSalary);

			return guardRepository.save(guard.get());
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}
}