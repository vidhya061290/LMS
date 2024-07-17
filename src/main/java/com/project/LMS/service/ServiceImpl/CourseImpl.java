package com.project.LMS.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.LMS.Dao.CourseRepository;
import com.project.LMS.Dto.CourseDto;
import com.project.LMS.mapper.CourseMapper;
import com.project.LMS.models.Course;
import com.project.LMS.service.CourseService;

@Service
public class CourseImpl implements CourseService {
	@Autowired
	CourseRepository courserepo;
	@Autowired
	CourseMapper coursemapper;

	@Override
	public ResponseEntity<CourseDto> addCourse(CourseDto coursedto) {
		Course course = coursemapper.mapToCourse(coursedto);
		Course course1 = courserepo.save(course);
		CourseDto coursedto1 = coursemapper.mapToCourseDto(course1);
		return new ResponseEntity <>(coursedto1 , HttpStatus.CREATED);
		
	}

	@Override
	public ResponseEntity<CourseDto> getById(int id) {
		Optional <Course> course = courserepo.findById(id);
		CourseDto coursedto = coursemapper.mapToCourseDto(course.get());
		return new ResponseEntity<>(coursedto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CourseDto>> getAllCourses() {
		List<Course> courses = courserepo.findAll();
		List<CourseDto> coursedtos = new ArrayList<>();
		for(Course course : courses) {
			CourseDto coursedto1 = coursemapper.mapToCourseDto(course);
			coursedtos.add(coursedto1);
		}
		return new ResponseEntity<>(coursedtos , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CourseDto> updateById(int id, CourseDto coursedto) {
		Optional<Course> course = courserepo.findById(id);
		Course course1 = coursemapper.mapToCourse(coursedto);
		course.get().setId(course1.getId());
		course.get().setTitle(course1.getTitle());
		course.get().setCreatedAt(course1.getCreatedAt());
		course.get().setStartDate(course1.getStartDate());
		course.get().setEndDate(course1.getEndDate());
		course.get().setTeacherId(course1.getTeacherId());
	    Course course2 = courserepo.save(course.get());
		CourseDto coursedto1 = coursemapper.mapToCourseDto(course2);
		return new ResponseEntity<>(coursedto1 , HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<CourseDto> updateTitleById(int id, String title) {
	Optional<Course> course = courserepo.findById(id);
		course.get().setTitle(title);
		Course course1 = courserepo.save(course.get());
		CourseDto coursedto = coursemapper.mapToCourseDto(course1);
		return new ResponseEntity <>(coursedto , HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<CourseDto> updateTeacherIdById(int id, int teacherId) {
		Optional<Course> course = courserepo.findById(id);
		course.get().setTeacherId(teacherId);
		Course course1 = courserepo.save(course.get());
		CourseDto coursedto = coursemapper.mapToCourseDto(course1);
		return new ResponseEntity <>(coursedto , HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<String> deleteById(int id) {
		 if (courserepo.existsById(id)) {
	          courserepo.deleteById(id);  
	          return new ResponseEntity<>(" Successfully deleted the id : " + id , HttpStatus.OK);
	      } else
	   	   return new ResponseEntity<>(" invalid id " , HttpStatus.BAD_REQUEST);
	}
	
	
}
