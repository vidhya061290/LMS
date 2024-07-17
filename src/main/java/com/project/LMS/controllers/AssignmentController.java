package com.project.LMS.controllers;

import java.sql.Timestamp;
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
import com.project.LMS.Dto.AssignmentDto;
import com.project.LMS.service.AssignmentService;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {
	@Autowired
	AssignmentService assignmentService;
	@PostMapping
	public ResponseEntity<AssignmentDto> addAssignment(@RequestBody AssignmentDto ad){
		return assignmentService.addAssignment(ad);
	}
	@GetMapping("/{id}")
	public ResponseEntity<AssignmentDto> getById(@PathVariable int id){
		return assignmentService.getById(id);
	}
	@GetMapping
	public ResponseEntity<List<AssignmentDto>> getAllAssignment(){
		return assignmentService.getAllAssignment();
	}
	@PutMapping("/{id}")
	public ResponseEntity<AssignmentDto> updateById(@PathVariable int id ,@RequestBody AssignmentDto ad){
		return assignmentService.updateById(id,ad);
	}
	@PutMapping("/title/{id}")
	public ResponseEntity<AssignmentDto> updateTitleById(@PathVariable int id , Map<String,String> request){
		String title = request.get("title");
		return assignmentService.updateTitleById(id , title);
	}
	@PutMapping("/description/{id}")
	public ResponseEntity<AssignmentDto> updateDescriptionById(@PathVariable int id , Map<String,String> request){
		String description = request.get("description");
		return assignmentService.updateDescriptionById(id , description);
	}
	@PutMapping("/dueAt/{id}")
	public ResponseEntity<AssignmentDto> updateDueAtById(@PathVariable int id , Map<String,Timestamp> request){
		Timestamp dueAt = request.get("dueAt");
		return assignmentService.updateDueAtById(id , dueAt);
	}
}
