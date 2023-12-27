package com.mr2demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mr2demo.keywords.Keyword;


public class LoginPage {
	
	private static final Logger LOG = Logger.getLogger(LoginPage.class);
	
	// WebElements
	@FindBy(css = "div.welcome-header")
	public WebElement loginFormHeaderText;
	
	
	public LoginPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	public void validateLoginPage() {
		LOG.info("Validating login page");
		Assert.assertTrue(loginFormHeaderText.getText().contains("Login"));
	}
	
}