package com.jarvis.errors;

public class InvalidBrowserError extends Error {

	private static final long serialVersionUID = 1L;

	String browserName;
	public InvalidBrowserError(String browserName) {
		this.browserName=browserName;
	}
	public String getMesage() {
		return "Invalid browser name: "+ browserName;
	}
}
