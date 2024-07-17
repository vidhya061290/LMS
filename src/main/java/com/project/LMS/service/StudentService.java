package com.project.LMS.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.LMS.Dto.StudentDto;

public interface StudentService {

public ResponseEntity<StudentDto> createStudent(StudentDto studentdto);

public ResponseEntity<StudentDto> getById(int id);

public ResponseEntity<StudentDto> updateEmailById(int id, String email);

public ResponseEntity<String> deleteById(int id);

public ResponseEntity<List<StudentDto>> getAllStudents();

public ResponseEntity<StudentDto> updateFirstNameById(int id, String firstname);

}
