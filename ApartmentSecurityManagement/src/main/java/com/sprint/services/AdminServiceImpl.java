package com.sprint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.entities.Admin;


@Service
@Transactional
public class AdminServiceImpl implements IAdminService{

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> listAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin listAdminById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin deleteAdminById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean changePassword(Long id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
