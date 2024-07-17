package com.project.LMS.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.LMS.models.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher , Integer> {

}
