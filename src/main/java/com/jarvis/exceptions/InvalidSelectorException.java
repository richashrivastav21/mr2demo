package com.jarvis.exceptions;

public class InvalidSelectorException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	String locatorType;

	public InvalidSelectorException(String locatorType) {
		this.locatorType = locatorType;
	}

	public String getMessage() {
		return "Invalid locator type: " + locatorType;
	}
}
