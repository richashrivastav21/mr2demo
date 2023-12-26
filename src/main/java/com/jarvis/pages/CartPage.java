package com.jarvis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jarvis.keywords.Keyword;

public class CartPage {
	// WebElements
	@FindBy(css = "div.emptyCart-base-emptyText")
	public WebElement emptyCartText;
	
	
	public CartPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	public void validateCartPage() {
		Assert.assertTrue(emptyCartText.getText().contains("Hey, it feels so light!"));
	}
	
}