package com.project.LMS.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.LMS.Dto.CourseDto;

public interface CourseService {

	ResponseEntity<CourseDto> addCourse(CourseDto coursedto);

	ResponseEntity<CourseDto> getById(int id);

	ResponseEntity<List<CourseDto>> getAllCourses();

	ResponseEntity<CourseDto> updateById(int id, CourseDto coursedto);

	ResponseEntity<CourseDto> updateTitleById(int id, String title);

	ResponseEntity<CourseDto> updateTeacherIdById(int id, int teacherId);

	ResponseEntity<String> deleteById(int id);

}
