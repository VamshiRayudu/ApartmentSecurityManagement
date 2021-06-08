package com.sprint.services;

import java.util.List;

import com.sprint.entities.Owner;

public interface IOwnerService {
	
	public Owner addOwner(Owner owner);

	public Owner getOwnerById(Long id);
	
	public List<Owner> getAllOwnerList();
	
	public Owner updateOwner(Owner owner);
	
	public Owner updateOwnerById(Long id,String oldName,String newName);
	
	public Owner deleteOwnerById(Long id);
	
	public Owner deleteOwner(Owner owner);
	
	
}
