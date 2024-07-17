package com.project.LMS.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.LMS.Dto.ClassroomDto;

public interface ClassroomService {

	ResponseEntity<ClassroomDto> addClassroom(ClassroomDto cDto);

	ResponseEntity<ClassroomDto> getById(int id);

	ResponseEntity<List<ClassroomDto>> getAllClassroom();

	ResponseEntity<ClassroomDto> updateCapacityById(int id, int capacity);

	ResponseEntity<ClassroomDto> updateById(int id, ClassroomDto cdto);
	
	ResponseEntity<ClassroomDto> updateClassroomNameById(int id, String classroomName);
}
