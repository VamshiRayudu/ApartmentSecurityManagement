package com.sprint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entities.Admin;
import com.sprint.services.AdminServiceImpl;
import com.sprint.services.IAdminService;

@RestController 
@RequestMapping("api/v1")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin)
	{
		return new ResponseEntity<Admin>(adminService.addAdmin(admin),HttpStatus.CREATED);
	}

}
