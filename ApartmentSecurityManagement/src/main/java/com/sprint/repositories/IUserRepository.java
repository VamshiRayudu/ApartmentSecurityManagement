package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Role;
import com.sprint.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	
	public User findByEmailId(String emailId);
	
	
	public List<User> findByRole(Role role);
	
	
	public List<User> findByName(String name);
	
}
