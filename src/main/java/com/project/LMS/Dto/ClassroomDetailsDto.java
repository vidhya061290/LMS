package com.project.LMS.Dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDetailsDto {
	private int id;
	private int courseId;
	private int classroomId;
	private int studentId;
	private int teacherId;
	private Timestamp createdAt;
	
	

}
