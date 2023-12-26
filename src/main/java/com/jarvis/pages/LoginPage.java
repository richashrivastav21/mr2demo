package com.jarvis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jarvis.keywords.Keyword;

public class LoginPage {
	// WebElements
	@FindBy(css = "div.welcome-header")
	public WebElement loginFormHeaderText;
	
	
	public LoginPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	public void validateLoginPage() {
		Assert.assertTrue(loginFormHeaderText.getText().contains("Login"));
	}
	
}