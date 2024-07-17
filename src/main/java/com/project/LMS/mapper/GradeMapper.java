package com.project.LMS.mapper;

import org.springframework.stereotype.Component;
import com.project.LMS.Dto.GradesDto;
import com.project.LMS.models.Grades;

@Component
public class GradeMapper {
	public Grades mapToGrade(GradesDto gradedto) {
		Grades grades = new Grades(gradedto.getId(),gradedto.getAssignmentId(),
				        gradedto.getCourseId(),gradedto.getStudentId(),
		        		gradedto.getGradeValue(),gradedto.getCreatedAt());
		return grades;
				
	}
	public GradesDto mapToGradeDto(Grades grades) {
		GradesDto gradedto = new GradesDto(grades.getId(),grades.getAssignmentId(),
				        grades.getCourseId(),grades.getStudentId(),
		        		grades.getGradeValue(),grades.getCreatedAt());
				return gradedto;
	}

}
