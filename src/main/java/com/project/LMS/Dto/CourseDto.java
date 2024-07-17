package com.project.LMS.Dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseDto {
	private int id;
	private String title;
	private Timestamp startDate;
	private Timestamp endDate;
	private Timestamp createdAt;
	private int teacherId;
}

