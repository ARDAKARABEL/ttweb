package com.ardakarabel.ttweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringDBConfig {


	@Autowired
	DataSource dataSource;

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}


	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(TrackRecordConstants.JDBC_URL);
		dataSource.setUsername("root");
		dataSource.setPassword("Allianz2019!");
		return dataSource;
	}

	/*
	@Bean
	public DataSource getEmbeddedDataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setName("etsdb").setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/sql/create-db.sql").build();
		return db;
	}
	*/
}