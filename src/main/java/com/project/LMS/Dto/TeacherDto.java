package com.project.LMS.Dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private Timestamp createdAt;

}
