package com.project.LMS.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LMS.models.ClassroomDetails;

public interface ClassroomDetailsRepository extends JpaRepository<ClassroomDetails , Integer> {
	

}
