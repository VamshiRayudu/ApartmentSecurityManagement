package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sprint.entities.Role;
import com.sprint.entities.User;

public interface IUserRepository extends JpaRepository<User, Long>{

	
	public User findByEmailId(String emailId);
	
	
	public List<User> findByRole(Role role);
	
	
	public List<User> findByName(String name);
	
}
