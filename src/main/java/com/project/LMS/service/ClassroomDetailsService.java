package com.project.LMS.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.project.LMS.Dto.ClassroomDetailsDto;


public interface ClassroomDetailsService {

	ResponseEntity<ClassroomDetailsDto> addClassroomDetails(ClassroomDetailsDto cdDto);

	ResponseEntity<ClassroomDetailsDto> getById(int id);

	ResponseEntity<List<ClassroomDetailsDto>> getAllClassroomDetails();

	ResponseEntity<ClassroomDetailsDto> updateCourseIdById(int id, int courseId);

	ResponseEntity<ClassroomDetailsDto> updateTeacherIdById(int id, int teacherId);

	ResponseEntity<ClassroomDetailsDto> updateStudentIdById(int id, int studentId);

	ResponseEntity<ClassroomDetailsDto> updateClassroomIdById(int id, int classroomId);

}
