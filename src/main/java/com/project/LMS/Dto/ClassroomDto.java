package com.project.LMS.Dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDto {
	private int id;
	private String classroomName;
	private int capacity;
	private Timestamp createdAt;

}


