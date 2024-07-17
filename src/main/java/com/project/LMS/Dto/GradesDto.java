package com.project.LMS.Dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradesDto {
	private int id;
	private int assignmentId;
	private int courseId;
	private int studentId;
	private int gradeValue;
	private Timestamp createdAt;
}



