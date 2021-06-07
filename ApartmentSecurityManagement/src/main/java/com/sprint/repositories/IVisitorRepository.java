package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entities.Visitor;

public interface IVisitorRepository extends JpaRepository<Visitor, Long>{

}
