package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
