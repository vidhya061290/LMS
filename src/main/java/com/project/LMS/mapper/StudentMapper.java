package com.project.LMS.mapper;


import org.springframework.stereotype.Component;
import com.project.LMS.Dto.StudentDto;
import com.project.LMS.models.Student;

@Component
public class StudentMapper {
	
		public Student mapToStudent(StudentDto studentdto) {
			Student student = new Student(studentdto.getId() ,studentdto.getFirstname(),
					          studentdto.getLastname(),studentdto.getEmail(), studentdto.getCreatedAt());
			return student;
		}

		public StudentDto mapToStudentDto(Student students) {
			StudentDto studentdto = new StudentDto(students.getId() ,students.getFirstname(),
					                students.getFirstname(),students.getEmail(),students.getCreatedAt());
			return studentdto;
		}
			

}
