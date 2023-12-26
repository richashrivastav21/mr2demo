package com.jarvis.stepdefinitions;

import com.jarvis.keywords.Keyword;
import com.jarvis.pages.CartPage;
import com.jarvis.pages.HomePage;
import com.jarvis.pages.LoginPage;
import com.jarvis.pages.ProductDetailPage;
import com.jarvis.pages.SearchResultPage;

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
	
	@Given("User is at women kurta listing page")
	public void clickOnWomenKurtasSuitsSection() {
		HomePage homePage = new HomePage();
		homePage.clickOnWomenKurtasSuitsSection();
	}

	@When("User clicks on clear filter")
	public void clickOnClearFilter() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.clickOnClearAllFilter();
	}
	
	@Then("User should get redirected to women kurta section")
	public void validateKurtaSectionUrl() {
		Keyword.validatePageUrl("https://www.myntra.com/women-kurtas-kurtis-suits");
	}
	
	@Given("User is at bed runner listing page")
	public void clickOnBedRunnersSection() {
		HomePage homePage = new HomePage();
		homePage.clickOnBedRunnersSection();
	}
	
	@When("User clicks on myntra logo")
	public void clickOnMyntraLogo() {
		HomePage homePage = new HomePage();
		homePage.clickOnMyntraLogo();
	}
	
	@Then("User should get redirected to home page")
	public void validateHomePageUrl() {
		Keyword.validatePageUrl("https://www.myntra.com/");
	}
	
	@When("User clicks on wishlist icon")
	public void clickOnWishlist() {
		HomePage homepage = new HomePage();
		homepage.clickOnWishlist();
	}
	
	@Then("Wishlist page should open")
	public void validateWishlistPageUrl() {
		Keyword.validatePageUrl("https://www.myntra.com/wishlist");
	}
	
	@When("User clicks on cart icon")
	public void clickOnBag() {
		HomePage homepage = new HomePage();
		homepage.clickOnBag();
	}
	
	@Then("Cart page should open")
	public void validateCartPage() {
		CartPage cartpage = new CartPage();
		cartpage.validateCartPage();
	}

}
