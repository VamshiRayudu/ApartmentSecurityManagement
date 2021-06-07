package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

}
