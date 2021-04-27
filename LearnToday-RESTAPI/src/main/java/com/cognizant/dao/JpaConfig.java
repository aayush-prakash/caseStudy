package com.cognizant.dao;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/learntodayrestapidb");
		dataSourceBuilder.username("hbstudent");
		dataSourceBuilder.password("hbstudent");
		return dataSourceBuilder.build();
	}
}
