package com.project.LMS.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.LMS.Dto.GradesDto;

public interface GradesService {

	ResponseEntity<GradesDto> createGrade(GradesDto gradesdto);

	ResponseEntity<GradesDto> getById(int id);

	ResponseEntity<GradesDto> updateGradeValueById(int id, Integer gradeValue);

	ResponseEntity<String> deleteById(int id);

	ResponseEntity<List<GradesDto>> getAllGrades();

	ResponseEntity<GradesDto> updateAssignmentIdById(int id, Integer assignmentId);

	ResponseEntity<GradesDto> updateCourseIdById(int id, Integer courseId);

	ResponseEntity<GradesDto> updateStudentIdById(int id, Integer studentId);

}
