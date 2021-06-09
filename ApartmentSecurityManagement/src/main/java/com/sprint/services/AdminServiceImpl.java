package com.sprint.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.entities.Admin;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.repositories.IAdminRepository;


@Service
@Transactional
public class AdminServiceImpl extends UserServiceImpl implements IAdminService{

	@Autowired
	private IAdminRepository adminRepository;
	
	
	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	//Used for put
	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	//Patch Update
	@Override
	public Admin updateAdminById(Long id,String oldPassword,String newPassword) {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findById(id).get();
		
		if(admin.getPassword() == oldPassword)
		{
			admin.setPassword(newPassword);
			adminRepository.save(admin);
		}
		else 
		{
			//throw exception
		}
		return admin;
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
	    	  throw new UserNotFoundException();
	      }
	      
	}

	@Override
	public Admin deleteAdminById(Long id) {
		// TODO Auto-generated method stub
		Admin deleteAdmin = adminRepository.findById(id).get();
		
		//performing a delete operation  on this id 
		adminRepository.deleteById(id);
		
		return deleteAdmin;
	}

	@Override
	public Admin deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin adminData = adminRepository.findById(admin.getId()).get();
		
		//performing a delete operation  on the entity directly
		adminRepository.delete(adminData);

		return admin;
	}
}
