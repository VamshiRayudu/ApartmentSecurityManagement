package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

	public Admin findByEmailId(String emailId);

	public List<Admin> findByName(String name);

}
