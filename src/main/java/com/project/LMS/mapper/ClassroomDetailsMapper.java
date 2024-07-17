package com.project.LMS.mapper;

import org.springframework.stereotype.Component;
import com.project.LMS.Dto.ClassroomDetailsDto;
import com.project.LMS.models.ClassroomDetails;

@Component
public class ClassroomDetailsMapper {
	public ClassroomDetails mapToClassroomDetails(ClassroomDetailsDto cdd) {
		ClassroomDetails cd = new ClassroomDetails(cdd.getId(),cdd.getCourseId(),
				                  cdd.getClassroomId(),cdd.getStudentId(),
				                  cdd.getTeacherId(),cdd.getCreatedAt());
		return cd;
		
	}
	public ClassroomDetailsDto mapToClassroomDetailsDto(ClassroomDetails cd) {
		ClassroomDetailsDto cdd = new ClassroomDetailsDto(cd.getId(),cd.getCourseId(),
				                  cd.getClassroomId(),cd.getStudentId(),
				                  cd.getTeacherId(),cd.getCreatedAt());
		return cdd;
		
	}
	
}
