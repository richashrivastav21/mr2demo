package com.mr2demo.errors;

import org.apache.log4j.Logger;

public class InvalidBrowserError extends Error {
	
	private static final Logger LOG = Logger.getLogger(InvalidBrowserError.class);

	private static final long serialVersionUID = 1L;

	String browserName;
	public InvalidBrowserError(String browserName) {
		this.browserName=browserName;
	}
	public String getMesage() {
		LOG.info("Invalid browser name: "+ browserName);
		return "Invalid browser name: "+ browserName;
	}
}
