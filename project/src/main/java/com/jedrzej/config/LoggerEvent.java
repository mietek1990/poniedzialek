package com.jedrzej.config;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class LoggerEvent extends ApplicationEvent {

	private String message;
	
	public LoggerEvent(Object source) {
		super(source);
	}
	
	public LoggerEvent(Object source, String message) {
		super(source);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
