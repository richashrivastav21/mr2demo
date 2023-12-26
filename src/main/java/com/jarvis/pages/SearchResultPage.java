package com.jarvis.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.jarvis.keywords.Keyword;
import com.jarvis.waits.WaitFor;

public class SearchResultPage {

	@FindBy(css = "h3.product-brand")
	public List<WebElement> productTitles;

	@FindBy(css = "img.img-responsive")
	public WebElement firstProduct;

	@FindBy(css = "h4.product-product")
	public List<WebElement> productNames;

	@FindBy(css = "label[class='vertical-filters-label common-customCheckbox']")
	public WebElement brandFilter;

	@FindBy(css = "span.header-clearAllBtn")
	public WebElement clearAllFilter;

	private By productTitle = By.cssSelector("h3.product-brand");

	private By productName = By.cssSelector("h4.product-product");

	private By byBrandFilter = By.cssSelector("label[class='vertical-filters-label common-customCheckbox']");
	
	private By byClearAllFilter = By.cssSelector("span.header-clearAllBtn");

	public SearchResultPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	public List<String> getProducTitles() {
		WaitFor waitFor = new WaitFor();
		waitFor.numberOfElementsToBeMoreThan(productTitle, 1);
		Keyword.pageRefresh();
		Keyword keyword = new Keyword();
		return keyword.getTexts(productTitles);

	}

	public List<String> getProducNames() {
		WaitFor waitFor = new WaitFor();
		waitFor.numberOfElementsToBeMoreThan(productName, 1);
		Keyword keyword = new Keyword();
		return keyword.getTexts(productNames);

	}

	public void clickOnFirstProduct() {
		WaitFor waitFor = new WaitFor();
		waitFor.numberOfElementsToBeMoreThan(productTitle, 1);
		firstProduct.click();
	}

	public void verifyProducttitleContains(String expectedText) {
		List<String> productTitles = getProducTitles();
		SoftAssert softly = new SoftAssert();
		for (String productTitle : productTitles) {
			System.out.println("Checking :" + productTitle);
			softly.assertTrue(productTitle.contains(expectedText));
		}
		softly.assertAll();
	}

	public void verifyProductNameContains(String expectedText) {
		List<String> productNames = getProducNames();
		SoftAssert softly = new SoftAssert();
		for (String productName : productNames) {
			System.out.println("Checking :" + productName);
			Assert.assertTrue(productName.contains(expectedText));
		}
		softly.assertAll();
	}

	public String getFirstBrandFilterName() {
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(byBrandFilter);
		System.out.print("BrandFilter " + brandFilter.getText());
		return brandFilter.getText();
	}

	public void clickOnFirstBrandFilter() {
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(byBrandFilter);
		brandFilter.click();
	}

	public void clickOnClearAllFilter() {
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(byClearAllFilter);
		clearAllFilter.click();
	}

}
