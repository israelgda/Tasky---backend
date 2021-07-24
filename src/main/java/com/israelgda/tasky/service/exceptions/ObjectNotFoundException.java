package com.israelgda.tasky.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ObjectNotFoundException(Object id) {
		super("Task não encontrada. Id: " + id);
	}
	
	

}
