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

import com.project.LMS.Dto.StudentDto;
import com.project.LMS.service.StudentService;
@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
	@Autowired
	StudentService studentservice;

	@PostMapping
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentdto){
		return studentservice.createStudent(studentdto);
	}
    @GetMapping(path = "/{id}")
	public ResponseEntity <StudentDto> getById(@PathVariable(name = "id") int id){
		return studentservice.getById(id);
		
	}
	@PutMapping(path = "/email/{id}")
	public ResponseEntity <StudentDto> updateById(@PathVariable(name= "id") int id,
			                                    @RequestBody Map<String,String>request){
		String email = request.get("email");
		return studentservice.updateEmailById(id ,email);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteById(@PathVariable(name = "id") int id){ 
		return studentservice.deleteById(id);
	}
	@GetMapping
	public ResponseEntity<List<StudentDto>> getAllStudents(){
		return studentservice.getAllStudents();
	}
	@PutMapping(path = "/firstname/{id}")
	public ResponseEntity <StudentDto> updateFirstnameById(@PathVariable (name ="id") int id ,
			                                      @RequestBody Map<String,String>request){
		String firstname = request.get("firstname");
		return studentservice.updateFirstNameById(id,firstname);
		
		
	}
}



