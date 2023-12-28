package com.mr2demo.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.mr2demo.keywords.Keyword;
import com.mr2demo.waits.WaitFor;

public class SearchResultPage {

	private static final Logger LOG = Logger.getLogger(SearchResultPage.class);

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

	@FindBy(css = "ul.results-base>li:nth-child(2) h4.product-product")
	public WebElement productTitlesw;

	@FindBy(css = "ul.atsa-filters>li:nth-of-type(3)>label>h4.atsa-title")
	public WebElement fabricmenu;

	@FindBy(css = "ul.atsa-values>li:first-of-type>label.common-customCheckbox>div.common-checkboxIndicator")
	public WebElement Acrylikfabric;

	private By productTitle = By.cssSelector("h3.product-brand");

	private By productName = By.cssSelector("h4.product-product");

	private By byBrandFilter = By.cssSelector("label[class='vertical-filters-label common-customCheckbox']");

	private By byClearAllFilter = By.cssSelector("span.header-clearAllBtn");

	public SearchResultPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	public List<String> getProducTitles() {
		LOG.info("Validating product title at search result page");
		WaitFor waitFor = new WaitFor();
		waitFor.numberOfElementsToBeMoreThan(productTitle, 1);
		Keyword.pageRefresh();
		Keyword keyword = new Keyword();
		return keyword.getTexts(productTitles);

	}

	public List<String> getProducNames() {
		LOG.info("Validating product name at search result page");
		WaitFor waitFor = new WaitFor();
		waitFor.numberOfElementsToBeMoreThan(productName, 1);
		Keyword keyword = new Keyword();
		return keyword.getTexts(productNames);

	}

	public void clickOnFirstProduct() {
		LOG.info("Clicking on first product present at search result page");
		WaitFor waitFor = new WaitFor();
		waitFor.numberOfElementsToBeMoreThan(productTitle, 1);
		firstProduct.click();
	}

	public void verifyProducttitleContains(String expectedText) {
		LOG.info("Validating all product title at search result page");
		List<String> productTitles = getProducTitles();
		SoftAssert softly = new SoftAssert();
		for (String productTitle : productTitles) {
			LOG.info("Product title :" + productTitle);
			softly.assertTrue(productTitle.contains(expectedText));
		}
		softly.assertAll();
	}

	public void verifyProductNameContains(String expectedText) {
		LOG.info("Validating all product name at search result page");
		List<String> productNames = getProducNames();
		SoftAssert softly = new SoftAssert();
		for (String productName : productNames) {
			LOG.info("Product name :" + productName);
			Assert.assertTrue(productName.contains(expectedText));
		}
		softly.assertAll();
	}

	public String getFirstBrandFilterName() {
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(byBrandFilter);
		LOG.info("First brand filter name " + brandFilter.getText());
		return brandFilter.getText();
	}

	public void clickOnFirstBrandFilter() {
		LOG.info("Going to click on first brand filter");
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(byBrandFilter);
		brandFilter.click();
	}

	public void clickOnClearAllFilter() {
		LOG.info("Going to click on clear all filter");
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(byClearAllFilter);
		clearAllFilter.click();
	}

	public void searchItem() {
		productTitlesw.click();

	}

	public void clickOnFabricMenu() {
		fabricmenu.click();

	}

	public void clickOnAcrylickFabric() {
		Acrylikfabric.click();

	}
}
