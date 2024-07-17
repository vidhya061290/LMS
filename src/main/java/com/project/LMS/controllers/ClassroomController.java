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
import com.project.LMS.Dto.ClassroomDto;
import com.project.LMS.service.ClassroomService;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomController {
	@Autowired
	ClassroomService cService;
	
	@PostMapping
	public ResponseEntity<ClassroomDto> addClassroom(@RequestBody ClassroomDto cDto){
		return cService.addClassroom(cDto);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ClassroomDto> getById(@PathVariable int id){
		return cService.getById(id);
	}
	@GetMapping
	public ResponseEntity<List<ClassroomDto>> getAllClassroom(){
		return cService.getAllClassroom();
	}
	@PutMapping("/capacity/{id}")
	public ResponseEntity<ClassroomDto> updateCapacityById(@PathVariable int id , Map<String,Integer> request){
		int capacity = request.get("capacity");
		return cService.updateCapacityById(id , capacity);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ClassroomDto> updateById(@PathVariable int id ,@RequestBody ClassroomDto cdto){
		return cService.updateById(id,cdto);
	}
	@PutMapping("/classroomName/{id}")
	public ResponseEntity<ClassroomDto> updateClassroomNameById(@PathVariable int id , Map<String,String> request){
		String classroomName = request.get("classroomName");
		return cService.updateClassroomNameById(id , classroomName);
	}

}
