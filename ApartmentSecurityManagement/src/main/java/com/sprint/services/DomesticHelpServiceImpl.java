package com.sprint.services;
import java.util.List;
import java.util.Optional;

import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.Attendance;
import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;
import com.sprint.entities.FlatDetails;
import com.sprint.repositories.IDomesticHelpRepository;
import com.sprint.repositories.IFlatDetailsRepository;

@Service
@Transactional
public class DomesticHelpServiceImpl implements IDomesticHelpService {

	@Autowired
	private IDomesticHelpRepository domesticHelpRepository;
	
	@Autowired
	private IFlatDetailsRepository flatRepository;
	
	@Override
	public List<DomesticHelp> getDomesticHelpList() {
		// TODO Auto-generated method stub
		return domesticHelpRepository.findAll();
	}

	@Override
	public DomesticHelp getDomesticHelpById(Long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<DomesticHelp> domesticHelp=domesticHelpRepository.findById(id);
		if(domesticHelp!=null)
		{
			return domesticHelp.get();
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public DomesticHelp addDomesticHelp(Long flatNumber, DomesticHelp domesticHelp){
		// TODO Auto-generated method stub
		Optional<FlatDetails> flatDetails = flatRepository.findById(flatNumber);
		domesticHelp.setFlatDetails(flatDetails.get());
		return domesticHelpRepository.save(domesticHelp);
	}

	@Override
	public DomesticHelp updateDomesticHelpById(Long id , DomesticHelpType oldHelpType , DomesticHelpType newHelpType)throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<DomesticHelp> domesticHelp = domesticHelpRepository.findById(id);
		if(domesticHelp!=null)
		{
			if(domesticHelp.get().getHelpType().equals(oldHelpType))
			{
				domesticHelp.get().setHelpType(newHelpType);
				domesticHelpRepository.save(domesticHelp.get());
				return domesticHelp.get();
			}
			else
			{
				throw new ValidationException("Invalid helptype ");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}	

	@Override
	public DomesticHelp updateDomesticHelp(DomesticHelp domesticHelp)throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<DomesticHelp> domesticHelp1=domesticHelpRepository.findById(domesticHelp.getId());
		if(domesticHelp1!=null)
		{
			return domesticHelpRepository.save(domesticHelp);
		}
		else
		{
			throw new UserNotFoundException("Id Not found");
		}
	}

	@Override
	public DomesticHelp updateAttendance(Long domesticHelpId, Attendance attendance)throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<DomesticHelp> dHelp = domesticHelpRepository.findById(domesticHelpId);
		if(dHelp!=null)
		{
			dHelp.get().getAttendance().add(attendance);
			return domesticHelpRepository.save(dHelp.get());
		}
		else
		{
			throw new UserNotFoundException("Id Not Found");
		}
	}
}