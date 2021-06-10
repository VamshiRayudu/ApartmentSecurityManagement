package com.sprint.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entities.FlatDetails;
import com.sprint.entities.Owner;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IFlatDetailsRepository;

@Service
@Transactional
public class FlatDetailsServiceImpl implements IFlatDetailsService{

	@Autowired
	private IFlatDetailsRepository flatDetailsRepository;
	
	@Override
	public FlatDetails addFlatDetails(FlatDetails flatDetails)throws DuplicateRecordException {
		// TODO Auto-generated method stub
		Optional<FlatDetails> flatDetails1=flatDetailsRepository.findById(flatDetails.getFlatNumber());
		if(flatDetails1 == null)
		{
			return flatDetailsRepository.save(flatDetails);
		}
		else
		{
			throw new DuplicateRecordException("FlatNumber Already Exists");
		}
		
	}

	@Override
	public FlatDetails getFlatDetailsById(Long flatNumber) throws RecordNotFoundException
	{
		// TODO Auto-generated method stub
		Optional<FlatDetails> flatDetails=flatDetailsRepository.findById(flatNumber);
		if(flatDetails!=null)
		{
			return flatDetails.get();
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found");
		}
	}

	@Override
	public List<FlatDetails> listAllFlatDetails() {
		// TODO Auto-generated method stub
		return flatDetailsRepository.findAll();
	}

	@Override
	public FlatDetails updateFlatDetails(Long flatNumber, Owner ownerDetails) throws RecordNotFoundException{
		// TODO Auto-generated method stub
		Optional<FlatDetails> flatDetails=flatDetailsRepository.findById(flatNumber);
	
		if(flatDetails!=null)
		{
			flatDetails.get().getOwner().setEmailId(ownerDetails.getEmailId());
			
			flatDetails.get().getOwner().setPassword(ownerDetails.getPassword());
			
			flatDetails.get().getOwner().setEmailId(ownerDetails.getEmailId());
			
			flatDetailsRepository.save(flatDetails.get());
			
			return flatDetails.get();
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found");
		}
	}
}