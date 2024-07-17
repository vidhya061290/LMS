package com.project.LMS.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.LMS.Dto.TeacherDto;
import com.project.LMS.service.TeacherService;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController {
		@Autowired
		TeacherService teacherservice;

		@PostMapping
		public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto teacherdto){
			return teacherservice.createStudent(teacherdto);
		}
	    @GetMapping(path = "/{id}")
		public ResponseEntity <TeacherDto> getById(@PathVariable(name = "id") int id){
			return teacherservice.getById(id);
			
		}
		@PutMapping(path = "/email/{id}")
		public ResponseEntity <TeacherDto> updateById(@PathVariable(name= "id") int id,
				                                    @RequestBody Map<String,String>request){
			String email = request.get("email");
			return teacherservice.updateEmailById(id ,email);
		}
		@DeleteMapping("/{id}")
		public ResponseEntity <String> deleteById(@PathVariable(name = "id") int id){ 
			return teacherservice.deleteById(id);
		}
		@GetMapping
		public ResponseEntity<List<TeacherDto>> getAllTeachers(){
			return teacherservice.getAllTeachers();
		}
		@PutMapping(path = "/firstname/{id}")
		public ResponseEntity <TeacherDto> updateFirstnameById(@PathVariable (name ="id") int id ,
				                                      @RequestBody Map<String,String>request){
			String firstname = request.get("firstname");
			return teacherservice.updateFirstNameById(id,firstname);
			
			
		}
	}



