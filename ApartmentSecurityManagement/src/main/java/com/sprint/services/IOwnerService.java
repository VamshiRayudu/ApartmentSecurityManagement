package com.sprint.services;

import java.util.List;

import com.sprint.entities.Owner;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

public interface IOwnerService extends IUserService{
	
	public Owner addOwner(Owner owner) throws DuplicateRecordException;

	public Owner getOwnerById(Long id) throws UserNotFoundException;
	
	public List<Owner> getAllOwnerList();
	
	public Owner updateOwner(Owner owner) throws UserNotFoundException;
	
	public Owner updateOwnerById(Long id,String oldName,String newName) throws UserNotFoundException;
	
	public Owner deleteOwnerById(Long id) throws UserNotFoundException;
	
	public Owner deleteOwner(Owner owner) throws UserNotFoundException;
	
	
}
