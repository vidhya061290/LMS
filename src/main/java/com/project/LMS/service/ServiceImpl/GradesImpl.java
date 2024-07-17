package com.project.LMS.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.LMS.Dao.GradesRepository;
import com.project.LMS.Dto.GradesDto;
import com.project.LMS.mapper.GradeMapper;
import com.project.LMS.models.Grades;
import com.project.LMS.service.GradesService;

@Service
public class GradesImpl implements GradesService {
	@Autowired
	GradeMapper grademapper;
	@Autowired
	GradesRepository gradesrepo;
	

	@Override
	public ResponseEntity<GradesDto> createGrade(GradesDto gradesdto) {
		Grades grades1 = grademapper.mapToGrade(gradesdto);
	    Grades grades2 = gradesrepo.save(grades1);
	    GradesDto gradesdto1 = grademapper.mapToGradeDto(grades2);
	    return new ResponseEntity<>(gradesdto1 , HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<GradesDto> getById(int id) {
		Optional<Grades> grades = gradesrepo.findById(id);
		GradesDto gradesdto = grademapper.mapToGradeDto(grades.get());
		return new ResponseEntity<>( gradesdto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GradesDto> updateGradeValueById(int id, Integer gradeValue) {
		Optional<Grades> grade = gradesrepo.findById(id);
		grade.get().setGradeValue(gradeValue);
	    Grades grade1=gradesrepo.save(grade.get());
		GradesDto gradedto = grademapper.mapToGradeDto(grade1);
		return new ResponseEntity<>(gradedto , HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<String> deleteById(int id) {
		 if (gradesrepo.existsById(id)) {
	          gradesrepo.deleteById(id);  
	          return new ResponseEntity<>(" Successfully deleted the id : " + id , HttpStatus.OK);
	      } else
	   	   return new ResponseEntity<>(" invalid id " , HttpStatus.BAD_REQUEST);
		
	}

	@Override
	public ResponseEntity<List<GradesDto>> getAllGrades() {
		List<Grades> grades = gradesrepo.findAll();
		List<GradesDto> gradedtos = new ArrayList<>();
		for(Grades grade:grades) {
			GradesDto gradedto1 = grademapper.mapToGradeDto(grade);
			gradedtos.add(gradedto1);
		}
		return new ResponseEntity<>(gradedtos , HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<GradesDto> updateAssignmentIdById(int id, Integer assignmentId) {
		Optional<Grades> grade = gradesrepo.findById(id);
		grade.get().setAssignmentId(assignmentId);
		Grades grade1 = gradesrepo.save(grade.get());
		GradesDto gradedto = grademapper.mapToGradeDto(grade1);
		return new ResponseEntity<>(gradedto , HttpStatus.OK);
		
		
	}

	@Override
	public ResponseEntity<GradesDto> updateCourseIdById(int id, Integer courseId) {
		Optional<Grades> grade = gradesrepo.findById(id);
		grade.get().setCourseId(courseId);
		Grades grade1 = gradesrepo.save(grade.get());
		GradesDto gradedto = grademapper.mapToGradeDto(grade1);
		return new ResponseEntity<>(gradedto , HttpStatus.OK);
	}	

	@Override
	public ResponseEntity<GradesDto> updateStudentIdById(int id, Integer studentId) {
		Optional<Grades> grade = gradesrepo.findById(id);
		grade.get().setStudentId(studentId);
		Grades grade1 = gradesrepo.save(grade.get());
		GradesDto gradedto = grademapper.mapToGradeDto(grade1);
		return new ResponseEntity<>(gradedto , HttpStatus.OK);
		
	}

}
