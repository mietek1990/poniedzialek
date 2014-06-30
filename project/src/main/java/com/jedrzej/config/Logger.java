package com.jedrzej.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Logger implements ApplicationListener<LoggerEvent>{

	public Logger(){
		System.out.println("Logger zostal utworzony");
	}
	
	
	public static void log(String message) {
		System.out.println("LOGGER:" + message);
	}


	public void onApplicationEvent(LoggerEvent event) {
		Logger.log(event.getMessage());
	}
}
