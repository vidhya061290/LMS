package com.project.LMS.mapper;

import org.springframework.stereotype.Component;
import com.project.LMS.Dto.CourseDto;
import com.project.LMS.models.Course;

@Component
public class CourseMapper {
	public Course mapToCourse(CourseDto coursedto) {
		Course course = new Course(coursedto.getId() , coursedto.getTitle(), 
				coursedto.getStartDate() , coursedto.getEndDate() , 
				coursedto.getCreatedAt() , coursedto.getTeacherId());
		return course;
	}
		
		public CourseDto mapToCourseDto(Course course) {
			CourseDto coursedto = new CourseDto(course.getId() , course.getTitle(), 
					course.getStartDate() , course.getEndDate() , 
					course.getCreatedAt() , course.getTeacherId());
			return coursedto;
	}


}
