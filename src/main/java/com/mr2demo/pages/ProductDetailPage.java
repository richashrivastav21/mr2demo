package com.mr2demo.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.mr2demo.keywords.Keyword;

public class ProductDetailPage {
	
	private static final Logger LOG = Logger.getLogger(ProductDetailPage.class);
	
	@FindBy(css = "h3.product-brand")
	public List<WebElement> productTitles;
	
	
	public ProductDetailPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	public void verifyProducDetailPageTitle(String expectedText) {
		LOG.info("Validating product detail page title");
		SoftAssert softly = new SoftAssert();
		LOG.info("Product detail page title "+Keyword.getDriver().getTitle());
		softly.assertTrue(Keyword.getDriver().getTitle().contains(expectedText));
		softly.assertAll();
	}

}
