package com.ublwarriors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfig {
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.username")
	private String DB_USERNAME;
	
	@Value("${spring.datasource.password")
	private String DB_PASSWORD;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Bean
	public DataSource registerDataSource()
	{
		DriverManagerDataSource dataSource = null;
		try{
			dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(DB_DRIVER);
			dataSource.setUsername(DB_USERNAME);
			dataSource.setPassword(DB_PASSWORD);
			dataSource.setUrl(DB_URL);
		}catch(Exception e)
		{
			e.getMessage();
		}
		return dataSource;
	}
}
