package com.mr2demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mr2demo.keywords.Keyword;

public class CartPage {
	
	private static final Logger LOG = Logger.getLogger(CartPage.class);
	
	// WebElements
	@FindBy(css = "div.emptyCart-base-emptyText")
	public WebElement emptyCartText;
	
	
	public CartPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	public void validateCartPage() {
		LOG.info("Validating cart page");
		Assert.assertTrue(emptyCartText.getText().contains("Hey, it feels so light!"));
	}
	
}