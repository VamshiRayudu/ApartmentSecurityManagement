package com.sprint.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.entities.Admin;
import com.sprint.exceptions.DuplicateRecordException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IAdminRepository;


@Service
@Transactional
public class AdminServiceImpl extends UserServiceImpl implements IAdminService{

	@Autowired
	private IAdminRepository adminRepository;
	
	
	@Override
	public Admin addAdmin(Admin admin) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		Admin user =  adminRepository.findByEmailId(admin.getEmailId());
		if(user == null)
		{
			return adminRepository.save(admin);
		}
		else
		{
			throw new DuplicateRecordException("User Already Exists");
		}
	}

	//Used for put
	@Override
	public Admin updateAdmin(Admin admin) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> user =  adminRepository.findById(admin.getId());
		if(user != null)
		{
			return adminRepository.save(admin);
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	//Patch Update
	@Override
	public Admin updateAdminById(Long id,String oldPassword,String newPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> admin = adminRepository.findById(id);
		if(admin != null)
		{
			if(admin.get().getPassword().equals(oldPassword))
			{
				admin.get().setPassword(newPassword);
				return adminRepository.save(admin.get());
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
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(Long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
	      Optional<Admin> admin =  adminRepository.findById(id);
	      
	      if(admin != null)
	      {
	    	  return admin.get();
	      }
	      else
	      {
	    	  throw new UserNotFoundException("User Not Found");
	      }
	}

	@Override
	public Admin deleteAdminById(Long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		  Optional<Admin> deleteAdmin = adminRepository.findById(id);
	      if(deleteAdmin != null)
	      {
	    	  adminRepository.deleteById(id);
	      }
	      else
	      {
	    	  throw new UserNotFoundException("User Not Found");
	      }
		return deleteAdmin.get();
	}

	@Override
	public Admin deleteAdmin(Admin admin) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> adminData = adminRepository.findById(admin.getId());
		  if(adminData != null)
	      {
				adminRepository.delete(admin);
	      }
	      else
	      {
	    	  throw new UserNotFoundException("User Not Found");
	      }
		return admin;
	}
}
