package com.project.LMS.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "classroomsdetails")
public class ClassroomDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="course_id")
	private int courseId;
	@Column(name="classroom_id")
	private int classroomId;
	@Column(name="student_id")
	private int studentId;
	@Column(name="teacher_id")
	private int teacherId;
	@Column(name="created_at")
	private Timestamp createdAt;
	
	
}
