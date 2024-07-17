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

import com.project.LMS.Dto.CourseDto;
import com.project.LMS.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	@Autowired
	CourseService courseservice;
	@PostMapping
	public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto coursedto){
		return courseservice.addCourse(coursedto);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> getById(@PathVariable int id){
		return courseservice.getById(id);
	}
	@GetMapping
	public ResponseEntity<List<CourseDto>> getAllCourses(){
		return courseservice.getAllCourses();
	}
	@PutMapping("/course/{id}")
	public ResponseEntity<CourseDto> updateCourseById(@PathVariable int id , @RequestBody CourseDto coursedto){
		return courseservice.updateById(id , coursedto);
	}
	@PutMapping("/title/{id}")
	public ResponseEntity<CourseDto> updateTitleById(@PathVariable int id , Map<String,String> request){
		String title = request.get("title");
		return courseservice.updateTitleById(id,title);
	}
	@PutMapping("/teacherId/{id}")
	public ResponseEntity<CourseDto> updateTeacherIdById(@PathVariable int id , Map<String,Integer> request){
		int teacherId = request.get("teacherId");
		return courseservice.updateTeacherIdById(id,teacherId);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		return courseservice.deleteById(id);
	}
	}


