package com.cognizant.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cognizant.model.Course;
import com.cognizant.model.Student;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;

	public void setJdbcTemplate() {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Course> getAllCourses() {
		String query = "Select * from courses order by start_date";
		List<Course> courseList = jdbcTemplate.query(query, new CourseMapper());
		return courseList;
	}

	public int postStudent(Student student) {
		return jdbcTemplate.update("INSERT INTO student(enrollmentId, studentId, courseId) VALUES(?,?,?)",
				student.getEnrollmentId(), student.getStudentId(), student.getCourseId());
	}

	public int deleteById(int id) {
		String query = "delete from student where id='" + id + "' ";
		return jdbcTemplate.update(query);
	}
}
