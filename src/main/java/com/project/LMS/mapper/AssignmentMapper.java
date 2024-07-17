package com.project.LMS.mapper;

import org.springframework.stereotype.Component;

import com.project.LMS.Dto.AssignmentDto;
import com.project.LMS.models.Assignment;

@Component
public class AssignmentMapper {
	public Assignment mapToAssignment(AssignmentDto assignmentdto) {
		Assignment assignment = new Assignment(assignmentdto.getId(),assignmentdto.getTitle(),assignmentdto.getCourseId(),
				                               assignmentdto.getCreatedAt(),assignmentdto.getDescription(),assignmentdto.getDueAt());
		return assignment;
	}
	public AssignmentDto mapToAssignmentDto(Assignment assignment) {
		AssignmentDto assignmentdto =new AssignmentDto(assignment.getId(),assignment.getTitle(),assignment.getCourseId(),
                assignment.getCreatedAt(),assignment.getDescription(),assignment.getDueAt());
		return assignmentdto;
	}
	

}
