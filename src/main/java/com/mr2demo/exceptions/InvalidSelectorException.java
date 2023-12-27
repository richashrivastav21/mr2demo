package com.mr2demo.exceptions;

import org.apache.log4j.Logger;

public class InvalidSelectorException extends RuntimeException {

	private static final Logger LOG = Logger.getLogger(InvalidSelectorException.class);
	
	private static final long serialVersionUID = 1L;
	
	String locatorType;

	public InvalidSelectorException(String locatorType) {
		this.locatorType = locatorType;
	}

	public String getMessage() {
		LOG.info("Invalid locator type: "+ locatorType);
		return "Invalid locator type: " + locatorType;
	}
}
