package com.project.LMS.service.ServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.LMS.Dao.StudentRepository;
import com.project.LMS.Dto.StudentDto;
import com.project.LMS.mapper.StudentMapper;
import com.project.LMS.models.Student;
import com.project.LMS.service.StudentService;

@Service
public class StudentImpl implements StudentService {
	@Autowired
	StudentMapper studentmapper;
	@Autowired
	StudentRepository studentrepo;
	
public ResponseEntity<StudentDto> createStudent(StudentDto studentdto) {
	
	Student student1 = studentmapper.mapToStudent(studentdto);
    Student	student2=studentrepo.save(student1);
    StudentDto studentdto1 = studentmapper.mapToStudentDto(student2);
    return new ResponseEntity<>( studentdto1 , HttpStatus.CREATED);
	
}
@Override
public ResponseEntity<StudentDto> getById(int id) {
	Optional<Student> student = studentrepo.findById(id);
	StudentDto studentdto = studentmapper.mapToStudentDto(student.get());
	return new ResponseEntity<>( studentdto , HttpStatus.OK);
}

@Override
public ResponseEntity<StudentDto> updateEmailById(int id, String email) {
	Optional<Student> student = studentrepo.findById(id);
	student.get().setEmail(email);
	 Student student1=studentrepo.save(student.get());
	StudentDto studentdto = studentmapper.mapToStudentDto(student1);
	return new ResponseEntity<>(studentdto , HttpStatus.OK);
}

@Override
public ResponseEntity<String> deleteById(int id) {
	  if (studentrepo.existsById(id)) {
          studentrepo.deleteById(id);  
          return new ResponseEntity<>(" Successfully deleted the id : " + id , HttpStatus.OK);
      } else
   	   return new ResponseEntity<>(" invalid id " , HttpStatus.BAD_REQUEST);
}

@Override
public ResponseEntity< List<StudentDto>> getAllStudents() {
	List<Student> students = studentrepo.findAll();
	List<StudentDto> studentdtos = new ArrayList<>();
	for(Student student:students) {
		StudentDto studentdto = studentmapper.mapToStudentDto(student);
		studentdtos.add(studentdto);
	}
	return new ResponseEntity<>(studentdtos , HttpStatus.OK);
	
}

@Override
public ResponseEntity<StudentDto> updateFirstNameById(int id, String firstname) {
	Optional<Student> student = studentrepo.findById(id);
	student.get().setFirstname(firstname);
	 Student student1=studentrepo.save(student.get());
	StudentDto studentdto = studentmapper.mapToStudentDto(student1);
	return new ResponseEntity<>(studentdto ,HttpStatus.OK);
}

}
