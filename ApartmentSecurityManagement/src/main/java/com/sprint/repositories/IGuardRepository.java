package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.Guard;

public interface IGuardRepository extends JpaRepository<Guard, Long>{

}
