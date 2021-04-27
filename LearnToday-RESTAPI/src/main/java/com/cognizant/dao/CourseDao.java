package com.cognizant.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cognizant.model.Course;

public class CourseDao {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Course> getCourseById(String id){
		Integer idConv = Integer.parseInt(id);
		String query = "select from student where id='" + idConv + "' ";
		return jdbcTemplate.query(query, new CourseMapper());
	}
}
