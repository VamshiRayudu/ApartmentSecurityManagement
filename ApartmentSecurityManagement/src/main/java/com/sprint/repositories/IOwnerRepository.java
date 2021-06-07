package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.Owner;

public interface IOwnerRepository extends JpaRepository<Owner, Long>{

}
