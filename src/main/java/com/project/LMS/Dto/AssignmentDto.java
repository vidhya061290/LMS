package com.project.LMS.Dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDto {
	private int id;
	private String title;
	private int courseId;
	private Timestamp createdAt;
	private String description;
	private Timestamp dueAt;

}
