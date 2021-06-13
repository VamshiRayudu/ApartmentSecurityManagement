package com.sprint.services;

import java.util.List;

import com.sprint.entities.Owner;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

/**
 * @author VIVEK PABBA
 *
 */
public interface IOwnerService extends IUserService{
	
	/**
	 * @param owner
	 * @return
	 * @throws DuplicateRecordException
	 */
	public Owner addOwner(Owner owner) throws DuplicateRecordException;

	/**
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	public Owner getOwnerById(Long id) throws UserNotFoundException;
	
	/**
	 * @return
	 */
	public List<Owner> getAllOwnerList();
	
	/**
	 * @param owner
	 * @return
	 * @throws UserNotFoundException
	 */
	public Owner updateOwner(Owner owner) throws UserNotFoundException;
	
	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws UserNotFoundException
	 */
	public Owner updateOwnerById(Long id,String oldPassword ,String newPassword) throws UserNotFoundException;
	
	/**
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	public Owner deleteOwnerById(Long id) throws UserNotFoundException;
	
	/**
	 * @param owner
	 * @return
	 * @throws UserNotFoundException
	 */
	public Owner deleteOwner(Owner owner) throws UserNotFoundException;
	
	
}
