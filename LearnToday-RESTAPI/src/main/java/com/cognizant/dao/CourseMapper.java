package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.cognizant.model.Course;

public class CourseMapper implements RowMapper<Course> {

	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setCourseId(rs.getInt("courseId"));
		course.setDescription(rs.getString("description"));
		course.setTitle(rs.getString("title"));
		course.setFees(rs.getFloat("fees"));
		course.setStart_date(rs.getDate("start_date"));
		course.setTrainer("trainer");
		return course;
	}

}
