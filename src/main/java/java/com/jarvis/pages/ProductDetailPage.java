package com.jarvis.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.jarvis.keywords.Keyword;

public class ProductDetailPage {
	
	@FindBy(css = "h3.product-brand")
	public List<WebElement> productTitles;
	
	
	public ProductDetailPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	public void verifyProducDetailPageTitle(String expectedText) {
		SoftAssert softly = new SoftAssert();
		System.out.println(Keyword.getDriver().getTitle());
		softly.assertTrue(Keyword.getDriver().getTitle().contains(expectedText));
		softly.assertAll();
	}

}
