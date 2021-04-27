package com.cognizant.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cognizant.model.Trainer;

public class TrainerDao {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int save(Trainer trainer) {
		return jdbcTemplate.update("INSERT INTO trainer(password, trainerid) VALUES(?,?)", trainer.getPassword(),
				trainer.getTrainerId());
	}

	public int update(int id, String password) {
		String query = "update trainer set " + "password='" + password + "' where id='" + id + "' ";
		return jdbcTemplate.update(query);
	}
}
