package com.project.LMS.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.LMS.Dao.TeacherRepository;
import com.project.LMS.Dto.TeacherDto;
import com.project.LMS.mapper.TeacherMapper;
import com.project.LMS.models.Teacher;
import com.project.LMS.service.TeacherService;

@Service
public class TeacherImpl implements TeacherService {
	@Autowired
	TeacherMapper teachermapper;
	@Autowired
	TeacherRepository teacherrepo;
	
public ResponseEntity<TeacherDto> createStudent(TeacherDto teacherdto) {
	
	Teacher teacher1 = teachermapper.mapToTeacher(teacherdto);
    Teacher teacher2=teacherrepo.save(teacher1);
    TeacherDto teacherdto1 = teachermapper.mapToTeacherDto(teacher2);
    return new ResponseEntity<>( teacherdto1 , HttpStatus.CREATED);
	
}
@Override
public ResponseEntity<TeacherDto> getById(int id) {
	Optional<Teacher> teacher = teacherrepo.findById(id);
	TeacherDto teacherdto = teachermapper.mapToTeacherDto(teacher.get());
	return new ResponseEntity<>( teacherdto , HttpStatus.OK);
}

@Override
public ResponseEntity<TeacherDto> updateEmailById(int id, String email) {
	Optional<Teacher> teacher = teacherrepo.findById(id);
	teacher.get().setEmail(email);
    Teacher teacher1=teacherrepo.save(teacher.get());
	TeacherDto teacherdto = teachermapper.mapToTeacherDto(teacher1);
	return new ResponseEntity<>(teacherdto , HttpStatus.OK);
}

@Override
public ResponseEntity<String> deleteById(int id) {
	  if (teacherrepo.existsById(id)) {
          teacherrepo.deleteById(id);  
          return new ResponseEntity<>(" Successfully deleted the id : " + id , HttpStatus.OK);
      } else
   	   return new ResponseEntity<>(" invalid id " , HttpStatus.BAD_REQUEST);
}

@Override
public ResponseEntity< List<TeacherDto>> getAllTeachers() {
	List<Teacher> teachers = teacherrepo.findAll();
	List<TeacherDto> teacherdtos = new ArrayList<>();
	for(Teacher teacher:teachers) {
		TeacherDto teacherdto = teachermapper.mapToTeacherDto(teacher);
		teacherdtos.add(teacherdto);
	}
	return new ResponseEntity<>(teacherdtos , HttpStatus.OK);
	
}

@Override
public ResponseEntity<TeacherDto> updateFirstNameById(int id, String firstname) {
	Optional<Teacher> teacher = teacherrepo.findById(id);
	teacher.get().setFirstname(firstname);
	Teacher teacher1=teacherrepo.save(teacher.get());
	TeacherDto teacherdto = teachermapper.mapToTeacherDto(teacher1);
	return new ResponseEntity<>(teacherdto ,HttpStatus.OK);
}

}
