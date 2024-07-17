package com.project.LMS.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.LMS.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
