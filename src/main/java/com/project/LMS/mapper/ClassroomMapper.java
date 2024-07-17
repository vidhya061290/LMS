package com.project.LMS.mapper;

import org.springframework.stereotype.Component;
import com.project.LMS.Dto.ClassroomDto;
import com.project.LMS.models.Classroom;

@Component
public class ClassroomMapper {
	public Classroom mapToClassroom(ClassroomDto classroomdto) {
		Classroom classroom = new Classroom(classroomdto.getId(),classroomdto.getClassroomName(),
				classroomdto.getCapacity(),classroomdto.getCreatedAt());
		return classroom;
	}
	public ClassroomDto mapToClassroomDto(Classroom classroom) {
		ClassroomDto classroomDto = new ClassroomDto(classroom.getId(),classroom.getClassroomName(),
				classroom.getCapacity(),classroom.getCreatedAt());
		return classroomDto;
	}

}
