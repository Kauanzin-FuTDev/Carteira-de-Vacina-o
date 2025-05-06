package com.dashflow.API.Controllers.Exceptions;

public class CitizenAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CitizenAlreadyExistsException(String msg) {
		super(msg);
	}
}
