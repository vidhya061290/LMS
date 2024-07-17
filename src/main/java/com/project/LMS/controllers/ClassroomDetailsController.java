package com.project.LMS.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.LMS.Dto.ClassroomDetailsDto;
import com.project.LMS.service.ClassroomDetailsService;


@RestController
@RequestMapping("/api/classroomDetails")
public class ClassroomDetailsController {
	@Autowired
	ClassroomDetailsService cdService;
	
	@PostMapping
	public ResponseEntity<ClassroomDetailsDto> addClassroomDetails(@RequestBody ClassroomDetailsDto cdDto){
		return cdService.addClassroomDetails(cdDto);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ClassroomDetailsDto> getById(@PathVariable int id){
		return cdService.getById(id);
	}
	@GetMapping
	public ResponseEntity<List<ClassroomDetailsDto>> getAllClassroomDetails(){
		return cdService.getAllClassroomDetails();
	}
	
	@PutMapping("/course/{id}")
	public ResponseEntity<ClassroomDetailsDto> updateCourseIdById(@PathVariable int id , Map<String,Integer> request){
		int courseId = request.get("courseId");
		return cdService.updateCourseIdById(id , courseId);
	}
	@PutMapping("/teacherId/{id}")
	public ResponseEntity<ClassroomDetailsDto> updateTeacherIdById(@PathVariable int id , Map<String,Integer> request){
		int teacherId = request.get("teacherId");
		return cdService.updateTeacherIdById(id,teacherId);
	}
	@PutMapping("/studentId/{id}")
	public ResponseEntity<ClassroomDetailsDto> updateStudentIdById(@PathVariable int id , Map<String,Integer> request){
		int studentId = request.get("studentId");
		return cdService.updateStudentIdById(id,studentId);
	}
	@PutMapping("/classroomId/{id}")
	public ResponseEntity<ClassroomDetailsDto> updateClassroomIdById(@PathVariable int id , Map<String,Integer> request){
		int classroomId = request.get("classroomId");
		return cdService.updateClassroomIdById(id,classroomId);
	}
	

}
