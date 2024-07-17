package com.project.LMS.mapper;

import org.springframework.stereotype.Component;
import com.project.LMS.Dto.TeacherDto;
import com.project.LMS.models.Teacher;

@Component
public class TeacherMapper {
		
	public Teacher mapToTeacher(TeacherDto teacherdto) {
		Teacher teacher = new Teacher(teacherdto.getId() ,teacherdto.getFirstname(),
						  teacherdto.getLastname(),teacherdto.getEmail(),teacherdto.getCreatedAt());
		return teacher;
			}

   public TeacherDto mapToTeacherDto(Teacher teacher) {
		TeacherDto teacherdto= new TeacherDto(teacher.getId() ,teacher.getFirstname(),
				               teacher.getFirstname(),teacher.getEmail(),teacher.getCreatedAt());
		return teacherdto;
			}
				

	}


