package com.sprint.services;

import java.util.List;

import com.sprint.entities.Admin;
import com.sprint.exceptions.UserNotFoundException;

public interface IAdminService extends IUserService {

	public Admin addAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public Admin updateAdminById(Long id,String oldPassword,String newPassword);
	
	public List<Admin> getAllAdmins();
	
	public Admin getAdminById(Long id) throws UserNotFoundException;
	
	public Admin deleteAdminById(Long id);
	
	public Admin deleteAdmin(Admin admin);
	
}
