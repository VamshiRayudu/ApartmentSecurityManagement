package com.sprint.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.entities.Admin;
import com.sprint.repositories.IAdminRepository;


@Service
@Transactional
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminRepository adminRepository;
	
	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.saveAndFlush(admin);
	}

	//USed for put
	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.saveAndFlush(admin);
	}

	//Patch Update
	@Override
	public Admin updateAdminById(Long id,String oldPassword,String newPassword) {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findById(id).get();
		
		if(admin.getPassword() == oldPassword)
		{
			admin.setPassword(newPassword);
			adminRepository.saveAndFlush(admin);
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
	public Admin getAdminById(Long id) {
		// TODO Auto-generated method stub
		return adminRepository.getById(id);
	}

	@Override
	public Admin deleteAdminById(Long id) {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findById(id).get();
		
		//performing a delete operation  on this id 
		adminRepository.deleteById(id);
		
		return admin;
	}

	@Override
	public Admin deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin adminData = adminRepository.findById(admin.getId()).get();
		
		//performing a delete operation  on the entity directly
		adminRepository.delete(adminData);

		return adminData;
	}
}
