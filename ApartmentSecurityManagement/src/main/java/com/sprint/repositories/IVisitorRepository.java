package com.sprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Visitor;

@Repository
public interface IVisitorRepository extends JpaRepository<Visitor, Long>{

	public List<Visitor> findByName(String visitorName);
}
