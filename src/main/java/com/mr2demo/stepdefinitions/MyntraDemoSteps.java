package com.mr2demo.stepdefinitions;

import com.mr2demo.keywords.Keyword;
import com.mr2demo.pages.HomePage;
import com.mr2demo.pages.LoginPage;
import com.mr2demo.pages.ProductDetailPage;
import com.mr2demo.pages.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyntraDemoSteps {

	@Given("Enter Levis in search component")
	public void enterProductToSearch() {
		HomePage homePage = new HomePage();
		homePage.enterProductToSearch("Levis");
	}

	@When("User clicks on search magnifier")
	public void clickOnSearchMagnifier() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchMagnifier();
	}

	@Then("All results populated must contains word Levis in it")
	public void assertResults() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProducttitleContains("Levis");
	}

	@When("User selects first product from product listing page")
	public void selectFirstProductFromListingPage() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.clickOnFirstProduct();
	}

	@Then("Product detail page of selected product should open")
	public void validateProductDetailPage() {
		Keyword keyword = new Keyword();
		String parentWindowHandle = keyword.getparentWindowHandle();
		keyword.switchToChildWindow();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.verifyProducDetailPageTitle("Levis");
		keyword.closeBrowser();
		keyword.switchToParentWindow(parentWindowHandle);
	}

	@Given("Browser is opened and url is launched completely")
	public void openBrowserAndLaunchurl() {
	}

	@When("User clicks on login link from profile section")
	public void clickOnLoginButton() {
		HomePage homePage = new HomePage();
		homePage.clickOnLogin();
	}

	@Then("Login page should open")
	public void validateLoginPage() {
		LoginPage loginPage = new LoginPage();
		loginPage.validateLoginPage();
	}

	@When("User clicks on mens t-shirts sections")
	public void clickOnTShirtsSection() {
		HomePage homePage = new HomePage();
		homePage.clickOnMenTshirtsSection();
	}

	@Then("Product which contains t-shirt in product name should be shown")
	public void validateProductName() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProductNameContains("T-shirt");
	}

	@Given("User is on lipstick section of beauty listing page")
	public void clickOnLipstickSection() {
		HomePage homePage = new HomePage();
		homePage.clickOnLipstickSection();
	}

	@When("Selects first brand filter from filter section")
	public void clickOnFirstBrandFilter() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.clickOnFirstBrandFilter();
	}

	@Then("Product of only selected brand should be shown at result page")
	public void validateProductTitle() {
		SearchResultPage resultPage = new SearchResultPage();
		String brandFilterName = resultPage.getFirstBrandFilterName().split("\\(")[0];
		resultPage.verifyProducttitleContains(brandFilterName);
	}
}
