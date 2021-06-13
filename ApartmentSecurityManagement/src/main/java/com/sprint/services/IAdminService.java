package com.sprint.services;

import java.util.List;

import com.sprint.entities.Admin;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
public interface IAdminService extends IUserService {

	/**
	 * @param admin
	 * @return
	 * @throws DuplicateRecordException
	 */
	public Admin addAdmin(Admin admin) throws DuplicateRecordException;
	
	/**
	 * @param admin
	 * @return
	 * @throws UserNotFoundException
	 */
	public Admin updateAdmin(Admin admin) throws UserNotFoundException;
	
	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws UserNotFoundException
	 */
	public Admin updateAdminById(Long id,String oldPassword,String newPassword) throws UserNotFoundException;
	
	/**
	 * @return
	 */
	public List<Admin> getAllAdmins();
	
	/**
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	public Admin getAdminById(Long id) throws UserNotFoundException;
	
	/**
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	public Admin deleteAdminById(Long id) throws UserNotFoundException;
	
	/**
	 * @param admin
	 * @return
	 * @throws UserNotFoundException
	 */
	public Admin deleteAdmin(Admin admin) throws UserNotFoundException;
	
}
