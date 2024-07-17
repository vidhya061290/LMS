package com.project.LMS.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.LMS.Dto.TeacherDto;

public interface TeacherService {

	ResponseEntity<TeacherDto> createStudent(TeacherDto teacherdto);

	ResponseEntity<TeacherDto> getById(int id);

	ResponseEntity<TeacherDto> updateEmailById(int id, String email);

	ResponseEntity<String> deleteById(int id);

	ResponseEntity<List<TeacherDto>> getAllTeachers();

	ResponseEntity<TeacherDto> updateFirstNameById(int id, String firstname);

}
