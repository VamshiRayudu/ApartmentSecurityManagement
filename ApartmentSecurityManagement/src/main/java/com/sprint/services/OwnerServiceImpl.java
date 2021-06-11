package com.sprint.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sprint.entities.Owner;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IOwnerRepository;

@Service
@Transactional
public class OwnerServiceImpl extends UserServiceImpl implements IOwnerService{

	@Autowired
	private IOwnerRepository ownerRepository;

	@Override
	public Owner addOwner(Owner owner) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		Owner owner1 = ownerRepository.findByEmailId(owner.getEmailId());
		if(owner1 == null)
		{
			return ownerRepository.save(owner);
		}
		else
		{
			throw new DuplicateRecordException("owner already Exists");
		}
		
	}

	@Override
	public Owner getOwnerById(Long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Owner> owner = ownerRepository.findById(id);
		if(owner != null)
		{
			return owner.get();
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public List<Owner> getAllOwnerList() {
		// TODO Auto-generated method stub
		return ownerRepository.findAll();
	}

	@Override
	public Owner updateOwner(Owner owner) throws UserNotFoundException {
		Optional<Owner> owner1 = ownerRepository.findById(owner.getId());
		// TODO Auto-generated method stub
		if(owner1 != null)
		{
			return ownerRepository.save(owner);
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public Owner updateOwnerById(Long id,String oldPassword ,String newPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Owner> owner = ownerRepository.findById(id);
		if(owner != null)
		{
			if(owner.get().getPassword().equals(oldPassword))
			{
				owner.get().setName(newPassword);
				return ownerRepository.save(owner.get());
			}
			else
			{
				throw new ValidationException("Incorrect Password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public Owner deleteOwnerById(Long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		//first I am retrieving from the repository the owner  by that Id
		Optional<Owner> owner = ownerRepository.findById(id);

		//performing a delete operation  on this id 
		if(owner != null)
		{
			ownerRepository.deleteById(id);
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}

		//returning owner which is deleted
		return owner.get();
	}

	@Override
	public Owner deleteOwner(Owner owner) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Owner> owner1 = ownerRepository.findById(owner.getId());
		if(owner1 != null)
		{
			ownerRepository.delete(owner);
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
		return owner;
	}
}