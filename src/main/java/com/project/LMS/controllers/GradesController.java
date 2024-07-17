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
import com.project.LMS.Dto.GradesDto;
import com.project.LMS.service.GradesService;

@RestController
@RequestMapping("/api/grades")
public class GradesController {
	@Autowired
	GradesService gradesservice;

	@PostMapping
	public ResponseEntity<GradesDto> addGrade(@RequestBody GradesDto gradesdto){
		return gradesservice.createGrade(gradesdto);
	}
    @GetMapping(path = "/{id}")
	public ResponseEntity <GradesDto> getById(@PathVariable(name = "id") int id){
		return gradesservice.getById(id);
		
	}
	@PutMapping(path = "/gradeValue/{id}")
	public ResponseEntity <GradesDto> updateGradeValueById(@PathVariable(name= "id") int id,
			                                    @RequestBody Map<String,Integer>request){
		Integer gradeValue = request.get("gradeValue");
		return gradesservice.updateGradeValueById(id ,gradeValue);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteById(@PathVariable(name = "id") int id){ 
		return gradesservice.deleteById(id);
	}
	@GetMapping
	public ResponseEntity<List<GradesDto>> getAllGrades(){
		return gradesservice.getAllGrades();
	}
	@PutMapping(path = "/assignmentId/{id}")
	public ResponseEntity <GradesDto> updateAssignmentIdById(@PathVariable (name ="id") int id ,
			                                      @RequestBody Map<String,Integer>request){
		Integer assignmentId = request.get("assignmentId");
		return gradesservice.updateAssignmentIdById(id,assignmentId);
		
		
	}
	@PutMapping(path = "/courseId/{id}")
	public ResponseEntity <GradesDto> updateCourseIdById(@PathVariable (name ="id") int id ,
			                                      @RequestBody Map<String,Integer>request){
		Integer courseId = request.get("courseId");
		return gradesservice.updateCourseIdById(id,courseId);
		
		
	}
	@PutMapping(path = "/studentId/{id}")
	public ResponseEntity <GradesDto> updateStudentIdById(@PathVariable (name ="id") int id ,
			                                      @RequestBody Map<String,Integer>request){
		Integer studentId = request.get("studentId");
		return gradesservice.updateStudentIdById(id,studentId);
		
		
	}
}
