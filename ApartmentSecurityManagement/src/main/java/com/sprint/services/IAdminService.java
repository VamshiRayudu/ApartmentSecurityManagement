package com.sprint.services;

import java.util.List;

import com.sprint.entities.Admin;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;

public interface IAdminService extends IUserService {

	public Admin addAdmin(Admin admin) throws DuplicateRecordException;
	
	public Admin updateAdmin(Admin admin) throws UserNotFoundException;
	
	public Admin updateAdminById(Long id,String oldPassword,String newPassword) throws UserNotFoundException;
	
	public List<Admin> getAllAdmins();
	
	public Admin getAdminById(Long id) throws UserNotFoundException;
	
	public Admin deleteAdminById(Long id) throws UserNotFoundException;
	
	public Admin deleteAdmin(Admin admin) throws UserNotFoundException;
	
}
