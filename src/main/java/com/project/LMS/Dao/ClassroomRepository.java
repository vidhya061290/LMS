package com.project.LMS.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LMS.models.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom , Integer> {

}
