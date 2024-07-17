package com.project.LMS.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.LMS.models.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment , Integer> {
	

}
