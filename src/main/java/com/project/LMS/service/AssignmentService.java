package com.project.LMS.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.LMS.Dto.AssignmentDto;

public interface AssignmentService {

	ResponseEntity<AssignmentDto> addAssignment(AssignmentDto ad);

	ResponseEntity<AssignmentDto> getById(int id);

	ResponseEntity<List<AssignmentDto>> getAllAssignment();

	ResponseEntity<AssignmentDto> updateById(int id, AssignmentDto ad);

	ResponseEntity<AssignmentDto> updateTitleById(int id, String title);

	ResponseEntity<AssignmentDto> updateDescriptionById(int id, String description);

	ResponseEntity<AssignmentDto> updateDueAtById(int id, Timestamp dueAt);

}
