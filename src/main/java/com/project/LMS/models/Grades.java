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
@Table(name="grades")
public class Grades {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="assignment_id")
	private int assignmentId;
	@Column(name="course_id")
	private int courseId;
	@Column(name="student_id")
	private int studentId;
	@Column(name="grade_value")
	private int gradeValue;
	@Column(name="created_at")
	private Timestamp createdAt;
}
