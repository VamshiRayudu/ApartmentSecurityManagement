package com.sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Attendance;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance, Long>{

}
