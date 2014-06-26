package com.jedrzej.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Jdbc {
	
	@Value("${jdbc.baza}")
	private String databaseURL;
	@Value("${jdbc.login}")
	private String login;
	@Value("${jdbc.pass}")
	private String pass;
	
	@Bean
	public JdbcTemplate pobierzJDBCTemplate(){
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl(databaseURL);
		ds.setUsername(login);
		ds.setPassword(pass);
		return new JdbcTemplate(ds);
	}
}
